@echo off
echo ...........................................................................................
echo lista de processo em execucao
tasklist | find "chromedriver"
echo ...........................................................................................
echo finalizando todos os processos chromedriver.exe
taskkill /F /IM "chromedriver.exe"
echo ...........................................................................................
echo lista de processo em execucao
tasklist | find "chromedriver"
echo ...........................................................................................


@echo off
echo ...........................................................................................
echo lista de processo em execucao
tasklist | find "IEDriverServer"
echo ...........................................................................................
echo finalizando todos os processos IEDriverServer.exe
taskkill /F /IM "IEDriverServer.exe"
echo ...........................................................................................
echo lista de processo em execucao
tasklist | find "IEDriverServer"
echo ...........................................................................................


@echo off
echo ...........................................................................................
echo lista de processo em execucao
tasklist | find "geckodriver"
echo ...........................................................................................
echo finalizando todos os processos geckodriver.exe
taskkill /F /IM "geckodriver.exe"
echo ...........................................................................................
echo lista de processo em execucao
tasklist | find "geckodriver"
echo ...........................................................................................


@echo off
echo ...........................................................................................
echo lista de processo em execucao
tasklist | find "msedge"
echo ...........................................................................................
echo finalizando todos os processos msedge.exe
taskkill /F /IM "msedge.exe"
echo ...........................................................................................
echo lista de processo em execucao
tasklist | find "msedge"
echo ...........................................................................................
pause 5