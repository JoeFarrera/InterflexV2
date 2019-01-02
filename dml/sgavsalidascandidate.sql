create or replace view sgavsalidascandidate as
select /*+INDEX(SGAEXISTENCIA SGAEXISTENCIA_PK) */  
       m.idmac, 
       m.multiref, 
       m.idtipmac, 
       m.ubipos, 
       m.posubipos, 
       decode (m.idtipmac, 'CUB', sp.idubimld, sp.idubislo) ubides, 
       0 posubides, 
       m.posplc, 
       m.idpasillo, 
       m.udistancia, 
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
       sp.asigslo,
       m.idtipalm
  from sgavmacdisponiblealmacen m, sgaexistencia e, sgavsalidaspendiente sp, 
       sgaldoc ld 
 where m.idmac = e.idmac 
   and e.idart = sp.idart 
   and ld.iddoc = sp.iddoc 
   and ld.idlin = sp.idlin 
   and e.cantot > 0
   and (sp.asigmld = 'S' and m.idpasillo = 0 or (m.idpasillo != 0 and sp.asigslo = 'S'))
      -- que no haya otra referencia reservada (para hacer una entrada o una salida) con cantidad sobrante 
      -- Si tiene reserva, no comprobar el estado del MAC, ubicaci�n etc, ya que se da por bueno 
      -- nota: Si el mac tiene destino el puesto pero sin reserva, no se ve aqu�
   and not exists 
   (select e1.idmac  
            from sgaexistencia e1, 
                 sgaresmat     r1, 
                 sgatipdoc     t1, 
                 sgacdoc       c1 
           where r1.idmac = e1.idmac 
             and r1.idart = e1.idart 
             and c1.idtipdoc = t1.idtipdoc
             and c1.iddoc = sp.iddoc
             and decode(t1.tipmov, 
                        'S', 
                        (e1.cantot - e1.canres), 
                        (e1.cantot + e1.canres)) > 0 
             and e1.idart = e.idart
    ) 
   -- la existencia permite sacar una cantidad parcial y no existe cantidad integra en otro sitio 
   -- o sacamos la cantidad total de la existencia
   and ((e.cantot <= sp.canpen and nvl(e.integra,'N') = 'S') or 
       (nvl(e.integra, 'N') = 'N' 
        and not exists 
        -- almac�n autom�tic
        (select 'T' 
            from sgaexistencia e1, sgavmacdisponiblealmacen m1
           where e1.idmac = m1.idmac
             and nvl(e1.integra, 'N') = 'S' 
             and e1.cantot <= sp.canpen 
             and e1.canres = 0 -- que no est� ya reservado
             and e1.idart = e.idart)
         and not exists 
         -- almac�n manual
        (select 'T' 
            from sgaexistencia e1, sgamac m1, sgaubicacion u1
           where e1.idmac = m1.idmac
             and m1.ubipos = u1.idubi
             and u1.idtipalm = 'MAN'
             and u1.estado = 'O'
             and nvl(e1.integra, 'N') = 'S' 
             and e1.cantot <= sp.canpen 
             and e1.canres = 0 -- que no est� ya reservado
             and e1.idart = e.idart)           )) 
   -- no existe existencia m�s antigua en otros sitios con cantidad suficiente como para satisfacer la orden 
     -- almac�n autom�tic
     and not exists (select 
            sum(e2.cantot) 
            from sgaexistencia e2, sgaarticulo a, sgavmacdisponiblealmacen m2  
           where e2.idart = a.idart 
             and e2.createdon < (e.createdon - a.tolfifo) 
             and e2.idart = sp.idart 
             and e2.idmac = m2.idmac 
           having sum(e2.cantot) >= sp.canpen)
     -- almac�n manual
     and not exists (select 
            sum(e3.cantot) 
            from sgaexistencia e3, sgaarticulo a, sgamac m3, sgaubicacion u3
           where e3.idart = a.idart 
             and m3.ubipos = u3.idubi
             and u3.idtipalm = 'MAN'
             and u3.estado = 'O'    -- hueco ocupado
             and e3.createdon < (e.createdon - a.tolfifo) 
             and e3.idart = sp.idart 
             and e3.idmac = m3.idmac 
           having sum(e3.cantot) >= sp.canpen)

