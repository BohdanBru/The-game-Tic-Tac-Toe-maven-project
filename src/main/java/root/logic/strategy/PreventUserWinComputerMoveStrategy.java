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

public class PreventUserWinComputerMoveStrategy implements ComputerMoveStrategy {
    @Override
    public boolean tryToMakeMove(GameTable gameTable, Sign sign) {
        return tryToMakeMoveRow(gameTable, sign) ||
                tryToMakeMoveCol(gameTable, sign) ||
                tryToMakeMoveMainDiagonal(gameTable, sign) ||
                tryToMakeMoveSecondaryDiagonal(gameTable, sign);


    }

    public boolean tryToMakeMoveRow(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            tryMoveByLambda(gameTable, sign, i, (k, j) -> new Cell(k, j));

        }
        return false;
    }

    public boolean tryToMakeMoveCol(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            tryMoveByLambda(gameTable, sign, i, (k, j) -> new Cell(j, k));

        }
        return false;
    }

    public boolean tryToMakeMoveMainDiagonal(GameTable gameTable, Sign sign) {
        return tryMoveByLambda(gameTable, sign, -1, (k, j) -> new Cell(j, j));

    }

    public boolean tryToMakeMoveSecondaryDiagonal(GameTable gameTable, Sign sign) {
        return tryMoveByLambda(gameTable, sign, -1, (k, j) -> new Cell(j, 2 - j));

    }

    private boolean tryMoveByLambda(GameTable gameTable, Sign sign, int i, Lambda lambda) {
        int emptyCell = 0;
        int countOppositeSine = 0;
        Cell tempCall = null;
        for (int j = 0; j < 3; j++) {
            Cell targetCell = lambda.tryMove(i, j);
            if (gameTable.isEmpty(targetCell)) {
                emptyCell++;
                tempCall = targetCell;
            } else if (gameTable.getSign(targetCell) != sign) {
                countOppositeSine++;
            } else break;

        }
        if (emptyCell == 1 && countOppositeSine == 2) {
            gameTable.setSign(tempCall, sign);
            return true;
        }

        return false;
    }

    @FunctionalInterface
    private interface Lambda {
        Cell tryMove(int i, int j);

    }
}
