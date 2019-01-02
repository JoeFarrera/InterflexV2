package es.sysmap.interflex.model.bdc;
import java.util.ListResourceBundle;

public class InterflexMessageBundle extends ListResourceBundle 
{
  public static final String MAC_EXISTENT = "001";
  public static final String ARTICLE_INEXISTENT = "002";
  public static final String MAC_AMB_EXISTENCIES = "003";
  public static final String MAC_SENSE_EXISTENCIES = "004";
  public static final String EXISTENCIES_INSUFICIENTS = "005";
  public static final String MAC_INEXISTENT = "006";
  public static final String QUANTITAT_INCORRECTA = "007";
  public static final String POSICION_PICKING_OCUPADA = "008";
  public static final String QUANTITAT_NEGATIVA = "009";
  public static final String QUANTITAT_SORTIDA_INCORRECTA = "010";
  public static final String SENSE_POSICION_EN_PKMLD = "011";
  public static final String MAC_IDENTIFICADOR_INCORRECTE = "012";
  public static final String IDEXIST_NOEXISTE = "013";
  public static final String ETIQUETA_CANTNOLEGIBLE = "014";
  public static final String ARTICLE_INEXISTENT_RF = "015";
  public static final String UBICACION_INEXISTENT = "016";
  public static final String DOCUMENTO_NO_ENCONTRADO = "017";
  public static final String UBI_NIVELL_NULL = "018";
  public static final String ETIQUETA_ERRONEA = "019";
  public static final String NIVELL_NO_NUMERO = "020";
  public static final String POSICIO_NO_NUMERO = "021";
  
  
  private static final Object[][] sMessageStrings = new String[][] 
  {
    { MAC_EXISTENT, "Ja existeix un contenidor amb el número {0}." },
    { ARTICLE_INEXISTENT, "No existeix cap article amb la referència {0}." },
    { MAC_AMB_EXISTENCIES, "El contenidor {0} ja te existències i no se'n poden afegir més." },
    { MAC_SENSE_EXISTENCIES, "El contenidor {0} no te existències de la referència {1}." },
    { EXISTENCIES_INSUFICIENTS, "El contenidor {0} no te proutes existències de la referència {1}." },
    { MAC_INEXISTENT, "No existeix cap contenidor amb el número {0}." },
    { QUANTITAT_INCORRECTA, "La quantitat confirmada ({0}) no pot ser inferior a la prevista ({1})." },
    { POSICION_PICKING_OCUPADA, "La posició {0} esta ocupada per un altre contenidor." },
    { QUANTITAT_NEGATIVA, "La quantitat confirmada no pot ser negativa." },
    { QUANTITAT_SORTIDA_INCORRECTA, "La quantitat confirmada ({0}) no pot ser superior a la total ({1})." },
    { SENSE_POSICION_EN_PKMLD, "No queda cap posició en ({0}) per la cubeta." },
    { MAC_IDENTIFICADOR_INCORRECTE, "Identificador {0} pel contenidor incorrecte." },
    { IDEXIST_NOEXISTE, "El identificador d'artícle {0} no existeix" },
    { ETIQUETA_CANTNOLEGIBLE, "No s'ha pogut llegir la cantitat de la etiqueta. Format etiqueta: Article (fins 10) + quantitat (4)" },
    { ARTICLE_INEXISTENT_RF, "No existeix cap article amb la referència {0}. Format etiqueta: Article (fins 10) + quantitat (4)" },
    { UBICACION_INEXISTENT, "No existeix cap ubicació amb aquestes coordenades {0}." },
    { DOCUMENTO_NO_ENCONTRADO, "No existe documento de entrada para la referecia {0}." },
    { UBI_NIVELL_NULL, "El nivell es un camp obligatori." },
    { ETIQUETA_ERRONEA, "L''etiqueta no té el tamany mínim (Referencia + quantitat)."},
    { NIVELL_NO_NUMERO, "Nivell ha de ser un numero. {0}"},
    { POSICIO_NO_NUMERO, "Posició ha de ser un numero. {0}"}
  };

  /**
   * 
   *  Return String Identifiers and corresponding Messages in a two-dimensional array.
   * @return 
   */
  protected Object[][] getContents()
  {
    return sMessageStrings;
  }
}