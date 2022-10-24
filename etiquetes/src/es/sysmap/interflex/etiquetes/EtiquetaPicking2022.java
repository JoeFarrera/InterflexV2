package es.sysmap.interflex.etiquetes;

public class EtiquetaPicking2022 
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
  public boolean etiquetaBarras = false;
  private String telefono = null;


  
  private String tdnZonaReparto = null;
  private String tdnCodDelegacion = null;
  private String tdnNumExped = null;
  private boolean etiquetaTdn = false;
  private String tdnBarcodeString;
  
  public EtiquetaPicking2022()
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
    etiquetaTdn = tdnEtiqueta;
  }
           
           
   public void setTdnBarcodeString(String tdnBarcodeString)
   {
     this.tdnBarcodeString = tdnBarcodeString;
   }
  public void PrintEtiquetaCabeos5(String port) throws Exception
  {
    // For CAB EOS5 Printers see: cab_programming_manual_x4.pdf
    TecPrinter tecPrinter = new TecPrinter(port);
    if (tecPrinter != null && tecPrinter.isConnected())
    {
      // Set milimetres
      tecPrinter.writeData("m m");
      // Jobstart
      tecPrinter.writeData("J");
      // Heat (speed) setting (100mm/sec)
      tecPrinter.writeData("H 100");
      // Size of the label
      tecPrinter.writeData("l1;0,0,116,120,100");
      // Orientation
      tecPrinter.writeData("O R");
      // If TDN, print "TDN" on upper corner, in reverse
      // TODO
      if (etiquetaTdn)
        tecPrinter.writeData("T 80,05,0,596,pt20,n;TDN");
        
      tecPrinter.writeData("T 40, 31, 0, 3, pt14;" + getIdConsignatari());
      tecPrinter.writeData("T 5,40,0,3,pt15,b;" + getNomConsignatari());
      tecPrinter.writeData("T 5,45,0,3,pt15,b" + getAdreçaConsignatari_1());
      tecPrinter.writeData("5,50,0,3,pt15,b;" + getAdreçaConsignatari_2());
      tecPrinter.writeData("5,55,0,3,pt15,b;" + getAdreçaConsignatari_3());

      tecPrinter.writeData("T 5,68,0,3,pt12;" + getData());
      tecPrinter.writeData("T 30,68,0,3,pt18;" + getAlbara());     
      tecPrinter.writeData("T 67,68,0,3,pt12;" + getPorts());
      tecPrinter.writeData("T 60,75,0,3,pt12,b;" + getIdBulto());
      tecPrinter.writeData("T 5,80,0,3,pt13;" + getTransportista());
      // tecPrinter.writeData("T 5,83,0,3,pt7;Tracking: 5005100302255 // TODO - No tracking??
      tecPrinter.writeData("T 72,81,0,3,pt12,b;" + getPes());
      if (etiquetaTdn)
      {
        tecPrinter.writeData("T 47,55,0,3,pt15,b;" + tdnZonaReparto); // TODO ?? TDN
        tecPrinter.writeData("T 75,55,0,3,pt20,b;" + tdnCodDelegacion); // TODO ?? TDN
        tecPrinter.writeData("B 7,86,0,2OF5INTERLEAVED,25,0.35;" + tdnBarcodeString);
      }
      tecPrinter.writeData("A 1");
    }
    else
      throw new Exception ("No ha sido posible conectar a la impresora del puerto: " + port);
}
}