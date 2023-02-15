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

package root.logic.strategy;

import root.logic.ComputerMoveStrategy;
import root.model.game.Cell;
import root.model.game.GameTable;
import root.model.game.Sign;

import java.util.Random;

public class RandomComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(GameTable gameTable, Sign sign) {
        final Cell[] emptyCellArray = new Cell[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell tempCell = new Cell(i, j);
                if (gameTable.isEmpty(tempCell)) {
                    emptyCellArray[count++] = tempCell;
                }

            }

        }
        if (count > 0) {
            final Cell randomCell = emptyCellArray[new Random().nextInt(count)];
            gameTable.setSign(randomCell, sign);
            return true;
        } else throw new IllegalArgumentException("Game table doesn't have any empty cell");

    }
}
