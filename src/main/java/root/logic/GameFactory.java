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

import root.logic.keypad.DesktopNumericKeypadCellNumberConverter;
import root.model.PlayWithWhom;
import root.model.Player;
import root.model.PlayerType;

import java.util.Objects;

import static root.model.PlayWithWhom.*;
import static root.model.PlayerType.COMPUTER;
import static root.model.PlayerType.USER;
import static root.model.Sign.O;
import static root.model.Sign.X;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class GameFactory {
    private final PlayerType player1Type = USER;

    private final PlayerType player2Type = COMPUTER;
    PlayWithWhom playWithWhom;

    public GameFactory(final String[] args) {

        String[] array = new String[2];
        int count = 0;
        for (String str : args) {
            array[count++] = str;
        }
        if (Objects.equals(array[0], "USER") && Objects.equals(array[1], "USER")) {
            playWithWhom = PlayerWithPlayer;
        } else if (Objects.equals(array[0], "USER") && Objects.equals(array[1], "COMPUTER")) {
            playWithWhom = PlayerWithComputer;
        } else if (Objects.equals(array[0], "COMPUTER") && Objects.equals(array[1], "COMPUTER")) {
            playWithWhom = ComputerWithComputer;

        } else playWithWhom = PlayerWithComputer;/*{
            System.out.println("Hapened some erro");
        System.exit(1);}*/

    }


    public Game create() {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        if (playWithWhom == PlayerWithPlayer) {
            return new Game(new ShowGame(cellNumberConverter),
                    new Player(O, new User(cellNumberConverter)),
                    new Player(X, new User(cellNumberConverter)),
                    new Verifier(),
                    new DrawVerifier());
        } else if (playWithWhom == PlayerWithComputer) {
            return new Game(new ShowGame(cellNumberConverter),
                    new Player(O, new Computer()),
                    new Player(X, new User(cellNumberConverter)),
                    new Verifier(),
                    new DrawVerifier());
        } else {
            return new Game(new ShowGame(cellNumberConverter),
                    new Player(O, new Computer()),
                    new Player(X, new Computer()),
                    new Verifier(),
                    new DrawVerifier());
        }


    }

}


