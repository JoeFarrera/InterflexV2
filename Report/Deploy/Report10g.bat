@echo off
set oldpath=%path%
set path=.\jre\bin;%PATH%
echo arrancando SgaBalay...
java -jar Report.jar
set path=%oldpath%
exit