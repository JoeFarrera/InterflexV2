create or replace view sgavmovsusuariresum as
select createdby operari, 
    trunc(createdon, 'HH24') data,
    descvisualpos orides, count(*) moviments, nvl(e.moviments,0) entrades, nvl(s.moviments,0) sortides, nvl(r.moviments,0) regular
from sgavhistexist v, sgavmovsusuari e, sgavmovsusuari s, sgavmovsusuari r
where v.createdby = e.operari (+)
and trunc(createdon, 'HH24') = e.data (+)
and v.descvisualpos = e.orides (+)
and e.tipmov (+) = 'Entrada'
and v.createdby = s.operari (+)
and trunc(createdon, 'HH24') = s.data (+)
and v.descvisualpos = s.orides (+)
and s.tipmov (+) = 'Sortida'
and v.createdby = r.operari (+)
and trunc(createdon, 'HH24') = r.data (+)
and v.descvisualpos = r.orides (+)
and r.tipmov (+) = 'Regular'
group by v.createdby, trunc(v.createdon, 'HH24'), v.descvisualpos, e.moviments, s.moviments, r.moviments WITH READ ONLY