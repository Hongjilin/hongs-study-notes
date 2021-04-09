@echo off
mode con cols=100 lines=30 & color fc

rem 获取管理员权限
:: BatchGotAdmin  
:-------------------------------------  
rem  --> Check for permissions  
>nul 2>&1 "%SYSTEMROOT%\system32\cacls.exe" "%SYSTEMROOT%\system32\config\system"
rem --> If error flag set, we do not have admin.  
if '%errorlevel%' NEQ '0' (  
    echo 获取管理员权限中,如果UAC弹窗,请选择允许...
    goto UACPrompt  
) else ( goto gotAdmin )   
:UACPrompt  
    echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"  
    echo UAC.ShellExecute "%~s0", "", "", "runas", 1 >> "%temp%\getadmin.vbs"   
    "%temp%\getadmin.vbs"
    exit /B  
:gotAdmin  
    if exist "%temp%\getadmin.vbs" ( del "%temp%\getadmin.vbs" )  
    pushd "%CD%"  
    CD /D "%~dp0"

rem 激活部分
cls
:start
echo\
echo                                请输入数字选择(请以管理员模式运行):
echo\
echo           ==============================================================================
echo           *                                                                            *
echo           *                        1：激活 Windows10 专业版                            *
echo           *                                                                            *
echo           ==============================================================================
echo           ==============================================================================
echo           *                                                                            *
echo           *                        2：激活 Windows8.1 专业版                           *
echo           *                                                                            *
echo           ==============================================================================
echo           ==============================================================================
echo           *                                                                            *
echo           *                         3：激活 Windows8 专业版                            *
echo           *                                                                            *
echo           ==============================================================================
echo           ==============================================================================
echo           *                                                                            *
echo           *                         4：激活 Windows7 专业版                            *
echo           *                                                                            *
echo           ==============================================================================
echo           ==============================================================================
echo           *                                                                            *
echo           *                         5：查看 Windows 激活状态                           *
echo           *                                                             By：淡定定定哥 *
echo           ==============================================================================
set /P var=":"
if %var%==1 goto 10
if %var%==2 goto 8.1
if %var%==3 goto 8
if %var%==4 goto 7
if %var%==5 goto look

:10
cls
echo\
echo           ******************************************************************************
echo           *                                                                            *
echo           *     接下来将自动激活,弹窗三次,请点击每一步弹窗的确定,激活过程需要联网      *
echo           *                                                                            *
echo           ******************************************************************************
echo\
echo                                         第一步 安装产品密钥...
echo\
slmgr -ipk W269N-WFGWX-YVC9B-4J6C9-T83GX
echo\
echo                                     第二步 设置密钥管理服务计算机...
echo\
slmgr -skms www.ddddg.cn
echo\
echo                                         第三步 自动联网激活...
echo\
slmgr -ato
goto exit


:8.1
cls
echo\
echo           ******************************************************************************
echo           *                                                                            *
echo           *     接下来将自动激活,弹窗三次,请点击每一步弹窗的确定,激活过程需要联网      *
echo           *                                                                            *
echo           ******************************************************************************
echo\
echo                                         第一步 安装产品密钥...
echo\
slmgr -ipk GCRJD-8NW9H-F2CDX-CCM8D-9D6T9
echo\
echo                                     第二步 设置密钥管理服务计算机...
echo\
slmgr -skms www.ddddg.cn
echo\
echo                                         第三步 自动联网激活...
echo\
slmgr -ato
goto exit


:8
cls
echo\
echo           ******************************************************************************
echo           *                                                                            *
echo           *     接下来将自动激活,弹窗三次,请点击每一步弹窗的确定,激活过程需要联网      *
echo           *                                                                            *
echo           ******************************************************************************
echo\
echo                                         第一步 安装产品密钥
echo\
slmgr -ipk NG4HW-VH26C-733KW-K6F98-J8CK4
echo\
echo                                     第二步 设置密钥管理服务计算机...
echo\
slmgr -skms www.ddddg.cn
echo\
echo                                         第三步 自动联网激活...
echo\
slmgr -ato
goto exit

:7
cls
echo\
echo           ******************************************************************************
echo           *                                                                            *
echo           *     接下来将自动激活,弹窗三次,请点击每一步弹窗的确定,激活过程需要联网      *
echo           *                                                                            *
echo           ******************************************************************************
echo\
echo                                         第一步 安装产品密钥...
echo\
slmgr -ipk FJ82H-XT6CR-J8D7P-XQJJ2-GPDD4
echo\
echo                                     第二步 设置密钥管理服务计算机...
echo\
slmgr -skms www.ddddg.cn
echo\
echo                                         第三步 自动联网激活...
echo\
slmgr -ato
goto exit


:look
cls
echo\
echo                                          请注意查看弹窗内容
slmgr.vbs -dlv
goto exit


:exit
echo\
echo\
echo\
echo\
echo\
echo\
echo           *******************************指令已经完成***********************************
echo           *                                                                            *
echo           *                                                                            *
echo           *            按任意键退出,并支持一下我(如果激活成功,请给我点个赞)            *
echo           *                                                                            *
echo           *                                                        http://www.ddddg.cn *
echo           *******************************By:淡定定定哥**********************************
pause>nul 
start https://www.ddddg.cn/ & exit
