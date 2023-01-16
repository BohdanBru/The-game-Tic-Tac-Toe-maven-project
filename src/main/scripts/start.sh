#!/usr/bin/env sh
# The cmd script to start tic-tac-toe game for Unix system
# author Bohdan Brukhovets
# emaul: mattewgreenman@gmail.com
# linkdin: https://www.linkedin.com/in/bohdan-brukhovets/

cd "$(dirname "$0")" || exit
java -jar ${project.build.finalName}.jar
echo "Please, press ENTER to continue . . . "
read -r test