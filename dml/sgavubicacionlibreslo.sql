create or replace view sgavubicacionlibreslo as
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
  sgatipomac.NUMPOS
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
  or sgatipomac.NUMPOS = 1) WITH READ ONLY

