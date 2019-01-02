select e.idart, e.idmac, e.item, e.cantot, e.createdon, m.ubipos, m.posubipos, u.columna, u.nivel, u.lado
from sgaexistencia e, sgamac m, sgaubicacion u, sgaposicionubicacion pos
where m.idmac = e.idmac
and m.ubipos = u.idubi
and pos.idubi = m.ubipos
and pos.posicion = m.posubipos
and m.ubides = m.ubipos -- por si acaso
and e.estado = 'L'
and e.cantot > 0
and pos.estado = 'O'
and pos.acceso = 'L'
and u.idtipalm = 'MLD'
and (pos.posicion = 1 
  or (pos.posicion = 2 and exists 
    (select 1 from sgamac m1, sgaposicionubicacion pos1
  where pos1.idubi = u.idubi
  and (pos1.idubi = m1.ubipos (+)
    and pos1.posicion = m1.posubipos (+)
    or pos1.idubi = m1.ubides (+)
    and pos1.posicion = m1.posubides (+))
  and pos1.posicion = 2
  and (pos1.estado = 'L'
    or m1.estado = 'L')
  and pos1.acceso = 'L')));