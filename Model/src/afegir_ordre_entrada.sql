declare
begin
insert into sgacdoc
  (iddoc, idcabstr, idcabnum, numlineas, numbultos, estado, idtipdoc)
values
  (seq_iddoc.nextval, 'VC', seq_iddoc.currval, 1, 0, 'D', 'EN');
insert into sgaldoc
  (idlin, canpen, cantot, estado, iddoc, canres, idart, feccre)
values
  (1, 100, 100, 'N', seq_iddoc.currval, 0, (select idart from sgaarticulo where idartif = 'BM00251'), sysdate);
insert into sgaldoc
  (idlin, canpen, cantot, estado, iddoc, canres, idart, feccre)
values
  (2, 200, 200, 'N', seq_iddoc.currval, 0, (select idart from sgaarticulo where idartif = 'BM00706'), sysdate);
insert into sgabulto
  (idbulto, iddoc)
values
  (1, seq_iddoc.currval);
insert into sgabulto
  (idbulto, iddoc)
values
  (2, seq_iddoc.currval);
insert into sgalbulto
  (idbulto, iddoc, idlin, cantot, canres, canpen, estado, unimac, idtipmac)
values
  (1, seq_iddoc.currval, 1, 100, 0, 100, 'N', (select unimac from sgaarticulo where idartif = 'BM00251'), (select idtipmac from sgaarticulo where idartif = 'BM00251'));  
insert into sgalbulto
  (idbulto, iddoc, idlin, cantot, canres, canpen, estado, unimac, idtipmac)
values
  (2, seq_iddoc.currval, 2, 200, 0, 200, 'N', (select unimac from sgaarticulo where idartif = 'BM00706'), (select idtipmac from sgaarticulo where idartif = 'BM00706'));  
end;

