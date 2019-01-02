begin
  for v_passadis in 1 .. 1 loop
    for v_columna in 1 .. 6 loop
      for v_nivell in 1 .. 6 loop
        insert into sgaubicacion
        values
          (v_passadis || lpad(v_columna, 2, '0') ||
           lpad(v_nivell, 2, '0') || 0,
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

  for v_passadis in 2 .. 3 loop
    for v_columna in 1 .. 6 loop
      for v_nivell in 1 .. 7 loop
        insert into sgaubicacion
        values
          (v_passadis || lpad(v_columna, 2, '0') ||
           lpad(v_nivell, 2, '0') || 0,
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

  for v_passadis in 4 .. 6 loop
    for v_columna in 1 .. 5 loop
      for v_nivell in 1 .. 7 loop
        insert into sgaubicacion
        values
          (v_passadis || lpad(v_columna, 2, '0') ||
           lpad(v_nivell, 2, '0') || 0,
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
  
  for v_passadis in 7 .. 8 loop
    for v_columna in 1 .. 3 loop
      for v_nivell in 1 .. 7 loop
        insert into sgaubicacion
        values
          (v_passadis || lpad(v_columna, 2, '0') ||
           lpad(v_nivell, 2, '0') || 0,
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