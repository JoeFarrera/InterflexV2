select e.item, e.cantot, e.canres, e.feccre, e.estado,  
        a.idartif, a.idart, a.descrip,
        m.idmac, m.estado, m.ubipos, m.posubipos, m.estado,
        up.estado, up.acceso,
        u.idtipubi,
        u.idtipalm
from sgamac m, sgaexistencia e, sgaposicionubicacion up, sgaarticulo a, sgaubicacion u
where m.idmac = e.idmac
and a.idart = e.idart
and m.ubipos = u.idubi
and up.posicion = m.posubipos
and up.idubi = m.ubipos
and rownum < 10;

