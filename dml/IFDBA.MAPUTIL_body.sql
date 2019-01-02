CREATE OR REPLACE  PACKAGE BODY "IFDBA"."MAPUTIL"    AS

-- comprobar que un MAC del miniload esta en la posicion 1 o esta en la 2 pero la 1 esta vacio o se puede mover su mac
FUNCTION "ISOKMOVERMACMLD" (pIdmac sgamac.IDMAC%type) return VARCHAR2
AS
cursor curmac (pcidmac sgamac.IDMAC%type) is
  select sgamac.idmac, sgamac.ubipos, sgamac.posubipos
  from sgamac, sgaubicacion
  where idmac = pcidmac;
  lcurmacMover curmac%rowtype;

cursor curOtroMac (pubipos sgamac.UBIPOS%type, pposubipos sgamac.POSUBIPOS%type) is
  select m.idmac,
    m.estado macestado,
    p.ESTADO posestado,
    p.ACCESO posacceso
    from sgamac m, sgaposicionubicacion p
    where p.idubi = m.ubipos (+)
    and p.posicion = m.posubipos (+)
    and p.idubi = pubipos
    and p.posicion = pposubipos;

lOtroMac curOtroMac%rowtype;
lRetVal boolean := true;
BEGIN
  open curmac (pIdmac);
  fetch curmac into lcurmacMover;
  close curmac;
  if (lcurmacMover.posubipos = 2) then
    open curOtroMac (lcurmacMover.ubipos, 1);
    fetch curOtroMac into lOtroMac;
    if (curOtroMac%found) then
      if (nvl(lOtroMac.macestado, 'L') != 'L' or lOtroMac.posestado not in ('L', 'O') or lOtroMac.posacceso != 'L') then
        lRetVal := false;
      else
        lRetVal := true;
      end if;
    else
      lRetVal := true;
    end if;
    close curOtroMac;
  else
    lRetVal := true;
  end if;
  if (lRetVal) then
    return 'TRUE';
  else
    return 'FALSE';
  end if;
END;

function isVacioMac(pIdmac sgamac.idmac%type) return varchar2 is
  cursor curexistenciasmac (pcIdmac sgamac.idmac%type) is
  select * from sgaexistencia
  where idmac = pcIdmac;
  lcurexist curexistenciasmac%rowtype;
  Result VARCHAR2(5);
begin
  open curexistenciasmac(pIdmac);
  fetch curexistenciasmac into lcurexist;
  if (curexistenciasmac%found) then
     Result := 'FALSE';
  else
     Result := 'TRUE';
  end if;
  close curexistenciasmac;
  return(Result);
end isVacioMac;

function getRotacionMac(pIdmac sgamac.idmac%type) return varchar2 is
  cursor currotacion (pcIdmac sgamac.idmac%type) is
      select min(nvl(a.rotacion, 'C')) rotacion, m.idtipmac
             from sgamac m, sgaexistencia e, sgaarticulo a
             where m.idmac = e.idmac (+)
             and e.idart = a.idart (+)
             and m.idmac = pcIdmac
             group by m.idmac, m.idtipmac;
  lcurrotacion currotacion%rowtype;
  Result varchar2(5);
  begin
       open currotacion(pIdmac);
       fetch currotacion into lcurrotacion;
       if (lcurrotacion.idtipmac = 'CUB' and isVacioMac(pIdmac) = 'TRUE') then
          -- :TODO -- calcular la rotación de una cubeta vacia del MLD
          Result := 'nada';-- ver cual es la rotación de un mac vacio
       end if;
       close currotacion;
       return lcurrotacion.rotacion;
  end;
           
END;
