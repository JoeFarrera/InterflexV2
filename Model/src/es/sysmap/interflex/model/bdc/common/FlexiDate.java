package es.sysmap.interflex.model.bdc.common;
/**
 *  FlexiDate - Subclass of Base BC4J Date Domain allowing
 *              multiple input format masks, and supporting
 *              conditional output format based on whether the
 *              date has any time component or not.
 *
 * MODIFICATION HISTORY
 * -----------------------------------------
 * smuench 28/02/2001 - Created.
 * smuench 08/02/2002 - Recreated for JDev9i
 * smuench 10/09/2002 - Added yyyy-MM-dd mask to make UIX datepicker work
 * michael 30/04/2004 - Modified for MAP / Spain
 */

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import oracle.jbo.JboException;
import oracle.jbo.domain.Date;

import oracle.sql.*;
import oracle.jbo.domain.DomainOwnerInterface;



//  ---------------------------------------------------------------
//  ---    File generated by Oracle Business Components for Java.
//  ---------------------------------------------------------------

public class FlexiDate extends Date 
{
  /*
   * This unique id for the class makes three-tier marshalling faster
   */
  private static final long serialVersionUID = 123456789012345678L;
 
  static CustomDatumFactory fac;
  /*
   * Static array of acceptable input masks
   * NOTE: More specific masks should *come before* less specific ones
   */
  private static String[] masks = {
    "yyyy-MM-dd H:m:s.S",
    "yyyy-MM-dd H:m:s",
    "yyyy-MM-dd H:m",
    "yyyy-MM-dd",
    "dd-MMM-yyyy H:m:s",
    "dd-MMM-yyyy H:m",
    "dd-MMM-yyyy",
    "dd/MM/yyyy H:m:s",
    "dd/MM/yyyy H:m",
    "dd/MM/yyyy HH",
    "dd/MM/yyyy",
    "yyyyMMddHH"  // Monturiol
  };

  /*
   * Default date masks used for display
   * See JavaDoc for java.text.SimpleDateFormat for mask "language"
   */
  private static final String DEFAULT_WITHTIME = "dd/MM/yyyy HH:mm";
  private static final String DEFAULT_WITHOUTTIME = "dd/MM/yyyy";  
  private static final String DEFAULT_SHORTTIME = "[dd/MM HH]";
  private static final String DEFAULT_MONTURIOL = "yyyyMMddHH";
  private static final String DEFAULT_DISPLAY = "HH";  // Para los displays
  private static final String DEFAULT_ONLYTIME = "HH:mm";
  private static final String DEFAULT_INFORMIX = "yyyy-MM-dd";
  
  public FlexiDate(){}

   /**
    * Construct a FlexiDate from another Flexidate
    */
   public FlexiDate(FlexiDate flex) { this(flex.getBytes()); }
 
   /** 
    * Construct a FlexiDate from a String
    */
   public FlexiDate(String dateStr) {
     int numMasks = masks.length;
     SimpleDateFormat sdf = null;
     
     // Michael 07.07.2004 Si es null, nada
     if (dateStr == null)
      return;
      
     /*
      * Loop over all acceptable format masks
      */  
     for (int z = 0; z < numMasks; z++) {
       /*
        * Construct a new instance of SimpleDateFormat if necessary
        */
       if (sdf == null) {
         sdf = new SimpleDateFormat(masks[z]);
         /*
          * This disallows dates like January 32rd
          */
         sdf.setLenient(false); 
       }
       else {
         /*
          * If we've already created a SimpleDateFormat, apply current pattern
          */
         sdf.applyPattern(masks[z]);
       }
       try {
         /*
          * Try to parse the candidate date string
          * value using current mask
          */
         Timestamp mTS = new Timestamp(sdf.parse(dateStr).getTime());
         /*
          * If date parse is successful, set the date value
          * from the internal byte[] representation of the date we've
          * just parsed, then return
          */
         super.setBytes(toDate(mTS.toString()).getBytes());
         validate();
         return;
       }
       /*
        * If candidate date string fails to match current match, try next one.
        */
       catch (ParseException pex) { continue; }
     }
     /*
      * If we get here, none of the masks worked.
      */
     throw new JboException(dateStr + " no es una fecha v�lida");
   }
   
   /**
    * Construct a FlexiDate based on a Date value.
    */
  public FlexiDate(Date value) {
    super(value.getBytes());
    validate();
  }

   /**
    * Construct a FlexiDate based on a DATE value.
    */
  public FlexiDate(DATE value) {
    super(value.getBytes());
    validate();
  }

   /**
    * Construct a FlexiDate based on a byte[] value.
    */
  public FlexiDate(byte[] value) {
    super(value);
    validate();
  }

   /**
    * Construct a FlexiDate based on a java.sql.Date value.
    */
  public FlexiDate(java.sql.Date value)
  {
    super(value);
    validate();
  }

  /**
   * Construct a FlexiDate based on a java.sql.Time value.
   */
  public FlexiDate(Time value) {
    super(value);
    validate();
  }

  /**
   * Construct a FlexiDate based on a java.sql.Timestamp value.
   */
  public FlexiDate(Timestamp value) {
    super(value);
    validate();
  }

  /**
   * Construct a FlexiDate based on an Object value.
   */
  public FlexiDate(Object value) throws SQLException {
    super(value);
    validate();
  }

  /**
   * Implements domain validation logic and throws a JboException
   */
  protected void validate() {
    //   ### Implement custom domain validation logic here. ###
  }

  public static CustomDatumFactory getCustomDatumFactory() {
    if (fac == null) {
      class facClass implements CustomDatumFactory {
        public CustomDatum create(Datum d, int sql_type_code) throws SQLException {
          if (d != null) {
            return new FlexiDate(d.getBytes());
          }
          return null;
        }
      }
      fac = new facClass();
    }
    return fac;
  }

  /**
   * Controls date display for all clients (JClient, JSP, XML, etc)
   */
  public String toString() {
    SimpleDateFormat sdf = null;
    Timestamp tVal = timestampValue();
    /*
     * Use date-only mask if value has no time components
     */
    /*
     * Michael 30.04.2004 Don't use this as not getting 12:00 nor 24:00
     *
    sdf = new SimpleDateFormat(hasTimeComponent(tVal) ? 
          DEFAULT_WITHTIME : DEFAULT_WITHOUTTIME);
     */
    sdf = new SimpleDateFormat(DEFAULT_WITHTIME);
    return sdf.format(tVal).toUpperCase();
  }


  /**
   * Controls date display for all clients (JClient, JSP, XML, etc)
   */
  public String toTimeString() {
    SimpleDateFormat sdf = null;
    Timestamp tVal = timestampValue();
    /*
     * Use date-only mask if value has no time components
     */
    /*
     * Michael 30.04.2004 Don't use this as not getting 12:00 nor 24:00
     *
    sdf = new SimpleDateFormat(hasTimeComponent(tVal) ? 
          DEFAULT_WITHTIME : DEFAULT_WITHOUTTIME);
     */
    sdf = new SimpleDateFormat(DEFAULT_ONLYTIME);
    return sdf.format(tVal).toUpperCase();
  }

  /**
   * Controls date display for all clients (JClient, JSP, XML, etc)
   */
  public String toInformixString() {
    SimpleDateFormat sdf = null;
    Timestamp tVal = timestampValue();
    /*
     * Use date-only mask if value has no time components
     */
    /*
     * Michael 30.04.2004 Don't use this as not getting 12:00 nor 24:00
     *
    sdf = new SimpleDateFormat(hasTimeComponent(tVal) ? 
          DEFAULT_WITHTIME : DEFAULT_WITHOUTTIME);
     */
    sdf = new SimpleDateFormat(DEFAULT_INFORMIX);
    return sdf.format(tVal).toUpperCase();
  }


  /**
   * Controls date display for all clients (JClient, JSP, XML, etc)
   */
  public String toShortString() {
    SimpleDateFormat sdf = null;
    Timestamp tVal = timestampValue();
    /*
     * Use date-only mask if value has no time components
     */
    /*
     * Michael 30.04.2004 Don't use this as not getting 12:00 nor 24:00
     *
    sdf = new SimpleDateFormat(hasTimeComponent(tVal) ? 
          DEFAULT_WITHTIME : DEFAULT_WITHOUTTIME);
     */
    sdf = new SimpleDateFormat(DEFAULT_SHORTTIME);
    return sdf.format(tVal).toUpperCase();
  }

  /*
   * Helper method to return today's date as a FlexiDate
   */
  public static FlexiDate currentDate() {
    return new FlexiDate(new Timestamp(System.currentTimeMillis()));
  }  

  /*
   * Return true if date has any time component
   */
  private static boolean hasTimeComponent(java.util.Date tVal) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(tVal);
    return (   cal.get(Calendar.MILLISECOND) != 0 
            || cal.get(Calendar.SECOND) != 0 
            || cal.get(Calendar.MINUTE) != 0 
            || cal.get(Calendar.HOUR) != 0);
  }
  
  public String toMonturiolStringFormat()
  {
    Timestamp tVal = timestampValue();
    SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_MONTURIOL);
    return sdf.format(tVal).toUpperCase();
   
  }
  
  public String toDisplayStringFormat()
  {
    Timestamp tVal = timestampValue();
    SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DISPLAY);
    return sdf.format(tVal).toUpperCase();
     
  }

  public String toSimpleDateStringFormat()
  {
    Timestamp tVal = timestampValue();
    SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_WITHOUTTIME);
    return sdf.format(tVal).toUpperCase();
     
  }

  /**
   * Michael - TODO - remove this when rowInconsistent sorted...
   * @param other
   * @return 
   */
  public boolean equals (FlexiDate other)
  {
    try
    {
    if (this.toString().equals(other.toString()))
      return true;
    else
      return false;
    } catch (Exception e)
    {

    }
    return (false);
  }
}