create or replace view sgavsalidascandidatemacpuesto as
select m.idmac, 
       m.multiref, 
       m.idtipmac, 
       m.ubipos, 
       m.posubipos,
       m.ubides, 
       sp.iddoc, 
       sp.prioridad, 
       sp.idlin, 
       ld.cantot, 
       ld.canpen, 
       ld.canres, 
       e.cantot - e.canres candis, 
       sp.idpuesto, 
       sp.idart, 
       sp.idartif, 
       sp.tolfifo, 
       e.fecent, 
       e.canres canresExistencia,
       sp.asigmld,
       sp.asigslo
  from sgamac m, sgaexistencia e, sgavsalidaspendiente sp, 
       sgaldoc ld, sgaresmat rm, sgacdoc c, sgatipdoc td
 where m.idmac = e.idmac 
   and e.idart = sp.idart 
   and ld.iddoc = sp.iddoc 
   and ld.idlin = sp.idlin 
   and e.idmac = rm.idmac(+)
   and e.idart = rm.idart (+)
   and rm.iddoc = c.iddoc (+)
   and c.idtipdoc = td.idtipdoc (+)
   and nvl(td.tipmov, 'S') = 'S'
   and (e.cantot - e.canres) > 0
   and (sp.asigmld = 'S' and m.idtipmac = 'CUB' or (m.idtipmac != 'CUB' and sp.asigslo = 'S'))
   and (m.idtipmac = 'CUB' and m.ubides = sp.idubimld or (m.idtipmac != 'CUB' and m.ubides = sp.idubislo))
   and (m.estado in ('R', 'P'))         -- reservado o ya en el puesto
   -- la existencia permite sacar una cantidad parcial y no existe cantidad integra en otro sitio 
   -- o sacamos la cantidad total de la existencia
   and ((e.cantot <= sp.canpen and nvl(e.integra, 'N') = 'S') or 
       (nvl(e.integra, 'N') = 'N' and not exists 
        (select 'T' 
            from sgaexistencia e1, sgavmacdisponiblealmacen m1
           where e1.idmac = m1.idmac
             and e1.integra = 'S' 
             and e1.cantot <= sp.canpen 
             and e1.idart = e.idart))) 
   -- no existe existencia más antigua en otros pasillos con cantidad suficiente como para satisfacer la orden 
   and not exists (select 
          sum(e2.cantot) 
          from sgaexistencia e2, sgaarticulo a, sgavmacdisponiblealmacen m2  
         where e2.idart = a.idart 
           and e2.estado = 'L' 
           and e2.createdon < (e.createdon - a.tolfifo) 
           and e2.idart = sp.idart 
           and e2.idmac = m2.idmac 
         having sum(e2.cantot) >= sp.canpen)

