@echo off
setlocal EnableExtensions
setlocal EnableDelayedExpansion
set "params=%*"
cd /d "%~dp0" && ( if exist "%temp%\getadmin.vbs" del "%temp%\getadmin.vbs" ) && fsutil dirty query %systemdrive% 1>nul 2>nul || (  echo Set UAC = CreateObject^("Shell.Application"^) : UAC.ShellExecute "cmd.exe", "/k cd ""%~sdp0"" && %~s0 %params%", "", "runas", 1 >> "%temp%\getadmin.vbs" && "%temp%\getadmin.vbs" && exit /B )
title=添加并启用卓越性能电源计划
powercfg /list | find "(卓越性能)" > NUL
if %ERRORLEVEL% == 0 (
goto SetActive
) else (
goto DuplicateScheme
)

:DuplicateScheme
powercfg /DUPLICATESCHEME e9a42b02-d5df-448d-aa00-03f14749eb61 && echo 导入完成。 && goto SetActive

:SetActive
for /f "tokens=3,4" %%i in ('powercfg /list') do (
if "%%j" == "(卓越性能)" powercfg /SETACTIVE %%i && echo 激活成功。 && goto EOF
)

:EOF
pause
exit