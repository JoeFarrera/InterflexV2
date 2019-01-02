package es.sysmap.interflex.plcdriver;
import es.sysmap.interflex.gestortelegrama.ByteHelper;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLNode;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

public class Movi extends Telegrama
{

  public Movi()
  {
    super(4444);  // TODO Confundiendo idMovimiento y idTelegrama ?
    
  }
  
  
  public Movi (int idMovimiento,
    Posicion origen, 
    Posicion destino,
    byte tipCarga,
    byte tipMov,
    int pesTeorico,
    int pesReal,
    byte numCargas,
    byte transelevador,
    String matricula)
    {
      super(idMovimiento);  // TODO Confundiendo idMovimiento y idTelegrama ?
      this.idMovimiento = idMovimiento;
      this.origen = origen;
      this.destino = destino;
      this.tipCarga = tipCarga;
      this.tipMov =tipMov;
      this.tipoAltura = 0;  // TODO
      this.pesTeorico = pesTeorico;
      this.pesReal = pesReal;
      this.numCargas = numCargas;
      this.transelevador = transelevador;
      this.matricula = matricula;
      this.tolPeso = 22; // TODO
      this.codError = 33; // TODO
      this.enfardado = (byte)5;
      this.estadoOrden = (byte)6;
      this.posAct = 21;
      
      
      
    }
    
  /**
   * Identificador del movimiento
   */
  private int idMovimiento;
  private Posicion origen;
  private Posicion destino;
  /**
   * TODO: Confirmar tipos de carga
   * 1: Jaula
   * 2: ?
   * 3: ?
   * 4: Cubeta
   * 5: ?
   */
  private byte tipCarga;
  /**
   * 0: Normal
   * 1: Reubicación
   * 2: Cancelación
   */
  private byte tipMov;
  private int pesTeorico;
  private int pesReal;
  private byte tolPeso;
  private byte numCargas;
  /**
   * Determinar que representa este valor
   */
  private int reserva;
  private int posAct;
  /**
   * 1: Id repetido
   * 2: Mov reubicación no existe
   * 3: Movi de cancelación en curso y no se puede cancelar
   * 4: Pila llena
   * 5: Coord. Incoherentes
   * 6: Pendientes 25 o más AMOVs
   * 14: Origen no disponible
   * 15: Destino no disponible
   * 16: Origen fuera de rango
   * 17: Destino fuera de rango
   * 99: Tipo de movimiento no válido
   */
  private byte codError;
  /**
   * Bit 0: En curso
   * Bit 1: Terminado
   * Bit 2: Origen inhibido
   * Bit 3: Destino inhibido	
   */
  private byte estadoOrden;
  private byte transelevador;
  /**
   * TODO: Según interface, es de 16 posiciones
   */
  private String matricula;
  /**
   * TODO: Ver si es necesario
   */
  private byte tipoAltura;
  /**
   * TODO: Ver si es necesario
   */
  private byte enfardado;

  public String getTipoTel()
  {
    return "MOVI";
  }
  
  public String getAckTel()
  {
    return "AMOV";
  }
  
  public int getLenDatos()
  {
    return 48;  // tamaño del bloque de datos
  }
 
  /**
   * Construir array de bytes para la clase
   * @return 
   * @deprecated
   */
  public byte [] getBytes()
  {
    byte [] cabecera = super.getBytes();
    
    byte [] bytes = ByteHelper.concatenate (cabecera, ByteHelper.int4bytes(idMovimiento));
    
    bytes = ByteHelper.concatenate (bytes, origen.toByte());
    bytes = ByteHelper.concatenate (bytes, destino.toByte());
    
    // Inicializar los bytes restantes hasta el tamaño total del telegrama
    byte [] moreBytes = new byte [(Telegrama.MAX_HEADER + getLenDatos()) - bytes.length];
    
    for (int i = 0; i < moreBytes.length; i++)
      moreBytes [i] = 0;
      
    moreBytes [0] = tipCarga; // 16
    moreBytes [1] = tipMov;   // 17
    System.arraycopy(ByteHelper.int2bytes(pesTeorico), 0, moreBytes, 2, 2); // 18
    System.arraycopy(ByteHelper.int2bytes(pesReal), 0, moreBytes, 4, 2); // 20
    moreBytes [6] = tolPeso;  // 22
    moreBytes [7] = 1;  // Cant palets en SGI 23
    moreBytes [8] = 0;  // Num lote [0] en SGI 24
    moreBytes [9] = 0;  // Num lote [1] en SGI 25
    System.arraycopy(ByteHelper.int2bytes(posAct), 0, moreBytes, 10, 2); // 26
    moreBytes [12] = codError;  // 28
    moreBytes [13] = estadoOrden; // 29
    moreBytes [14] = transelevador; // 30
    byte [] matBytes = matricula.getBytes(); 
    System.arraycopy(matBytes, 0, moreBytes, 16, matBytes.length); // 32
    // what about tipo altura
    // what about the enfardadora
    // what about 4 more for reserva
    
    bytes = ByteHelper.concatenate (bytes, moreBytes);
    return bytes;
    
  }
  
  public XMLDocument writeXML()
  {
    XMLDocument xmldoc = super.writeXML();
    // Añadir detalles al tema

    Element det = xmldoc.createElement("Detalles");
    
    int iOffset = Telegrama.MAX_HEADER; // Para indexar cada atributo
  
    det.appendChild(createXMLAttribute(xmldoc, "numMovimiento", Integer.toString(idMovimiento), 0 + iOffset, 4, "int"));
    
    Element el = createXMLAttribute(xmldoc, "origen", Integer.toString(origen.getPosicionPlc()), 4 + iOffset, 2, "int");
    Element elpos = createXMLAttribute(xmldoc, "lado", Byte.toString(origen.getLado()), 6 + iOffset, 1, "byte");
    el.appendChild(elpos);
    elpos = createXMLAttribute(xmldoc, "columna", Byte.toString(origen.getColumna()), 7 + iOffset, 1, "byte");
    el.appendChild(elpos);
    elpos = createXMLAttribute(xmldoc, "nivel", Byte.toString(origen.getNivel()), 8 + iOffset, 1, "byte");
    el.appendChild(elpos);
    elpos = createXMLAttribute(xmldoc, "posUbicacion", Byte.toString(origen.getPosUbicacion()), 9 + iOffset, 1, "byte");
    el.appendChild(elpos);
    det.appendChild(el);
    
    el = createXMLAttribute(xmldoc, "destino", Integer.toString(destino.getPosicionPlc()), 10 + iOffset, 2, "int");
    elpos = createXMLAttribute(xmldoc, "lado", Byte.toString(destino.getLado()), 12 + iOffset, 1, "byte");
    el.appendChild(elpos);
    elpos = createXMLAttribute(xmldoc, "columna", Byte.toString(destino.getColumna()), 13 + iOffset, 1, "byte");
    el.appendChild(elpos);
    elpos = createXMLAttribute(xmldoc, "nivel", Byte.toString(destino.getNivel()), 14 + iOffset, 1, "byte");
    el.appendChild(elpos);
    elpos = createXMLAttribute(xmldoc, "posUbicacion", Byte.toString(destino.getPosUbicacion()), 15 + iOffset, 1, "byte");
    el.appendChild(elpos);
    det.appendChild(el);

    det.appendChild(createXMLAttribute(xmldoc, "tipCarga", Byte.toString(tipCarga), 16 + iOffset, 1, "byte"));
    det.appendChild(createXMLAttribute(xmldoc, "tipMov", Byte.toString(tipMov), 17 + iOffset, 1, "byte"));
    det.appendChild(createXMLAttribute(xmldoc, "pesTeorico", Integer.toString(pesTeorico), 18 + iOffset, 2, "int"));
    det.appendChild(createXMLAttribute(xmldoc, "pesReal", Integer.toString(pesReal), 20 + iOffset, 2, "int"));
    det.appendChild(createXMLAttribute(xmldoc, "tolPeso", Byte.toString(tolPeso), 22 + iOffset, 1, "byte"));
    det.appendChild(createXMLAttribute(xmldoc, "numCargas", Byte.toString(numCargas), 23 + iOffset, 1, "byte"));
    det.appendChild(createXMLAttribute(xmldoc, "numLote", Integer.toString(0), 24 + iOffset, 2, "int"));  // TODO - que es esto ?
    det.appendChild(createXMLAttribute(xmldoc, "posAct", Integer.toString(posAct), 26 + iOffset, 2, "int"));
    det.appendChild(createXMLAttribute(xmldoc, "codError", Byte.toString((byte)codError), 28 + iOffset, 1, "byte"));
    det.appendChild(createXMLAttribute(xmldoc, "estadoOrden", Byte.toString(estadoOrden), 29 + iOffset, 1, "byte"));
    det.appendChild(createXMLAttribute(xmldoc, "transelevador", Byte.toString(transelevador), 30 + iOffset, 1, "byte"));
    // TODO - hay un espacio aquí
    det.appendChild(createXMLAttribute(xmldoc, "matricula", matricula, 32 + iOffset, 10, "str"));
    // Faltan enfardado, tipo altura etc...
    
    xmldoc.getFirstChild().appendChild(det);

    try
      {
      PrintWriter pw = new PrintWriter(new FileOutputStream("myTelegrama.xml"));
      xmldoc.print(pw);
        
      } catch (Exception e)
      {
        e.printStackTrace();
      }

      return (xmldoc);
  }

  
  /**
   * leer cada atribute de un array de bytes, empezando en la primera posición
   * @param bytes array (sólo datos del MOVI)
   */
  public void read(byte [] bytes)
  {
    idMovimiento = ByteHelper.bytes2int(ByteHelper.getSubBytes(bytes, 0, 4));
    origen = new Posicion();
    origen.read(ByteHelper.getSubBytes(bytes, 4, 6));
    destino = new Posicion();
    destino.read(ByteHelper.getSubBytes(bytes, 10, 6));
    tipCarga = bytes [16];
    tipMov = bytes [17];
    pesTeorico = ByteHelper.bytes2int(ByteHelper.getSubBytes (bytes, 18, 2));
    pesReal = ByteHelper.bytes2int(ByteHelper.getSubBytes (bytes, 20, 2));
    tolPeso = bytes [22];
    // Cant palets en SGI
    // Num lote [0] en SGI
    // Num lote [1] en SGI
    posAct = ByteHelper.bytes2int(ByteHelper.getSubBytes(bytes, 26, 2));
    codError = bytes [28];
    estadoOrden = bytes [29];
    transelevador = bytes [30];
    matricula = new String(ByteHelper.getSubBytes(bytes, 32, 10));
    // what about tipo altura
    // what about the enfardadora
    // what about 4 more for reserva
  }
  
  
  public String toString ()
  {
    return "idMov: " + idMovimiento + " origen: " + origen.toString() + " destino: " + destino.toString() 
      + " tipCarga: " + tipCarga + " tipMov: " + tipMov + " posAct: " + posAct + " codError: " + codError + " estadoOrden: " + estadoOrden;
  }
}