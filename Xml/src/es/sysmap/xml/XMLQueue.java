package es.sysmap.xml;

import oracle.xml.parser.v2.*;
import java.sql.*;
import oracle.AQ.*;
import java.io.*;
import org.xml.sax.SAXException;
//import XMLQueueEmptyException;
//import oracle.jbo.server.DBTransaction;
//import oracle.jbo.server.ApplicationModuleImpl;


public class XMLQueue 
{
  private Connection conn = null;
  private AQSession  sess = null;
  private AQQueue   queue = null;
  private String sgaCorrelation = null;
  private String rdCorrelation = null;

  // Constructing an XMLQueue "binds" its to a particular AQ Queue
  public XMLQueue(Connection conn, String schema, String queueName, 
                  String sgaCorrelation, String rdCorrelation)
                  throws AQException,SQLException 
  {
    this.conn = conn;
    conn.setAutoCommit(false);
    // Create the AQ Driver
    AQOracleDriver driver = new AQOracleDriver();
    // Create a new session to work in
    sess = AQDriverManager.createAQSession(conn);
    // Get a handle to the requested queue
    queue = sess.getQueue (schema,queueName);

    this.sgaCorrelation = sgaCorrelation;
    this.rdCorrelation = rdCorrelation;
  }

  // Enqueue an XMLDocument to the queue
  public void enqueue( XMLDocument xmldoc, int priority ) 
                      throws AQException,IOException,
                             SQLException 
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // Print the XML document to serialize it as XML Markup
    xmldoc.print(baos);
    // Get the bytes to enqueue into the "Raw" message
    byte[] messageBytes = baos.toByteArray();
    // Ask the queue to create an empty message
    AQMessage message = queue.createMessage();
    // Get a hold of the Raw Payload "bay" to write the message into
    AQRawPayload payload = message.getRawPayload();
    // Set the contents of the payload to be the bytes of our XML Message
    payload.setStream(messageBytes,messageBytes.length);
    // Set correlation property...
    AQMessageProperty mp = new AQMessageProperty ();
    mp.setCorrelation(rdCorrelation);
    // Set priority property...
    mp.setPriority(priority);
    message.setMessageProperty(mp);

    // Send the new message on its way into the queue
    queue.enqueue(new AQEnqueueOption(),message);
    // Sign, seal, and deliver. 
    System.out.println("Haciendo commit en XMLQueue");
    conn.commit();
  }

  // Dequeue and return an XMLDocument from the queue
  public XMLDocument dequeue(boolean wait, byte [] msgId) throws AQException,
                                                  SQLException,
                                                  XMLQueueEmptyException 
  {
    AQDequeueOption dqOpt = new AQDequeueOption();
    // If user asked NOT to wait, then set this flag in the Dequeue Options
    if (!wait) 
    {
      //dqOpt.setWaitTime(AQDequeueOption.WAIT_NONE);
      dqOpt.setWaitTime(1);
    }
    AQMessage message = null;
    if (msgId != null)
      dqOpt.setMessageId(msgId);
    else
      dqOpt.setCorrelation(sgaCorrelation);
    dqOpt.setNavigationMode(AQDequeueOption.NAVIGATION_FIRST_MESSAGE);
    try 
    {
      // Try to dequeue the message
      message = queue.dequeue(dqOpt);
    }
    catch (oracle.AQ.AQOracleSQLException aqx) 
    {
     // If we get an error 25228 then queue was empty and we didnt want to wait
     if (java.lang.Math.abs(aqx.getErrorCode()) == 25228) 
     {
       throw new XMLQueueEmptyException();
     }
    }
    // Retrieve the Raw Payload "bay" from the message
    AQRawPayload payload = message.getRawPayload();
    // Create an InputStream on the bytes in the message
    ByteArrayInputStream bais = new ByteArrayInputStream(payload.getBytes());

    String mensaje = new String (payload.getBytes());
    System.out.println("Mensaje recibido: " + mensaje);

    XMLDocument dequeuedDoc = null;
    try 
    {
      // Parse the XML message
      dequeuedDoc = XMLHelper.parse(bais,null);
    }
    catch (Exception spe) 
    { /* Ignore, doc will be null */ }
    // Finalize the transactional dequeue operation by committing
    // Fem el commit des de un altre lloc
    //conn.commit();
    // System.out.println ("Rolling back for testing");
    // conn.rollback();
    
    // Return the XMLDocument
    return dequeuedDoc;
  }

  // Browse Dequeue and return a MsgId from the queue
  public AQMessage browse(boolean wait) throws AQException,
                                                  SQLException,
                                                  XMLQueueEmptyException 
  {
    AQDequeueOption dqOpt = new AQDequeueOption();
    // If user asked NOT to wait, then set this flag in the Dequeue Options
    if (!wait) 
    {
      //dqOpt.setWaitTime(AQDequeueOption.WAIT_NONE);
      dqOpt.setWaitTime(1);
    }
    AQMessage message = null;
    dqOpt.setDequeueMode(AQDequeueOption.DEQUEUE_BROWSE);
    dqOpt.setCorrelation(sgaCorrelation);
    try 
    {
      // Try to dequeue the message
      message = queue.dequeue(dqOpt);
    }
    catch (oracle.AQ.AQOracleSQLException aqx) 
    {
     // If we get an error 25228 then queue was empty and we didnt want to wait
     if (java.lang.Math.abs(aqx.getErrorCode()) == 25228) 
     {
        throw new XMLQueueEmptyException();
     }
    }
    // Finalize the transactional dequeue operation by committing
    conn.commit();
    // System.out.println ("Rolling back for testing");
    // conn.rollback();
    
    // Return the XMLDocument
    return message;
  }

}
