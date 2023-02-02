# The-game-Tic-Tac-Toe-maven-project

## The tic-tac-toe with  modes:

-Window mode (GUI); -Console mode;

## Build instructions

- Build distribusion using maven tool:

````bash
mvn clean packege
````

- Use the following archives:
  - out\tic-tac-toe-maven-2.0-windows.zip for Windows
  - out\tic-tac-toe-maven-2.0-unix.tar.gz for MacOs and Linx

***

## Run instruction

### Without JRE

- Download OpenJDK 11;
- unzip downloaded OpenJDK archive;
- Configure the `PATH` environment variable:
  - Add %JDK_HOME%\bin directory for Windows;
  - Add %JDK/HOME%/bin directory for MacOS and Linux -Re-Login or restart computer; -Unzip Tic Tac Toe distribution:
  - Unzip tic-tac-toe-${project.version}-windows.zip for Windows;
  - Unzip tic-tac-toe-${project.version}-unix.tar.gz for MacOs and Linx; -Go to unziped directory; -Run the game by
    double-click on the start script:
  - start.cmd for Windows;
  - start.sh for MacOs and Linux

The prodjec contane:

1. JAR itself start archive
2. intelf start archive for Microsoft Windows x86\64
3. intelf start archive for unix system (Linux, Mac OS).

***
For using needs to unzip archive and press start script.
***

## With JRE

### Build instruction

- Build description using maven tools:

```bash
mvn -P without-jre clean package
```

- Use the following archives:
  - out\tic-tac-toe-maven-2.0-windows.zip for Windows
  - out\tic-tac-toe-maven-2.0-MacOs-with-jre.tar.gz for MacOs
  - out\tic-tac-toe-maven-2.0-Linux-with-jre.tar.gz for Linux

### Run instruction

-Unzip the Tic Tac Toe distribution:
-tic-tac-toe-maven-2.0-windows.zip for Windows

- tic-tac-toe-maven-2.0-MacOs-with-jre.tar.gz for MacOs
- tic-tac-toe-maven-2.0-Linux-with-jre.tar.gz for Linux -Go to unzipped directory;
- Run the game by double-click on the start script:
  - start.cmd for Windows;
  - startConsoleModeUserComputer.cmd for Windows;
  - startConsoleModeUserUser.cmd for Windows;
  - startWindowModeUserUser.cmd for Windows;
  - startWindowModeUserComputer.cmd for Windows;
  - start.sh for MacOs or Linux;
  - startConsoleModeUserComputer.sh for MacOs or Linux;
  - startConsoleModeUserUser.sh for MacOs or Linux;
  - startWindowModeUserUser.sh for MacOs or Linux;
  - startWindowModeUserComputer.sh for MacOs or Linux;

