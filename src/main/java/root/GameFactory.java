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

package root;

import root.logic.*;
import root.logic.config.CommandLineArgumentParser;
import root.logic.console.CellNumberConverter;
import root.logic.console.ConsoleGameOverHandler;
import root.logic.console.ConsoleShowGame;
import root.logic.console.ConsoleUserInputReader;
import root.logic.console.keypad.DesktopNumericKeypadCellNumberConverter;
import root.logic.strategy.*;
import root.logic.swing.GameWindow;
import root.model.config.PlayerType;
import root.model.config.UserInterface;
import root.model.game.Player;

import static root.model.config.PlayerType.USER;
import static root.model.config.UserInterface.GUI;
import static root.model.game.Sign.O;
import static root.model.game.Sign.X;

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
        final ComputerMoveStrategy[] strategies = {
                new PreventUserWinComputerMoveStrategy(),
                new WinNowComputerMoveStrategy(),

                new WinOnTheNextStepComputerMoveStrategy(),
                new FirstMoveToTheCenterComputerMoveStrategy(),
                new RandomComputerMoveStrategy()
        };
        final ShowGame showGame;
        final UserInputReader userInputReader;
        final GameOverHandler gameOverHandler;
        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            showGame = gameWindow;
            userInputReader = gameWindow;
            gameOverHandler = gameWindow;

        } else {
            final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
            showGame = new ConsoleShowGame(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, showGame);
            gameOverHandler = new ConsoleGameOverHandler(showGame);
        }
        final Player player1;
        final Player player2;
        if (player1Type == USER) {
            player1 = new Player(X, new User(userInputReader, showGame));
        } else {
            player1 = new Player(X, new Computer(strategies));
        }

        if (player2Type == USER) {
            player2 = new Player(O, new User(userInputReader, showGame));
        } else {
            player2 = new Player(O, new Computer(strategies));
        }

        return new Game(showGame,
                player1,
                player2,
                new Verifier(),
                new DrawVerifier(),
                gameOverHandler);
    }


    }




