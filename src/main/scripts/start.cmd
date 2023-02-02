@rem The cmd script to start tic-tac-toe game for Windows system
@rem author Bohdan Brukhovets
@rem emaul: mattewgreenman@gmail.com
@rem linkdin: https://www.linkedin.com/in/bohdan-brukhovets/
@ echo off
setlocal
@rem---------------------------------------------------------------------------------------
@rem Try to use the java.exe from %JAVA_HOME%, if this environment variable set correctly:
if "%JAVA_HOME%" neq "" (
    if exist %JAVA_HOME%\bin\java.exe (
        set JAVA_CMD=%JAVA_HOME%\bin\java
    )
)
@rem -------------------------------------------------------------------------------------------------------------------
@rem Try to use the `java.exe` using `PATH` environment variable:
where /Q java
if %ERRORLEVEL% == 0 (
    set JAVA_CMD=java
)
@rem -------------------------------------------------------------------------------------------------------------------
@rem Try to use `java.exe` from JRE if `jre\bin\java.exe` exists:
if exist jre\bin\java.exe (
    set JAVA_CMD=jre\bin\java
)
@rem -------------------------------------------------------------------------------------------------------------------
if not defined JAVA_CMD (
    @rem Throw error if `java.exe` is not configured:
    echo -------------------------------------------------------------------------- >&2
    echo `java.exe` not defined! Install or configure JVM before using this script! >&2
    echo -------------------------------------------------------------------------- >&2
    set RETURN_CODE=1
) else (
    @rem Run tic-tac-toe game:
    %JAVA_CMD% -jar ${project.build.finalName}-release.jar %*
    set RETURN_CODE=0
)
@rem -------------------------------------------------------------------------------------------------------------------
exit /b %RETURN_CODE%
pause
@rem C:\Users\User\IdeaProjects\tic-tac-toe-maven\out\tic-tac-toe.jar