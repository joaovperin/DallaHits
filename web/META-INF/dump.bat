@echo off
setlocal EnableDelayedExpansion
rem
rem Define as vari�veis do Bat
:SetaVarBat
rem Define as constantes dos locais dos arquivos
   set PATH=%PATH%;C:\Program Files (x86)\MySQL\MySQL Workbench 6.3 CE\
   set MYSQL=MySQLWorkbench.exe
   set ENTRADA=%cd%\modelo\modelo.mwb
   set SAIDA_SQL=%cd%\modelo\BD_Tables
   set SCRIPT_PY=%cd%\script_py\script.py
rem Inicializa vari�veis de controle
   set MAX_TENTATIVAS=3
   set SLEEP_TIME=5
   set NUM=0
   set MYSQL_RUN=
rem Controle de altera��o do arquivo de sa�da
   set BD_HEADER=oldHeader
   set BD_NEW_HEADER=newHeader
rem
rem Executa valida��es antes de gerar o Script
:ExecutaRotinasIniciais
rem Se o Workbench j� estiver aberto, pede pra encerrar
   call :VerificaWorkbenchAberto
   if not "%MYSQL_RUN%"=="" (
      echo Por favor, feche o MySQLWorkbench e execute novamente o Batch.
      goto :Fim
   )
rem L� o header do arquivo
   if exist "%SAIDA_SQL%.sql" (
      set /p BD_HEADER=<%SAIDA_SQL%.sql
   )
rem
rem In�cio
:Inicio
rem Abre o MySQLWorkbench
   echo Abrindo MySQLWorkbench...
   start %MYSQL% -model %ENTRADA%
   call :AguardaAberturaMySQLWorkbench
rem Se estourar o timeout
   if "%MYSQL_RUN%"=="" (
       echo Falha ao abrir MySQLWorkbench.
       goto:Fim
   )
rem Aguarda 3 segundos e roda o Script de forma s�ncrona
   SLEEP 3 & call %MYSQL% -run-script %SCRIPT_PY% -quit-when-done
rem Se criar com sucesso, informa e abre a sa�da com editpad
   if "%ERRORLEVEL%"=="0" (
rem Se existe o arquivo de sa�da'
       if exist "%SAIDA_SQL%.sql" (
          set /p BD_NEW_HEADER=<%SAIDA_SQL%.sql
rem Se alterou o header do arquivo
          if not "!BD_NEW_HEADER!"=="!BD_HEADER!" (
             start notepad %SAIDA_SQL%.sql
             goto :Fim
          )
       )
   )
rem Se deu falha :/
   echo Falha ao gerar arquivo %SAIDA_SQL%.sql.
goto:Fim
rem
rem Verifica se MySQLWorkbench est� aberto e abre-o se necess�rio
:AguardaAberturaMySQLWorkbench
rem Se ultrapassou o limite de tentativas, encerra
    if /I %NUM% GEQ %MAX_TENTATIVAS% (
        goto:eof
    )
    rem Incrementa n�mero de tentativas
    set /a NUM=%NUM%+1
    SLEEP %SLEEP_TIME% & call :VerificaWorkbenchAberto
    if "%MYSQL_RUN%"=="" (
        goto:AguardaAberturaMySQLWorkbench
    ) else (
rem Se abrir, reseta n�mero de tentativas e encerra normalmente
        set NUM=0
    )
goto:eof
rem
rem Verifica se o MySQLWorkbench est� aberto
:VerificaWorkbenchAberto
   tasklist | findstr MySQLWorkbench.exe > C:\TMP\search_mysql.log
   FOR /F %%A IN (C:\TMP\search_mysql.log) DO IF %%~zA EQU 0 SET MYSQL_RUN=true
   del /F C:\TMP\search_mysql.log >nul
goto:eof
rem
rem Finaliza��o
:Fim
endlocal