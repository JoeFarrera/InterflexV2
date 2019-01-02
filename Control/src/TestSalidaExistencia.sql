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
    (select 1 from sgaposicionubicacion pos1
      where pos1.idubi = u.idubi
        pos1.posicion = 1 and
        (pos1.estado = 'L' or (pos1.estado = 'O' and exists 
                (select 1 from sgamac
                  where ubipos = pos1.idubi 
                  and posubipos = pos1.posicion
                  or ubides = pos1.idubi 
                  and posubides = pos1.posicion
                  and sgamac.estado = 'L'))
         )
        )
       )
    );
