@echo off
echo arrancando Reports..
set oldpath=%path%
set path=C:\StyleReportPro\bin\%PATH%
java -Xms128m -Xmx512m -jar Report.jar 