-- Michael 23.04.2008
-- OJO; Todas las ubicaciones manuales hasta la fecha han sido dados de alta con:
--           (v_passadis || lpad(v_columna, 2, '0') ||
--           lpad(v_nivell, 2, '0') || 0,
-- TODO: Habr�a que mirar de cambiarlos si realmente se usar� etiquetas para identificar las ubicaciones 
begin
  for v_passadis in 11 .. 11 loop
    for v_columna in 1 .. 4 loop
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