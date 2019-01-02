select sgatipmactipubi.idtipmac,
  sgaposicionubicacion.idubi, 
  sgaposicionubicacion.POSICION, 
  sgaposicionubicacion.udistancia,
  sgaubicacion.IDTIPUBI,
  sgaubicacion.PASILLO, 
  sgaubicacion.COLUMNA, 
  sgaubicacion.NIVEL,
  sgaubicacion.LADO,
  sgaubicacion.ROTACION,
  sgatipomac.NUMPOS,
  -- Michael 19.12.2007 A�adir prioridad a:
  -- 2: Si es jaula, y hay una ubicaci�n de Jaula disponible
  -- 1: Es una ubicacion de contenedor y tiene su otra posici�n libre
  -- 0: Todos los otros casos
  (select nvl((select 1 
                     from dual
                where sgatipmactipubi.idtipmac = 'JLA'
                and exists (select 1 
                       from sgaposicionubicacion pu
                       where pu.idubi = sgaubicacion.idubi
                       and pu.estado = 'O')), decode (sgaubicacion.idtipubi, 'JLA',2, 0)) from dual) prioridad
from sgaposicionubicacion, sgatipmactipubi, sgaubicacion, sgatipomac
where sgaposicionubicacion.idubi = sgaubicacion.idubi
and sgaubicacion.IDTIPUBI = sgatipmactipubi.IDTIPUBI
and sgatipomac.idtipmac = sgatipmactipubi.idtipmac
and sgaposicionubicacion.estado = 'L'
and sgaposicionubicacion.ACCESO = 'L'
and sgaubicacion.idtipalm = 'SLO'
-- esto es v�lido mientras no hace falta mirar que sean posiciones cont�guas
-- Si ocupa m�s de una posici�n, que empiece en la primera
and sgatipomac.NUMPOS <= 
(select count(*) 
  from sgaposicionubicacion p1 
  where p1.idubi = sgaubicacion.idubi
  and p1.estado = 'L'
  and p1.acceso = 'L')
and (sgatipomac.NUMPOS > 1 and sgaposicionubicacion.posicion = 1
  or sgatipomac.NUMPOS = 1) 
 order by prioridad desc;
