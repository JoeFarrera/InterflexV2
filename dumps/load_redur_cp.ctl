load data
 infile 'e:\InterflexV2\dumps\CP.TXT'
 into table sgaredur
  (  PLAZA     position (01:03) CHAR,
    COD_POSTAL position (05:09) CHAR,
    PROVINCIA position (15:17) CHAR
 )
