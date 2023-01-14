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

import root.model.Cell;
import root.model.GameTable;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class Verifier {
    int count = 0;

    public boolean isUserWin(GameTable gameTable) {
        return varifi(gameTable, 'X');

    }

    public boolean isComputerWin(GameTable gameTable) {
        return varifi(gameTable, 'O');
    }

    public boolean varifi(GameTable gameTable, char ch) {
        count++;
        if (count >= 5) {
            if (gameTable.getSign(new Cell(0, 0)) == ch
                    && gameTable.getSign(new Cell(1, 1)) == ch
                    && gameTable.getSign(new Cell(2, 2)) == ch
                    || gameTable.getSign(new Cell(2, 0)) == ch
                    && gameTable.getSign(new Cell(1, 1)) == ch
                    && gameTable.getSign(new Cell(0, 2)) == ch
            ) {
                return true;
            }
            for (int i = 0; i < 3; i++) {

                if (gameTable.getSign(new Cell(i, 0)) == ch
                        && gameTable.getSign(new Cell(i, 1)) == ch
                        && gameTable.getSign(new Cell(i, 2)) == ch
                        || gameTable.getSign(new Cell(0, i)) == ch
                        && gameTable.getSign(new Cell(1, i)) == ch
                        && gameTable.getSign(new Cell(2, i)) == ch) {
                    return true;
                }

            }
        }
        return false;
    }
}

