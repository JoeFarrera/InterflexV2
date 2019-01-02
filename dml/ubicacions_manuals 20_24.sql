-- Michael 23.04.2008
-- OJO; Todas las ubicaciones manuales hasta la fecha han sido dados de alta con:
--           (v_passadis || lpad(v_columna, 2, '0') ||
--           lpad(v_nivell, 2, '0') || 0,
-- TODO: Habría que mirar de cambiarlos si realmente se usará etiquetas para identificar las ubicaciones 
-- passadis nº 20, 21, 22, 23, 24
-- 9 columes de 3 nivells


begin
  for v_passadis in 20 .. 24 loop
    for v_columna in 1 .. 9 loop
      for v_nivell in 1 .. 3 loop
        insert into sgaubicacion
        values
          (lpad(v_passadis, 2) || lpad(v_columna, 2, '0') ||
           lpad(v_nivell, 2, '0'),
           v_passadis,
           lpad(v_columna, 2, '0'),
           lpad(v_nivell, 2, '0'),
           0,
           'MAN',
           'A',
           null,
           null,
           null,
           null,
           null,
           'MAN',
           null,
           'root',
           null,
           sysdate,
           null);
      end loop;
    end loop;
  end loop;  
end;