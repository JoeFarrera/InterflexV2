declare

begin
insert into sgacdoc (iddoc, idcabstr, idcabnum, numlineas, numbultos, estado, IDTIPDOC)
values (seq_iddoc.nextval, 'MICK', seq_iddoc.currval, 3, 0, 'D', 'SO');

insert into sgaldoc (iddoc, idlin, cantot, canpen, canres, idart)
values (seq_iddoc.currval, 1, 100, 100, 0, (select idart from sgaarticulo where idartif = 'AGT-17G'));

insert into sgaldoc (iddoc, idlin, cantot, canpen, canres, idart)
values (seq_iddoc.currval, 2, 100, 100, 0, (select idart from sgaarticulo where idartif = 'AGT-23G'));


insert into sgaldoc (iddoc, idlin, cantot, canpen, canres, idart)
values (seq_iddoc.currval, 3, 1000, 1000, 0, (select idart from sgaarticulo where idartif = 'ECT-23G'));
end;
