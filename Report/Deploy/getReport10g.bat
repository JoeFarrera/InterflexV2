@echo off
@echo Conectando al monwsga1..
net use i: \\monwsga1\deployreport10g AutoMatico /USER:monwsga1\sga_monwsga1
@echo copiando ficheros..
copy i:Report.jar c:\temp\Deploy10g\*.*
copy i:*.bat c:\temp\Deploy10g\*.*
@echo desconectando de la unidad de red
net use i: /delete
