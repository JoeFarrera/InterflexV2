package es.sysmap.interflex.etiquetes;

import java.io.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import javax.print.event.*;
import javax.print.DocFlavor.*;

import sgalib.SgaUtilPuesto;

/**
 * Només es aqui per si falla TecPrinter que escriu directament al port LPT1
 * sense utilitzar cap fitxer
 * Si funciona el TecPrinter, aquest s'hauria d'esborrar
 */

public class TecPrinterFile
{
  // Es construeix l'especificació de la petició d'imprimir
  private DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
  private PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
  private DocPrintJob pj = null;
  private File file = null;
  private PrintWriter fos = null;

  public TecPrinterFile()
  {

    // Localitzar les impresores que poden imprimir aquesta especificació

    PrintService[] pservices = PrintServiceLookup.lookupPrintServices(flavor, aset);

    if (pservices.length > 0)
    {
      int i = 0;
      int selected = 0;

      // Selecció de la impresora Zebra

      while (i < pservices.length)
      {
        if (pservices[i].getName().equals(SgaUtilPuesto.getInstance().getProperty("BCPrinter")))
          selected = i;
        i++;
      }
      // Creem un treball d'impressió pel servei escollit

      System.out.println("Impresora selecccionada " + pservices[selected].getName());
      pj = pservices[selected].createPrintJob();
      try
      {
        // Creem un fitxer temporal per escriure-hi i passar-lo despres a la
        // impresora

        file = File.createTempFile("zebra", null);
        //file.createNewFile();
        fos = new PrintWriter(new FileWriter(file));
      }
      catch (IOException ie)
      {
        System.err.println(ie);
      }
    }
  }

  public void etiquetaExistencies(String idExist, String idArt, String idProv, String descrip, String descprov, String canTot, String uniMed, String fecRec, String loteProv, String ubicacion)
  {
    // Inicialitzem l'etiqueta
    //writeLine("^XA^LH10,10^FWN^CFA,20~SD30^BY2"); Contraste a 30
    writeLine("^XA^LH10,10^FWN^CFA,20^BY2");//Por defecto la máquina

    //Linea 1
      // Material
      writeLine("^FO40,38^AE^FDMat:^FS");
      writeLine("^FO110,30^AEN,50,24^FD" + idArt + "^FS");
     

    //Linea 2 +15dots
      //Descripció
      writeLine("^FO40,133^AD^FDDenom.:^FS");
      writeLine("^FO160,125^AE^FD" + descrip +"^FS");

    //Linea 3 +15dots
      //Proveidor
      writeLine("^FO40,168^AD^FDProveedor:^FS");
      writeLine("^FO530,160^AE^FD" + idProv +"^FS"); 

    //Linea 4 +30dots
      //Quantitat
      writeLine("^FO40,208^AD^FDCantidad:^FS");
      writeLine("^FO180,200^AE^FD" + canTot +"^FS");
      //Unimed
      writeLine("^FO370,200^AE^FD" + uniMed +"^FS");

    //Linea 5 +20dots
      //Data recepció
      writeLine("^FO40,238^AD^FDFecha EM:^FS");
      writeLine("^FO170,230^AF^FD" + fecRec +"^FS");
      //Lot proveidor
      writeLine("^FO370,238^AD^FDAlbaran Prov:^FS");
      writeLine("^FO530,230^AF^FD" + loteProv +"^FS");

    //Linea 5
      //Matrícula
      writeLine("^FO40,270^AD^FDIdentificador de Existencia:^FS");
      
      writeLine("^FO450,270^AD^FDUbicacion Entrada:^FS");
      //TODO +ubicacionPlayaEntrada 
      writeLine("^FO120,310^B3,,250,Y^FD" + idExist +"^FS");

    //Finalitzem l'etiqueta
    writeLine("^XZ");
  }

/*  public void etiquetaExistencies(String idExist, String idArt, String idProv, String descrip, String descprov, String canTot, String uniMed, String fecRec, String loteProv, String ubicacion)
  {
    // Inicialitzem l'etiqueta
    //writeLine("^XA^LH10,10^FWN^CFA,20~SD30^BY2"); Contraste a 30
    writeLine("^XA^LH10,10^FWN^CFA,20^BY2");//Por defecto la máquina

    //Linea 1
      // Material
      writeLine("^FO40,38^AD^FDMat:^FS");
      writeLine("^FO110,30^AEN,50,24^FD" + idArt + "^FS");
     

    //Linea 2 +15dots
      //Descripció
      writeLine("^FO40,133^AD^FDDenom.:^FS");
      writeLine("^FO160,125^AE^FD" + descrip +"^FS");

    //Linea 3 +15dots
      //Proveidor
      writeLine("^FO40,168^AD^FDProveedor:^FS");
      writeLine("^FO530,160^AE^FD" + idProv +"^FS"); 

    //Linea 4 +30dots
      //Quantitat
      writeLine("^FO40,208^AD^FDCantidad:^FS");
      writeLine("^FO180,200^AE^FD" + canTot +"^FS");
      //Unimed
      writeLine("^FO370,200^AE^FD" + uniMed +"^FS");

    //Linea 5 +20dots
      //Data recepció
      writeLine("^FO40,238^AD^FDFecha EM:^FS");
      writeLine("^FO170,230^AF^FD" + fecRec +"^FS");
      //Lot proveidor
      writeLine("^FO370,238^AD^FDAlbaran Prov:^FS");
      writeLine("^FO530,230^AF^FD" + loteProv +"^FS");

    //Linea 5
      //Matrícula
      writeLine("^FO40,270^AD^FDIdentificador de Existencia:^FS");
      
      writeLine("^FO450,270^AD^FDUbicacion Entrada:^FS");
      //TODO +ubicacionPlayaEntrada 
      writeLine("^FO120,310^B3,,105,Y^FD" + idExist +"^FS");

    //Finalitzem l'etiqueta
    writeLine("^XZ");
  }
*/

  public void etiquetaMAC(String idMac, String descrip)
  {
    // Inicialitzem l'etiqueta
    //writeLine("^XA^LH10,10^FWN^CFA,20^BY4,2.0");//Orientación Horizontal
    writeLine("^XA^LH10,10^FWR^CFA,20^BY4,2.0");//Orientación Vertical
    // MAC
    //writeLine("^FO130,10^AD^FDIdentificador de MAC:^FS");
    writeLine("^FO600,80^AD^FDTipo de Contenedor:^FS");
    writeLine("^FO500,80^AD^FD"+ descrip + "^FS");
    //writeLine("^FO100,60^B3,,370,Y^FD" + idMac +"^FS");
     //writeLine("^FO100,60^BI,370,Y^FD" + idMac +"^FS");
    writeLine("^FO50,60^BJ,370,Y^FD" + idMac +"^FS");
    //Finalitzem l'etiqueta
    writeLine("^XZ");
  }


  public void writeLine(String line)
  {
      fos.println(line);
  }

  public void printFile()
  {
    try
    {
      fos.close();
      FileInputStream fis = new FileInputStream(file);
      Doc doc = new SimpleDoc(fis, flavor, null);

      // Imprimim el document

      pj.print(doc, aset);

      //Eliminem el fitxer temporal
      //file.delete();
    }
    catch (IOException ie)
    {
      System.err.println(ie);
    }
    catch (PrintException e)
    {
      System.err.println(e);
    }
  }


  public static void main (String[] args)
  {
    TecPrinterFile tecPrinterFile = new TecPrinterFile();
    tecPrinterFile.etiquetaExistencies("50000000027028", "5650022550", "", "RESISTENCIA GRILL DOBLE 230V 2300W", "", "00000230", "UN", "06.02.2004", "", "EXTERNAL");
    tecPrinterFile.printFile();
  }
}