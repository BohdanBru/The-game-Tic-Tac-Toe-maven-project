/*
 * Copyright 2022. Bohdan Brukhovets
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
 */

package root.logic;

import root.model.game.Cell;
import root.model.game.GameTable;
import root.model.game.Player;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class Verifier {
    int count = 0;


    public boolean isWin(GameTable gameTable, Player player) {
        ++count;
        if (count >= 4) {
            if (gameTable.getSign(new Cell(0, 0)) == player.getSign()
                    && gameTable.getSign(new Cell(1, 1)) == player.getSign()
                    && gameTable.getSign(new Cell(2, 2)) == player.getSign()
                    || gameTable.getSign(new Cell(2, 0)) == player.getSign()
                    && gameTable.getSign(new Cell(1, 1)) == player.getSign()
                    && gameTable.getSign(new Cell(0, 2)) == player.getSign()
            ) {
                return true;
            }
            for (int i = 0; i < 3; i++) {

                if (gameTable.getSign(new Cell(i, 0)) == player.getSign()
                        && gameTable.getSign(new Cell(i, 1)) == player.getSign()
                        && gameTable.getSign(new Cell(i, 2)) == player.getSign()
                        || gameTable.getSign(new Cell(0, i)) == player.getSign()
                        && gameTable.getSign(new Cell(1, i)) == player.getSign()
                        && gameTable.getSign(new Cell(2, i)) == player.getSign()) {
                    return true;
                }

            }
        }
        return false;
    }
}

