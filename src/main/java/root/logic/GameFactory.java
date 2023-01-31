/*
 * Copyright 2023 Bohdan Brukhovets
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package root.logic;

import root.logic.console.ConsoleShowGame;
import root.logic.console.ConsoleUserInputReader;
import root.logic.keypad.DesktopNumericKeypadCellNumberConverter;
import root.logic.swing.GameWindow;
import root.model.Player;
import root.model.PlayerType;
import root.model.UserInterface;

import static root.model.PlayerType.USER;
import static root.model.Sign.O;
import static root.model.Sign.X;
import static root.model.UserInterface.GUI;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class GameFactory {
    private final PlayerType player1Type;

    private final PlayerType player2Type;

    private final UserInterface userInterface;


    public GameFactory(final String[] args) {


        final CommandLineArgumentParser.CommandLineArguments commandLineArguments = new CommandLineArgumentParser(args).parser();
        player1Type = commandLineArguments.getPlayer1Type();
        player2Type = commandLineArguments.getPlayer2Type();
        userInterface = commandLineArguments.getUserInterface();

    }


    public Game create() {

        /* final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();*/
        final ShowGame showGame;
        final UserInputReader userInputReader;
        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            showGame = gameWindow;
            userInputReader = gameWindow;

        } else {
            final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
            showGame = new ConsoleShowGame(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, showGame);
        }
        final Player player1;
        final Player player2;
        if (player1Type == USER) {
            player1 = new Player(X, new User(userInputReader, showGame));
        } else {
            player1 = new Player(X, new Computer());
        }

        if (player2Type == USER) {
            player2 = new Player(O, new User(userInputReader, showGame));
        } else {
            player2 = new Player(O, new Computer());
        }

        return new Game(showGame,
                player1,
                player2,
                new Verifier(),
                new DrawVerifier());
    }


    }




