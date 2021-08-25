package es.sysmap.interflex.etiquetes;
import java.util.Arrays;
import javax.comm.CommPortIdentifier;

/*
TEC BARCODE PRINTER JOB START
{D1232,1001,1232|}
{C|}
{PC001;0031,0576,1,1,A,00,B|}
{PC002;0031,0624,1,1,C,00,B|}
{PC003;0031,0670,1,1,A,00,B|}
{PC004;0031,0723,1,1,A,00,B|}
{PC005;0031,0900,1,1,A,00,B|}
{PC006;0350,0900,1,1,A,00,B,J0101|}
{PC007;0650,0900,1,1,A,00,B|}
{PC008;0525,0974,1,1,B,00,B,J0101|}
{PC009;0031,1050,1,1,A,00,B,J0101|}
{PC010;0700,1050,1,1,A,00,B|}
{RC001;80561|}
{RC002;CANDIA ELECTRICA, S.A.|}
{RC003;PEDROSA B 41-3 - POL.PEDROSA|}
{RC004;08908 HOSPITALET DE LLOBREGAT|}
{RC005;14.03.200  5|} 
{RC006;VC 343851|}
{RC007;Portes Debidos|}
{RC008;8|}
{RC009;NUESTROS MEDIOS|}
{RC010;O Kg|}
{XS;I,0001,0000C6101|}
TEC BARCODE PRINTER PAGE END
TEC BARCODE PRINTER JOB END
*/
/*
      tecPrinter.writeData("{PC001;0350,0528,1,1,A,00,B|}");
      tecPrinter.writeData("{PC002;0031,0596,1,1,C,00,B|}");
      tecPrinter.writeData("{PC003;0031,0642,1,1,A,00,B|}");
      tecPrinter.writeData("{PC004;0031,0695,1,1,A,00,B|}");
      tecPrinter.writeData("{PC005;0031,0743,1,1,A,00,B|}");
      tecPrinter.writeData("{PC006;0031,0900,1,1,A,00,B|}");
      tecPrinter.writeData("{PC007;0350,0900,1,1,A,00,B,J0101|}");
      tecPrinter.writeData("{PC008;0650,0900,1,1,A,00,B|}");
      tecPrinter.writeData("{PC009;0525,0974,1,1,B,00,B,J0101|}");
      tecPrinter.writeData("{PC010;0031,1050,1,1,A,00,B,J0101|}");
      tecPrinter.writeData("{PC011;0750,1050,1,1,A,00,B|}");
*/
/**
 * Michael 09.02.2006 Anadido campos para el tema de etiquetas con barras.
 * Michael 23.09.2009 Añadido campos y tratamiento etiqueta Ochoa
 */
public class EtiquetaPicking 
{
  private String idConsignatari = null;
  private String nomConsignatari = null;
  private String adreçaConsignatari_1 = null;
  private String adreçaConsignatari_2 = null;
  private String adreçaConsignatari_3 = null;
  private String data = null;
  private String albara = null;
  // Michael 29.03.2006
  private String albara_barras = null;
  private String ports = null;
  private String transportista = null;
  private String idBulto = null;
  private String pes = null;
  // Michael 09.02.2006 Campos de la tabla sgaetiqueta
  private String eti_plaza = null;
  private String eti_pais_origen = null;
  private String eti_cli_redur = null;
  private String eti_tipo_cb = null;
  private String eti_cod_postal = null;
  private String eti_pais_destino = null;
  // TODO 22.02.2006 for testing private...
  public boolean etiquetaBarras = false;
  // Michael 09.10.2006 Imprimir teléfono
  private String telefono = null;
  // Michael 23.09.2009 Ochoa
  private String ochoaExped = null;
  private String ochoaZona = null;
  private String ochoaEncaminamiento = null;
  private String ochoaTerminalProcedencia = "082";
  private String ochoaTerminalDestino = null;
  private String ochoaCodigoPlazaDest = null;
  private String ochoaCodigoPostal = null;
  private boolean etiquetaOchoa = false;
  
  private String redurPlaza = null;
  private String redurPaisDestino = "724"; // Sólo Espanya
  private String redurTrackingInterflex = "500051";
  private String redurProvincia = null;
  private String redurNAlbaranNumeric = null;
  private String redurCodigoPostal = null;
  private boolean etiquetaRedur = false;
  // Michael 12.09.2017 Ramoneda
  private String ramonedaRuta = null;
  private String ramonedaContador = null;
  private String ramonedaCodigoPostal;
  private boolean etiquetaRamoneda = false;
  String ramonedaBarcodeString;
  
  private String tdnZonaReparto = null;
  private String tdnCodDelegacion = null;
  private String tdnNumExped = null;
  private boolean tdnEtiqueta = false;
  
            
  
  
  
  
  
  
  public EtiquetaPicking()
  {
  }
  
  public void setIdConsignatari(String idConsignatari)
  {
    if (idConsignatari == null)
      this.idConsignatari = "";
    else
      this.idConsignatari = idConsignatari;
  }

  public String getIdConsignatari()
  {
    return ((idConsignatari != null) ? idConsignatari :  "");
  }
  
  public void setNomConsignatari(String nomConsignatari)
  {
    if (nomConsignatari == null)
      this.nomConsignatari = "";
    else
      this.nomConsignatari = nomConsignatari;
  }

  public String getNomConsignatari()
  {
    return ((nomConsignatari != null) ? nomConsignatari :  "");
  }

  public void setAdreçaConsignatari_1(String adreçaConsignatari_1)
  {
    if (adreçaConsignatari_1 == null)
      this.adreçaConsignatari_1 = "";
    else
      this.adreçaConsignatari_1 = adreçaConsignatari_1;
  }

  public String getAdreçaConsignatari_1()
  {
    return ((adreçaConsignatari_1 != null) ? adreçaConsignatari_1 :  "");
  }

  public void setAdreçaConsignatari_2(String adreçaConsignatari_2)
  {
    if (adreçaConsignatari_2 == null)
      this.adreçaConsignatari_2 = "";
    else
      this.adreçaConsignatari_2 = adreçaConsignatari_2;
  }

  public String getAdreçaConsignatari_2()
  {
    return ((adreçaConsignatari_2 != null) ? adreçaConsignatari_2 :  "");
  }

  public void setAdreçaConsignatari_3(String adreçaConsignatari_3)
  {
    if (adreçaConsignatari_3 == null)
      this.adreçaConsignatari_3 = "";
    else
      this.adreçaConsignatari_3 = adreçaConsignatari_3;
  }

  public String getAdreçaConsignatari_3()
  {
    return ((adreçaConsignatari_3 != null) ? adreçaConsignatari_3 :  "");
  }

  public void setData(String data)
  {
    if (data == null)
      this.data = "";
    else
      this.data = data;
  }

  public String getData()
  {
    return ((data != null) ? data :  "");
  }

  public void setAlbara(String albara)
  {
    if (albara == null)
      this.albara = "";
    else
      this.albara = albara;
  }

  public String getAlbara()
  {
    return ((albara != null) ? albara :  "");
  }

  public void setPorts(String ports)
  {
    if (ports == null)
      this.ports = "";
    else
      this.ports = ports;
  }

  public String getPorts()
  {
    return ((ports != null) ? ports :  "");
  }

  public void setTransportista(String transportista)
  {
    if (transportista == null)
      this.transportista = "";
    else
      this.transportista = transportista;
  }

  public String getTransportista()
  {
    return ((transportista != null) ? transportista :  "");
  }

  public void setIdBulto(String idBulto)
  {
    if (idBulto == null)
      this.idBulto = "";
    else
      this.idBulto = idBulto;
  }

  public String getIdBulto()
  {
    return ((idBulto != null) ? idBulto :  "");
  }
  
  public void setPes(String pes)
  {
    if (pes == null)
      this.pes = "";
    else
      this.pes = pes;
  }

  public String getPes()
  {
    return ((pes != null) ? pes :  "");
  }
  
  
  /**
   * Michael 08.02.2006 Comments added to code
   * @see <p>".pdf manual of printer: B-472-QQ/QP on file as: B472_lfm_12th.pdf"</p>
   * @see <p>"6.12 BAR CODE FORMAT COMMAND, and 6.15 BAR CODE DATA COMMAND"</p>
   * @param port
   */
  public void printEtiqueta(String port)
  {
 
  String feed = "0210";
 
 
    
    TecPrinter tecPrinter = new TecPrinter(port);
    if (tecPrinter != null && tecPrinter.isConnected())
    {
      tecPrinter.writeData("TEC BARCODE PRINTER JOB START");
      // Set the label size Pitch Width, Print Width, Print Height
      tecPrinter.writeData("{D1232,1001,1200|}");
      // Michael 25.06.2009 : NO - va a error... tecPrinter.writeData("{AX,+000,+210,+00|}");
      
      // Clear image buffer command
      tecPrinter.writeData("{C|}");
      // Michael 15.06.2009 Retroceso
      tecPrinter.writeData("{U2;" + "0100" + "|}");
      

      // Bitmap format command for each character string
      tecPrinter.writeData("{PC001;0350,0380,05,05,J,00,B|}");
      tecPrinter.writeData("{PC002;0051,0436,05,05,K,00,B,J0101|}");
      tecPrinter.writeData("{PC003;0051,0482,05,05,K,00,B|}");
      tecPrinter.writeData("{PC004;0051,0535,05,05,K,00,B|}");
      tecPrinter.writeData("{PC005;0051,0583,05,05,K,00,B|}");
      tecPrinter.writeData("{PC006;0051,0740,05,05,K,00,B|}");
      // tecPrinter.writeData("{PC007;0370,0740,05,05,K,00,B,J0101|}");
      tecPrinter.writeData("{PC007;0260,0740,10,10,K,00,B|}");
      tecPrinter.writeData("{PC008;0670,0740,05,05,K,00,B|}");
      // Michael tecPrinter.writeData("{PC009;0545,0880,05,05,K,00,B,J0101|}");
      tecPrinter.writeData("{PC009;0545,0820,05,05,K,00,B,J0101|}");
      tecPrinter.writeData("{PC010;0051,0880,05,05,K,00,B,J0101|}");
      tecPrinter.writeData("{PC011;0770,0880,05,05,K,00,B|}");
      // Michael 22.02.2006
      if (isEtiquetaBarras())
      {
        // Tracking...
        tecPrinter.writeData("{PC012;0051,0960,05,05,K,00,B|}");
        // Cod. Postal
        tecPrinter.writeData("{PC013;0580,0620,05,05,M,00,B|}");
        // eti_plaza
        tecPrinter.writeData("{PC014;0750,0620,05,05,M,00,B|}");
        
        // Michael 09.10.2006 Pon el teléfono si es etiqueta de barras
        tecPrinter.writeData("{PC015;0545,0380,05,05,J,00,B|}");
        
        
      }
      // Michael 24.09.2009 Etiqueta Ochoa
      else if (etiquetaOchoa)
      {
         // Nro. exped...
        tecPrinter.writeData("{PC012;0051,0960,05,05,K,00,B|}");
        // Encabezamiento / Zona (Label)
        tecPrinter.writeData("{PC013;0480,0575,05,05,I,00,B|}");
        // Encaminamiento / Zona (Values)
        tecPrinter.writeData("{PC014;0380,0620,05,05,M,00,B|}");
        
 
      }
      else if (etiquetaRedur)
      {
        // Nr. Exped: 
        tecPrinter.writeData("{PC012;0051,0910,05,05,I,00,B|}");
        // Código postal
        tecPrinter.writeData("{PC013;0370,0620,05,05,M,00,B|}");
        // Plaza
        tecPrinter.writeData("{PC014;0670,0620,10,10,M,00,B|}");
      }
      else if (etiquetaRamoneda)
      {
        // Código postal - No hace falta
        // tecPrinter.writeData("{PC013;0370,0620,05,05,M,00,B|}");
        // Ruta
        tecPrinter.writeData("{PC014;0370,0620,10,10,M,00,W|}");
        // Punto en etiquea para indicar que és Ramoneda
        //tecPrinter.writeData("{PC016;0850,0410,10,10,M,00,W|}");
        
      }
      
      // Michael 26.10.2010 Pon el teléfono en todas etiquetas
      tecPrinter.writeData("{PC015;0545,0380,05,05,J,00,B|}");

 
      
      tecPrinter.writeData("{RC001;" + getIdConsignatari() + "|}");
      tecPrinter.writeData("{RC002;" + getNomConsignatari() + "|}");
      tecPrinter.writeData("{RC003;" + getAdreçaConsignatari_1() + "|}");
      tecPrinter.writeData("{RC004;" + getAdreçaConsignatari_2() + "|}");
      tecPrinter.writeData("{RC005;" + getAdreçaConsignatari_3() + "|}");
      tecPrinter.writeData("{RC006;" + getData() + "|}");
      tecPrinter.writeData("{RC007;" + getAlbara() + "|}");
      tecPrinter.writeData("{RC008;" + getPorts() + "|}");
      tecPrinter.writeData("{RC009;" + getIdBulto() + "|}");
      tecPrinter.writeData("{RC010;" + getTransportista() + "|}");
      tecPrinter.writeData("{RC011;" + getPes() + " Kg|}");
      // Michael 22.02.2006
      
      if (isEtiquetaBarras())
      {
         
        tecPrinter.writeData("{RC012;Tracking: " + getEti_pais_origen() + " " 
          + getEti_cli_redur() + " " + getAlbara_barras() + "|}");
        // TODO 22.02.2006 Debe ser cabeceras.cab_cod_postal
        if (getEti_cod_postal() != null)
          tecPrinter.writeData("{RC013;" + getEti_cod_postal().substring(0,5) + "|}");
        else
          tecPrinter.writeData("{RC013;" + " " + "|}");
        tecPrinter.writeData("{RC014;" + getEti_plaza() + "|}");

      }
      
      // Michael 09.02.2006 TODO: Ampliar código postal. Poner eti_plaza en texto. Añadir código de barras en 128 autoswitch 'C'
      if (isEtiquetaBarras())
      {
        // tecPrinter.writeData("{XB00;0100,1050,9,2,03,0,0050|}");
        // Número bulto debe tener padding hasta 3 dígitos
        String barcodeData = getEti_tipo_cb() + getEti_cod_postal() + getEti_pais_destino()
          + getEti_pais_origen() + getEti_cli_redur() + getAlbara_barras()
          + pad(getIdBulto(), 3);
          
        // for text below barcode: tecPrinter.writeData("{XB00;0100,1070,9,2,03,0,0100,+0000000000,000,1,00|}");
        // Michael 29.03.2006 increase height to 0200 tecPrinter.writeData("{XB00;0100,1070,9,2,03,0,0100,+0000000000,000,0,00|}"); // No text below barcode
        tecPrinter.writeData("{XB00;0051,0980,9,2,03,0,0150,+0000000000,000,0,00|}"); // No text below barcode
        // pruebas ... tecPrinter.writeData("{RB00;" +"1085200007247251014412345612" + "|}");
        tecPrinter.writeData("{RB00;" + barcodeData + "|}");
       }
       else if (etiquetaOchoa)
       {
         tecPrinter.writeData("{RC012;No. de Expedicion: " + ochoaExped + "|}");
         
         tecPrinter.writeData("{RC013;Encaminamiento / Zona|}");
         
         tecPrinter.writeData("{RC014;" + ochoaEncaminamiento + " / " + ochoaZona + "|}");
         

        String cp =  null;
         if (ochoaCodigoPostal != null && ochoaCodigoPostal.length() >= 5)
         {
           cp = ochoaCodigoPostal.substring(2, 5);
         }
         else
          cp = "000";

         String barcodeData = ochoaTerminalProcedencia + ochoaExped + ochoaCodigoPlazaDest + cp + pad(getIdBulto(), 3);
          
        // for text below barcode: tecPrinter.writeData("{XB00;0100,1070,9,2,03,0,0100,+0000000000,000,1,00|}");
       
        // Michael 24.09.2009 To increase width tecPrinter.writeData("{XB00;0051,0980,9,2,03,0,0150,+0000000000,000,0,00|}"); // No text below barcode
        tecPrinter.writeData("{XB00;0051,0980,9,2,04,0,0150,+0000000000,000,0,00|}"); // No text below barcode
        // pruebas ... tecPrinter.writeData("{RB00;" +"1085200007247251014412345612" + "|}");
        tecPrinter.writeData("{RB00;" + barcodeData + "|}");
         
        
       }
       else if (etiquetaRedur)
       {
       
         redurCodigoPostal = redurCodigoPostal != null ? redurCodigoPostal : "";
         tecPrinter.writeData("{RC013;" + redurCodigoPostal + "|}");
         tecPrinter.writeData("{RC014;" + redurProvincia + "|}");
   
          // Tracking: 50005100386174 (aquest numero es el albarà), les dades anterior al nºalbara son sempre igual. (longitud total 14)
         tecPrinter.writeData("{RC012;Tracking: " + redurTrackingInterflex + getRedurNAlbaranNumeric() + "|}");
   
         // Barcode 1 36415(codi postal) 00072450005100386174(nºtracking)001(nºbulto)
         String codPostal = paddingString(redurCodigoPostal, 8, '0', false);
         String barcodeData = "1" + codPostal + redurPaisDestino + redurTrackingInterflex +  getRedurNAlbaranNumeric() + pad(getIdBulto(), 3);
         tecPrinter.writeData("{XB00;0100,0940,9,2,03,0,0220,+0000000000,000,0,00|}"); // No text below barcode
         // pruebas ... tecPrinter.writeData("{RB00;" +"1085200007247251014412345612" + "|}");
         tecPrinter.writeData("{RB00;" + barcodeData + "|}");
  
       }
       // Michael 13.09.2017
       else if (etiquetaRamoneda)
       {
         // No hace falta tecPrinter.writeData("{RC013;" + ramonedaCodigoPostal + "|}");
 
         tecPrinter.writeData("{RC014;" + ramonedaRuta + "|}");
 
         tecPrinter.writeData("{XB00;0200,0940,9,2,03,0,0220,+0000000000,000,0,00|}"); // No text below barcode
         tecPrinter.writeData("{RB00;" + getRamonedaBarcodeString() + "|}");
         // tecPrinter.writeData("{RC016;RDA|}");

       }
        // Michael 27.10.2010 Pon el teléfono si es etiqueta de barras
        if (getTelefono() != null && getTelefono().length() > 0)
          tecPrinter.writeData("{RC015;Tfno: " + getTelefono() + "|}");

       
      // Issue command (issue labels according to print conditions programmed
      // tecPrinter.writeData("{XS;I,0001,0000C6101|}"); // Michael 15.06.2009 Paper is continuous with interlabel ident.
      tecPrinter.writeData("{XS;I,0001,0003C6101|}");
      // Michael 15.06.2009 Feed for tearing
      tecPrinter.writeData("{U1;" + feed + "|}");
      tecPrinter.writeData("TEC BARCODE PRINTER PAGE END");
      tecPrinter.writeData("TEC BARCODE PRINTER JOB END");
      tecPrinter.closePort();
    }
  }
  
  public static void main(String[] args) 
  {
    
    EtiquetaPicking etiqueta = new EtiquetaPicking();
    etiqueta.setIdConsignatari("12345");
    etiqueta.setNomConsignatari("CANDIA ELECTRICA, S.A.");
    etiqueta.setAdreçaConsignatari_1("PEDROSA B 41 - 3 - POL. PEDROSA");
    etiqueta.setAdreçaConsignatari_2("08908 HOSPITALET DE LLOBREGAT");
    etiqueta.setAdreçaConsignatari_3("BARCELONA");
    etiqueta.setData("14.03.2005");
    etiqueta.setAlbara("VC 343851");
    etiqueta.setPorts("Portes Debidos");
    etiqueta.setTransportista("Redur");
    etiqueta.setIdBulto("8");
    etiqueta.setPes("0");
    
    // Michael 22.02.2006
    etiqueta.etiquetaBarras = true;
    etiqueta.setEti_tipo_cb("1");
    etiqueta.setEti_cod_postal("08520000");
    etiqueta.setEti_pais_destino("724");
    etiqueta.setEti_pais_origen("725");
    etiqueta.setEti_cli_redur("10144");
    etiqueta.setAlbara("123456"); // TODO - será numérico
    etiqueta.setEti_plaza("BAR");
    
    etiqueta.setTelefono("+34 973622247");
    
    etiqueta.printEtiqueta("LPT1");
  }

  public String getEti_cli_redur()
  {
    return eti_cli_redur;
  }

  public void setEti_cli_redur(String eti_cli_redur)
  {
    this.eti_cli_redur = eti_cli_redur;
  }

  public String getEti_cod_postal()
  {
    return eti_cod_postal;
  }

  public void setEti_cod_postal(String eti_cod_postal)
  {
    this.eti_cod_postal = eti_cod_postal;
  }

  public String getEti_pais_destino()
  {
    return eti_pais_destino;
  }

  public void setEti_pais_destino(String eti_pais_destino)
  {
    this.eti_pais_destino = eti_pais_destino;
  }

  public String getEti_pais_origen()
  {
    return eti_pais_origen;
  }

  public void setEti_pais_origen(String eti_pais_origen)
  {
    this.eti_pais_origen = eti_pais_origen;
  }

  public String getEti_plaza()
  {
    return eti_plaza;
  }

  public void setEti_plaza(String eti_plaza)
  {
    this.eti_plaza = eti_plaza;
  }

  public String getEti_tipo_cb()
  {
    return eti_tipo_cb;
  }

  public void setEti_tipo_cb(String eti_tipo_cb)
  {
    this.eti_tipo_cb = eti_tipo_cb;
  }

  public boolean isEtiquetaBarras()
  {
    return etiquetaBarras;
  }

  public void setEtiquetaBarras(boolean etiquetaBarras)
  {
    this.etiquetaBarras = etiquetaBarras;
  }
  
  
  private static String pad (final String src, final int n)
  {
    if (src == null)
      return null;
    String res = new String(src);
    int len = res.length();
    for (int i = 1; i <= (n - len); i++)
    {
      res = "0" + res;
    }
    return res;
  }           

  public String getAlbara_barras()
  {
    return albara_barras;
  }

  public void setAlbara_barras(String albara_barras)
  {
    this.albara_barras = albara_barras;
  }

  public String getTelefono()
  {
    return ((telefono != null) ? telefono :  "");
  }

  public void setTelefono(String telefono)
  {
    this.telefono = telefono;
  }

  public String getOchoaEncaminamiento()
  {
    return ochoaEncaminamiento;
  }

  public void setOchoaEncaminamiento(String ochoaEncaminamiento)
  {
    this.ochoaEncaminamiento = ochoaEncaminamiento;
  }

  public String getOchoaExped()
  {
    return ochoaExped;
  }

  public void setOchoaExped(String ochoaExped)
  {
    this.ochoaExped = paddingString(ochoaExped, 8, '0', true);
  }
  
  
  public String getOchoaZona()
  {
    return ochoaZona;
  }

  public void setOchoaZona(String ochoaZona)
  {
    this.ochoaZona = ochoaZona;
  }
  
  /**
  * Pads a String <code>s</code> to take up <code>n</code>
  * characters, padding with char <code>c</code> on the
  * left (<code>true</code>) or on the right (<code>false</code>).
  * Returns <code>null</code> if passed a <code>null</code>
  * String.
  **/
  public static String paddingString(String s, int n, char c,
     boolean paddingLeft) {
   if (s == null) {
     return s;
   }
   int add = n - s.length(); // may overflow int size... should not be a problem in real life
   if(add <= 0){
     return s;
   }
   StringBuffer str = new StringBuffer(s);
   char[] ch = new char[add];
   Arrays.fill(ch, c);
   if(paddingLeft){
     str.insert(0, ch);
   } else {
     str.append(ch);
   }
   return str.toString();
  }

  public String getOchoaTerminalDestino()
  {
    return ochoaTerminalDestino;
  }

  public void setOchoaTerminalDestino(String ochoaTerminalDestino)
  {
    this.ochoaTerminalDestino = ochoaTerminalDestino;
  }

  public String getOchoaTerminalProcedencia()
  {
    return ochoaTerminalProcedencia;
  }

  public void setOchoaTerminalProcedencia(String ochoaTerminalProcedencia)
  {
    this.ochoaTerminalProcedencia = ochoaTerminalProcedencia;
  }

  public String getOchoaCodigoPlazaDest()
  {
    return ochoaCodigoPlazaDest;
  }

  public void setOchoaCodigoPlazaDest(String ochoaCodigoPlazaDest)
  {
    this.ochoaCodigoPlazaDest = ochoaCodigoPlazaDest;
  }

  public void setEtiquetaOchoa(boolean etiquetaOchoa)
  {
    this.etiquetaOchoa = etiquetaOchoa;
  }

  public void setOchoaCodigoPostal(String ochoaCodigoPostal)
  {
    this.ochoaCodigoPostal = ochoaCodigoPostal;
  }



  public String getRedurPlaza()
  {
    return redurPlaza;
  }

  public void setRedurPlaza(String redurPlaza)
  {
    this.redurPlaza = redurPlaza;
  }

  public String getRedurProvincia()
  {
    return redurProvincia;
  }

  public void setRedurProvincia(String redurProvincia)
  {
    this.redurProvincia = redurProvincia;
  }

  public boolean isEtiquetaRedur()
  {
    return etiquetaRedur;
  }

  public void setEtiquetaRedur(boolean etiquetaRedur)
  {
    this.etiquetaRedur = etiquetaRedur;
  }

  public String getRedurNAlbaranNumeric()
  {
    return redurNAlbaranNumeric;
  }

  public void setRedurNAlbaranNumeric(String redurNAlbaranNumeric)
  {
    // Should be 8 in length
    this.redurNAlbaranNumeric = paddingString(redurNAlbaranNumeric, 8, '0', true);
  }

  public String getRedurCodigoPostal()
  {
    return redurCodigoPostal;
  }

  public void setRedurCodigoPostal(String redurCodigoPostal)
  {
    this.redurCodigoPostal = redurCodigoPostal;
  }

  public String getRamonedaContador()
  {
    return ramonedaContador;
  }

  public void setRamonedaContador(String ramonedaContador)
  {
    this.ramonedaContador = ramonedaContador;
  }

  public String getRamonedaRuta()
  {
    return ramonedaRuta;
  }

  public void setRamonedaRuta(String ramonedaRuta)
  {
    this.ramonedaRuta = ramonedaRuta;
  }

  public String getRamonedaCodigoPostal()
  {
    return ramonedaCodigoPostal;
  }

  public void setRamonedaCodigoPostal(String ramonedaCodigoPostal)
  {
    this.ramonedaCodigoPostal = ramonedaCodigoPostal;
  }

  public void setEtiquetaRamoneda(boolean etiquetaRamoneda)
  {
    this.etiquetaRamoneda = etiquetaRamoneda;
  }

  public String getRamonedaBarcodeString()
  {
    return ramonedaBarcodeString;
  }

  public void setRamonedaBarcodeString(String ramonedaBarcodeString)
  {
    this.ramonedaBarcodeString = ramonedaBarcodeString;
  }

  public void setTdnZonaReparto(String tdnZonaReparto)
  {
    this.tdnZonaReparto = tdnZonaReparto;
  }
  
  public void setTdnCodDelegacion(String tdnCoddelegacion)
  {
    this.tdnCodDelegacion = tdnCoddelegacion;
  }
  
  public void setTdnNumExped(String tdnNumExped)
  {
    this.tdnNumExped = tdnNumExped;
  }
  
  public void setEtiquetaTdn(boolean tdnEtiqueta)
  {
    tdnEtiqueta = tdnEtiqueta;
  }
           



    
}
