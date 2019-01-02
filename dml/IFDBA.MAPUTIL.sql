CREATE OR REPLACE  PACKAGE "IFDBA"."MAPUTIL"    AS
FUNCTION "ISOKMOVERMACMLD" (pIdmac sgamac.IDMAC%type) return VARCHAR2;
Function "ISVACIOMAC" (pIdmac sgamac.idmac%type) return varchar2;
function getRotacionMac(pIdmac sgamac.idmac%type) return varchar2;
END;
