insert into sgatipoubicacion (idtipubi, descrip) values ('CUB','Cubeta');
insert into sgatipoubicacion (idtipubi, descrip) values ('EP','Europalet');
insert into sgatipoubicacion (idtipubi, descrip) values ('JLA','Gabia');
insert into sgatipoubicacion (idtipubi, descrip) values ('CON','Container o gabia');
insert into sgatipoubicacion (idtipubi, descrip) values ('MAN','Manipulació');
insert into sgatipoubicacion (idtipubi, descrip) values ('PPK','Puesto de picking');

insert into sgatipoalmacen (idtipalm, descrip) values ('SLO','Maxi Load Automàtic');
insert into sgatipoalmacen (idtipalm, descrip) values ('MLD','Mini Load Automàtic');
insert into sgatipoalmacen (idtipalm, descrip) values ('MAN','Ubicaciones manuales');
insert into sgatipoalmacen (idtipalm, descrip) values ('PMA','Pulmó de manutenció');
insert into sgatipoalmacen (idtipalm, descrip) values ('PPK','Puesto de picking');
insert into sgatipoalmacen (idtipalm, descrip) values ('PLC','Punt de comunicación PLC');

insert into sgatipomac (idtipmac, descrip, numpos, tipplc, idtipalm) values ('EPC', 'Europalet Cartro', 1, 3, 'SLO');
insert into sgatipomac (idtipmac, descrip, numpos, tipplc, idtipalm) values ('CON','Container', 2, 1, 'SLO');
insert into sgatipomac (idtipmac, descrip, numpos, tipplc, idtipalm) values ('EP','Europalet', 1, 3, 'SLO');
insert into sgatipomac (idtipmac, descrip, numpos, tipplc, idtipalm) values ('CUB','Cubeta', 1, 4, 'MLD');
insert into sgatipomac (idtipmac, descrip, numpos, tipplc, idtipalm) values ('JLA','Gabia', 1, 2, 'SLO');
insert into sgatipomac (idtipmac, descrip, numpos, tipplc) values ('PAK','Pack especial de Interflex', 1, 0);

insert into sgatipmactipubi (idtipmac, idtipubi) values ('EP','EP');
insert into sgatipmactipubi (idtipmac, idtipubi) values ('EPC','EP');
insert into sgatipmactipubi (idtipmac, idtipubi) values ('JLA','JLA');
insert into sgatipmactipubi (idtipmac, idtipubi) values ('CON','CON');
insert into sgatipmactipubi (idtipmac, idtipubi) values ('JLA','CON');
insert into sgatipmactipubi (idtipmac, idtipubi) values ('CUB','CUB');

-- Ubicaciones para posiciones del PLC
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values ('PK1MLD', 54, 'Picking 1 Mini Load', 'PPK', 'PPK', 10);
-- Michael 13.04.2005 Posicions per les ubicacions de picking del miniload
begin
for i in 0..3
loop
insert into sgaposicionubicacion
  (posicion,
   estado,
   idubi,
   acceso,
   udistancia)
values
  (i,
   'L',
   'PK1MLD',
   'L',
   0);
end loop;
end;

insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values ('PK2MLD', 56, 'Picking 2 Mini Load', 'PPK', 'PPK', 20);
begin
for i in 0..3
loop
insert into sgaposicionubicacion
  (posicion,
   estado,
   idubi,
   acceso,
   udistancia)
values
  (i,
   'L',
   'PK2MLD',
   'L',
   0);
end loop;
end;

insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 55, 'Scanner Mini Load', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 51, 'Sortida Mini Load', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 50, 'Traslo Mini Load', 'MAN', 'PLC', 2);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 58, 'Entrada Mini Load', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values ('PK2SLO', 1, 'Picking 2 Maxi Load', 'PPK', 'PPK', 20);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values ('PK1SLO', 14, 'Picking 1 Maxi Load', 'PPK', 'PPK', 20);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 17, 'Pulmó Sortida Maxi Load', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 6, 'Recirculació Maxi Load', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 9, 'Recirculació Maxi Load', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 27, 'Sortida (2) Passadís 1', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 26, 'Sortida (1) Passadís 1', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 25, 'Passadís 1', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 24, 'Entrada (1) Passadís 1', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 23, 'Entrada (2) Passadís 1', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 32, 'Sortida (2) Passadís 2', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 31, 'Sortida (1) Passadís 2', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 30, 'Passadís 2', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 29, 'Entrada (1) Passadís 2', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 28, 'Entrada (2) Passadís 2', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 36, 'Sortida (1) Passadís 3', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 37, 'Sortida (2) Passadís 3', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 35, 'Passadís 1', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 34, 'Entrada (1) Passadís 3', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 33, 'Entrada (2) Passadís 3', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 42, 'Sortida (2) Passadís 4', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 41, 'Sortida (1) Passadís 4', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 40, 'Passadís 1', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 39, 'Entrada (1) Passadís 4', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 38, 'Entrada (2) Passadís 4', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 61, 'Traslo 1', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 62, 'Traslo 2', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values (lpad(to_char(seq_idubic.nextval), 6, '0'), 44, 'Pulmó Entrada Extra', 'MAN', 'PLC', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values ('PKEXTR', 45, 'Puesto Entrada Extra', 'MAN', 'PPK', 1);
insert into sgaubicacion (idubi, posplc, descrip, idtipubi, idtipalm, cappul)
values ('PKML99', 99, 'Zona Picking MLD', 'MAN', 'PLC', 1);


-- deben tener las ubicaciones creadas antes de ejecutar
insert into sgapuestomanip(idpuesto, idubimld, idubislo, estado, autoselordsal, NUMORDSAL, AUTORETIRARMAC)
  values (1,'PK1MLD', 'PK1SLO', 'C', 'S', 1, 'S');
insert into sgapuestomanip(idpuesto, idubimld, idubislo, estado, autoselordsal, NUMORDSAL, AUTORETIRARMAC)
  values (2, 'PK2MLD', 'PK2SLO', 'C', 'S', 1, 'S');
insert into sgapuestomanip(idpuesto, idubimld, idubislo, estado, autoselordsal, NUMORDSAL, AUTORETIRARMAC)
  values (3, NULL, 'PKEXTR', 'C', 'S', 1, 'S');

-- Michael 22.03.2005 Esto no va.... :TODO
insert into SGAPASILLO ( IDPASILLO,IDUBI, IDUBIENTRADA,IDUBISALIDA,ESTADO)
  values (0, (select idubi from sgaubicacion where posplc='50'), (select idubi from sgaubicacion where posplc='58'), (select idubi from sgaubicacion where posplc='51'), '1');
insert into SGAPASILLO ( IDPASILLO,IDUBI, IDUBIENTRADA,IDUBISALIDA,ESTADO)
  values (1, (select idubi from sgaubicacion where posplc='25'), (select idubi from sgaubicacion where posplc='24'), (select idubi from sgaubicacion where posplc='27'), '1');
insert into SGAPASILLO ( IDPASILLO,IDUBI, IDUBIENTRADA,IDUBISALIDA,ESTADO)
  values (2, (select idubi from sgaubicacion where posplc='30'), (select idubi from sgaubicacion where posplc='29'), (select idubi from sgaubicacion where posplc='32'), '1');
insert into SGAPASILLO ( IDPASILLO,IDUBI, IDUBIENTRADA,IDUBISALIDA,ESTADO)
  values (3, (select idubi from sgaubicacion where posplc='35'), (select idubi from sgaubicacion where posplc='34'), (select idubi from sgaubicacion where posplc='37'), '1');
insert into SGAPASILLO ( IDPASILLO,IDUBI, IDUBIENTRADA,IDUBISALIDA,ESTADO)
  values (4, (select idubi from sgaubicacion where posplc='40'), (select idubi from sgaubicacion where posplc='39'), (select idubi from sgaubicacion where posplc='42'), '1');


-- traslos
insert into sgatraslo (IDTRASLO, DESCRIP, ESTADOPROCESO, ESTADOTRASLO, PASILLOACTUAL, PASILLODESTINO)
values (0, 'Traslo Mini Load', 'N', 'A', 0, 0);
-- traslo 1 en el pasillo 1
insert into sgatraslo (IDTRASLO, DESCRIP, ESTADOPROCESO, ESTADOTRASLO, PASILLOACTUAL, PASILLODESTINO)
values (1, 'Traslo 1 Maxi Load', 'N', 'A', 1, 1); 
-- traslo 2 en el pasillo 2
insert into sgatraslo (IDTRASLO, DESCRIP, ESTADOPROCESO, ESTADOTRASLO, PASILLOACTUAL, PASILLODESTINO)
values (2, 'Traslo 2 Maxi Load', 'N', 'A', 2, 2); 


-- registres de refcodes generats a partir de la sentencia
-- select 'insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('|| 
-- chr(39) || domain ||chr(39) || ', ' || chr(39) || value ||chr(39) ||', '|| chr(39) ||abbreviation ||chr(39) ||', '||chr(39) ||meaning ||chr(39) || ', '|| chr(39) ||orderdisp||chr(39) ||');' from sgarefcodes;
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('TIPMOV', 'E', 'Entrada', 'Entrada', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('TIPMOV', 'S', 'Sortida', 'Sortida', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('TIPMOV', 'R', 'Regular', 'Regularitzacio', '3');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ROTACION', 'A', 'Zona A', 'Zona A', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ROTACION', 'B', 'Zona B', 'Zona B', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ROTACION', 'C', 'Zona C', 'Zona C', '3');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTADOMAC', 'L', 'Lliure', 'Lliure', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTADOMAC', 'R', 'Reservat', 'Reservat', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTADOMAC', 'P', 'En puesto', 'En puesto', '3');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTTPROC', 'N', 'No Inic.', 'No inicialitzat', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTTPROC', 'F', 'Func.', 'En funcionament', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTTPROC', 'O', 'Pend. Ord.', 'Pendent aceptació de una ordre', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTTRASLO', 'F', 'Func.', 'En funcionament', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTTRASLO', 'A', 'Averiat', 'Espatllat', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTADOMAC', 'X', 'Pendent', 'Pendent', '4');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTADOUBI', 'L', 'Lliure', 'Lliure', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTADOUBI', 'R', 'Reservada', 'Reservada', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTADOUBI', 'O', 'Ocupada', 'Ocupada', '3');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ACCESOUBI', 'L', 'Lliure', 'Lliure', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ACCESOUBI', 'B', 'Bloquejada', 'Bloquejada', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ACCESOUBI', 'I', 'Inspecció', 'Inspecció', '3');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTEXIST', 'L', 'Lliure', 'Lliure', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTEXIST', 'R', 'Reservada', 'Reservada', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTPUESTO', 'A', 'Obert', 'Obert', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTPUESTO', 'C', 'Tancat', 'Tancat', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('LADO', '0', 'Esquerra', 'Esquerra', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('LADO', '1', 'Dreta', 'Dreta', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORD', 'D', 'Disponible', 'Ordre disponible', '7');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORD', 'N', 'Nou', 'Ordre Nou', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORD', 'P', 'En procés', 'En procés', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORD', 'A', 'Anulada', 'Anulada', '3');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORD', 'S', 'Suspesa', 'Suspesa', '5');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORD', 'F', 'Final.', 'Finalitzada', '4');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTCOM', 'Z', 'Erronea', 'Erronea', '6');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTCOM', 'C', 'Comunicada', 'Comunicada al HOST', '6');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTCOM', 'H', 'Host', 'Pendiente comunicar al HOST', '7');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTPASILLO', '1', 'Func.', 'En funcionament', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTPASILLO', '0', 'Fora.', 'Fora funcionament', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTPROTRA', 'N', 'No Init.', 'No Inicialitzat', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTPROTRA', 'F', 'Func.', 'En Funcionament', '1');

insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'T', 'P. Tra.', 'Pendent Traslo', '1');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'N', 'Nova', 'Nova', '2');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'P', 'Pendent', 'Pendent Aceptació', '3');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', '2', 'Nova (2a)', 'Nova (2a part)', '4');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'C', 'En curs ', 'Ordre en curs', '5');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'B', 'Pend. Bor.', 'Pendent borrar', '6');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'b', 'Pend. Bor', 'Pendent borrar (confirmar)', '7');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'F', 'Finalit.', 'Finalitzat', '8');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'R', 'P. Reubic.', 'Pendent reubicació', '9');
insert into sgarefcodes (domain, value, abbreviation, meaning, orderdisp) values ('ESTORDTRAN', 'Z', 'Susp. Err.', 'Suspes per codig error', '9');



-- tipus de documents
insert into sgatipdoc (idtipdoc, descrip, tipmov, host) values ('EN', 'Entrades', 'E', 'S');
insert into sgatipdoc (idtipdoc, descrip, tipmov, host) values ('SO', 'Sortides', 'S', 'S');
insert into sgatipdoc (idtipdoc, descrip, tipmov, host) values ('EM', 'Entrades Manuals', 'E', 'N');


------- PROCES D'IMPORTACIÓ DE DADES ---------
--Vistes sobre if
--Vista punt de partida per fer l'exportació de les ubicacions i posicions de miniload i silo
CREATE OR REPLACE VIEW "IF"."SGAVEXPORTUBICACIONES" ("PASILLO",
    "LADO","COLUMNA","NIVEL","IDTIPALM","IDTIPUBI","ACCESO",
    "ESTADO","POSICION", "IDUBI_OLD") AS 
    select decode(hs.hus_id_silo, 1, 0, 2, hs.hus_id_pasillo) as pasillo, 
hs.hus_lado as lado, 
lpad(hs.hus_profundidad,3,'0') as columna, 
lpad(hs.hus_altura, 2, '0') as nivel,
decode(hs.hus_id_silo, 1, 'MLD', 2, 'SLO') as idtipalm,
decode(h.hu_id_tipo_hueco, 1, 'CUB', 2, 'CON', 3, 'CON', 4, 'EP', 5, 'JLA', 6, 'CUB', 7, 'JLA', 8, 'EP') as idtipubi,
decode(p.po_id_estado_posicion, 0, 'L', 1, 'L', 2, 'B', 4, 'L') as acceso,
decode(p.po_id_estado_posicion, 0, 'L', 1, 'O', 2, 'L', 4, 'R') as estado,
p.po_id_posicion as posicion,
h.hu_id_hueco as idubi_old
from hueco_silo hs, posicion p, hueco h 
where hs.hus_id_hueco = p.po_id_hueco 
and hs.hus_id_hueco = h.hu_id_hueco


CREATE VIEW "IF"."SGAVEXPORTUBICACION1" AS 
    select pasillo, 
lado, 
columna, 
nivel,
idtipalm,
idtipubi,
decode(idtipalm, 'MLD', 50, decode(pasillo, 1, 25, 2, 30, 3, 35, 40)) posplc,
idubi_old
from sgavexportubicaciones
group by pasillo, lado, columna, nivel, idtipalm, idtipubi, idubi_old

-- Vista punt de partida per l'exportació de les referències

CREATE VIEW "IF"."SGAVEXPORTREFERENCIAS" AS 
    SELECT R.RE_PESO_REFERENCIA AS PESUNIT, 
RC.RC_ID_REFERENCIA_CLIENTE AS IDARTIF,
RC.RC_DESCRIPCION AS DESCRIP,
RC.RC_FECHA AS FECCRE,
DECODE(RC.RC_CONTROL_PESO, 0, 'N', 1, 'S') AS CONTROLPES,
RC.RC_CODIGO_BARRAS AS CODEAN,
RC.RC_UNIDADES_EMBALAJE AS UNIEMB,
DECODE(RI.REI_ID_TIPO_CONTENEDOR, 1, 'CUB', 2, 'CON', 3, 'JLA', 4, 'EP', null) AS IDTIPMAC,
RI.REI_UNIDADES_MAX AS UNIMAC,
DECODE(RI.REI_CONTENEDOR_ENTERO, 0, 'N', 1, 'S') AS RELLENO,
DECODE(RI.REI_ID_TIPO_CONTENEDOR, 1, RIT.REI_TIPO_PROD_MINILOAD, RIT.REI_TIPO_PROD_SILO) AS ROTACION,
R.RE_ID_REFERENCIA AS IDART_OLD
FROM REFERENCIA R, REFERENCIA_CLIENTE RC, REFERENCIA_IF_TIPO RIT, REFERENCIA_IF RI
WHERE R.RE_ID_REFERENCIA = RC.RC_ID_REFERENCIA 
AND R.RE_ID_REFERENCIA = RIT.REI_ID_REFERENCIA 
AND R.RE_ID_REFERENCIA = RI.REI_ID_REFERENCIA (+)
AND RC.RC_ID_REFERENCIA_CLIENTE != 'REF. NULA'

-- Vista punt de partida per l'exportació de macs

CREATE VIEW "IF"."SGAVMAC" AS 
    select co_id_contenedor as idmac, 
decode(co_id_tipo_contenedor, 1, 'CUB', 2, 'CON', 3, 'JLA', 4, 'EP') as idtipmac, 
co_id_hueco as idubi_old,
co_id_posicion as posubipos
from contenedor 

-- Vista punt de partida per l'exportació d'existències

CREATE VIEW "IF"."SGAVEXISTENCIES" AS 
    select lot_id_lote as idmac, 
lot_tiempo_entrada as feccre, 
co_id_cantidad_referencia as cantot,
lot_id_referencia as idart_old
from lote, contenedor 
where lot_id_lote = co_id_contenedor


-- Processos sobre ifdba
-- Sequencia per l'identificador d'ubicacions
CREATE SEQUENCE "IFDBA"."SEQ_IDUBIC" INCREMENT BY 1 START WITH 1 
    MAXVALUE 1.0E28 MINVALUE 1 NOCYCLE 
    CACHE 20 NOORDER

-- Inserta les ubicacions corresponents a miniload i silo
insert into sgaubicacion (idubi, pasillo, columna, nivel, lado, idtipubi, idtipalm, posplc, idubi_old)
(select lpad(to_char(seq_idubic.nextval), 6, '0'), pasillo, columna, nivel, lado, idtipubi, idtipalm, posplc, idubi_old from 
 if.sgavexportubicacion1); 

-- Substituit per un plsql que crea les posicions (lliures) segons el tipus d'ubicació
-- Inserta les posicions corresponents a les ubicacions de miniload i silo
--insert into sgaposicionubicacion(idubi, posicion, estado, acceso) 
--(select u.idubi, v.posicion, v.estado, v.acceso from if.sgavexportubicaciones v, sgaubicacion u
--where u.idubi_old = v.idubi_old);

declare
       cursor curubicacions is
              select idubi, idtipubi, columna, nivel
              from sgaubicacion
              where idubi != 'PK1MLD' and idubi != 'PK2MLD';
       numposicions integer := 0;
       cont integer := 0;
       
begin
     for lcurubicacions in curubicacions loop
         cont := 0;
         if (lcurubicacions.idtipubi = 'EP') then
            numposicions := 3;
            if (lcurubicacions.columna = 1 and lcurubicacions.nivel = 8) then
               numposicions := 1;
            end if;
         elsif (lcurubicacions.idtipubi = 'CON') then 
            numposicions := 2;
         elsif (lcurubicacions.idtipubi = 'JLA') then
            numposicions := 1;
         elsif (lcurubicacions.idtipubi = 'CUB') then
            numposicions := 2;
         end if;
         -- Inserterm les posicions
         while cont < numposicions loop
           insert into sgaposicionubicacion(idubi, posicion, estado, acceso) 
                  values (lcurubicacions.idubi, cont + 1, 'L', 'L');
           cont := cont + 1;
         end loop;
     end loop;
end;

--Sequencia per l'identificador de la referencia    
CREATE SEQUENCE "IFDBA"."SEQ_IDART" INCREMENT BY 1 START WITH 1 
    MAXVALUE 1.0E28 MINVALUE 1 NOCYCLE 
    CACHE 20 NOORDER    
    
-- Inserta les referencies    
insert into sgaarticulo (idart, descrip, pesunit, controlpes, createdon, codean, uniemb, idtipmac, unimac, relleno, multiref, rotacion, picking1, idartif, idart_old)
(select lpad(to_char(seq_idart.nextval), 14, 0), descrip, pesunit, controlpes, feccre, codean, uniemb, idtipmac, unimac, relleno, 'N', rotacion, 'N', idartif, idart_old
from if.sgavexportreferencias);    
 
 
-- Inserta els macs
insert into sgamac(idmac, idtipmac, estado, ubipos, posubipos, ubides, posubides)
(select idmac, idtipmac, 'L', idubi, 
--posubipos, idubi, posubipos 
decode (idtipmac, 'CUB', posubipos, 'CON', posubipos, 'JLA', decode(u.idtipubi, 'CON', posubipos - 1, posubipos), 'EP', posubipos),
idubi, decode (idtipmac, 'CUB', posubipos, 'CON', posubipos, 'JLA', decode(u.idtipubi, 'CON', posubipos - 1, posubipos), 'EP', posubipos)
from if.sgavmac m, sgaubicacion u
where m.idubi_old = u.idubi_old);

-- Actualitza els estats de les ubicacions segons els macs insertats
declare
  cursor curmacubic is
    select m.ubipos, m.posubipos, tm.numpos 
    from sgamac m, sgatipomac tm
    where m.idtipmac = tm.idtipmac;
  numpos integer := 0;
  cont integer := 0;
begin
     for lcurmacubic in curmacubic loop
         cont := 0;
         numpos := lcurmacubic.numpos;
         while cont < numpos loop
           update sgaposicionubicacion
           set estado = 'O' 
           where idubi = lcurmacubic.ubipos
           and posicion = lcurmacubic.posubipos + cont;
           cont := cont + 1;
         end loop;
     end loop;
end;

-- Hi ha diferencies entre la quantitat de macs a IF i la quantitat de macs que 
-- es traspassen. Això es degut a que els que estan en transit, estan en ubicacions
-- que no estan donades d'alta. El seguent select indica quins son aquests macs
select * from if.sgavmac m where not m.idmac in (select idmac from sgamac);

-- Inserta les existencies
insert into sgaexistencia (idmac, cantot, idart, createdon, canres, estado, bloqueo)
(select e.idmac, cantot, idart, e.feccre, 0, 'L', 'N'
from if.sgavexistencies e, sgamac m, sgaarticulo a
where e.idmac = m.idmac
and a.idart_old = e.idart_old);    


-- Actualiza distancias de las ubicaciones MLD
update sgaposicionubicacion upu set udistancia = (
select up.posicion * 2000 + u.columna * 8 + u.nivel * 3
       from sgaubicacion u, sgaposicionubicacion up
       where u.idubi = up.idubi
       and u.idtipalm = 'MLD'
       and up.idubi = upu.idubi
       and up.posicion = upu.posicion)
where upu.idubi in (select idubi 
      from sgaubicacion
      where sgaubicacion.idtipalm = 'MLD');
      
-- No commit?

-- Actualiza distancias de las ubicaciones SLO      
update sgaposicionubicacion upu set udistancia = (
select u.columna * 8 + u.nivel * 3
       from sgaubicacion u, sgaposicionubicacion up
       where u.idubi = up.idubi
       and u.idtipalm = 'SLO'
       and up.idubi = upu.idubi
       and up.posicion = upu.posicion)
where upu.idubi in (select idubi 
      from sgaubicacion
      where sgaubicacion.idtipalm = 'SLO');

-- Sequencia per la taula sgamovimiento
CREATE SEQUENCE "IFDBA"."SEQ_IDMOV" INCREMENT BY 1 START WITH 1 
    MAXVALUE 1.0E28 MINVALUE 1 NOCYCLE 
    CACHE 20 NOORDER      
-- No commit?

-- TODO: ROTACION de los huecos del almacén

-- Crea els stocks inicials
insert into sgastock (idart, stock, estado) (select idart, cantot, 'C' from sgavsumexistencia);

-- S'han de bloquejar
-- Miniload: Costat 0, Columna 11, Nivell 16
update sgaposicionubicacion set acceso = 'B' where idubi in (select idubi from sgaubicacion where columna = 11 and nivel= 16 and lado = 0 and idtipalm = 'MLD');
-- S'han d'esborrar
-- Maxiload: Passadis 1, Costat 0, Columna 17, Nivell 1 (Entrada extra)
delete from sgaposicionubicacion where idubi in (select idubi from sgaubicacion where columna = 17 and nivel= 1 and lado = 0 and idtipalm = 'MLD');
delete from sgaubicacion where columna = 17 and nivel= 1 and lado = 0 and idtipalm = 'MLD';
--           Passadis 1 al 4, Costat 1 i 2, Columna 18, Nivell 8, Posicio 3
delete from sgaposicionubicacion where idubi in (select idubi from sgaubicacion where columna=18 and nivel=8 and idtipalm = 'SLO') and posicion = 3;

-- Llista d'ubicacions if amb acces bloquejat o estat reservat
select * from sgavexportubicaciones where acceso = 'B' order by idtipalm;
select * from sgavexportubicaciones where estado ='R' order by idtipalm;
  