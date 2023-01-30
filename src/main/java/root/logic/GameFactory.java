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

import root.CommandLineArgumentParser;
import root.logic.keypad.DesktopNumericKeypadCellNumberConverter;
import root.model.Player;
import root.model.PlayerType;

import static root.model.PlayerType.USER;
import static root.model.Sign.O;
import static root.model.Sign.X;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class GameFactory {
    private final PlayerType player1Type;

    private final PlayerType player2Type;


    public GameFactory(final String[] args) {

        final CommandLineArgumentParser.PlayerTypes playerTypes = new CommandLineArgumentParser(args).parser();
        this.player1Type = playerTypes.getPlayer1Type();
        this.player2Type = playerTypes.getPlayer2Type();

    }


    public Game create() {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        final Player player1;
        final Player player2;
        if (player1Type == USER) {
            player1 = new Player(X, new User(cellNumberConverter));
        } else {
            player1 = new Player(X, new Computer());
        }

        if (player1Type == USER) {
            player2 = new Player(O, new User(cellNumberConverter));
        } else {
            player2 = new Player(O, new Computer());
        }

        return new Game(new ShowGame(cellNumberConverter),
                player1,
                player2,
                new Verifier(),
                new DrawVerifier());
    }


    }




