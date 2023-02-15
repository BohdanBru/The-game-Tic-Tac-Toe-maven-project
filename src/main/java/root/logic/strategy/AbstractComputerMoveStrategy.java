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

public abstract class AbstractComputerMoveStrategy implements ComputerMoveStrategy {
    int count = 1;
    private final int expectedCountEmptyCell;

    protected AbstractComputerMoveStrategy(int expectedCpuntEmptyCell) {
        this.expectedCountEmptyCell = expectedCpuntEmptyCell;
    }

    @Override
    public final boolean tryToMakeMove(GameTable gameTable, Sign signMove) {
        final Sign findSing = getFindSing(signMove);
        //if (count++ >= 2) {
        return tryToMoveByCol(gameTable, findSing, signMove) ||
                tryToMoveByRow(gameTable, findSing, signMove) ||
                tryToMoveByMainDiagonal(gameTable, findSing, signMove) ||
                tryToMoveBySecondaryDiagonal(gameTable, findSing, signMove);
        // }

        //return false;

    }

    protected abstract Sign getFindSing(Sign moveSing);


    private boolean tryToMoveByRow(GameTable gameTable, final Sign findSing, Sign signMove) {
        for (int i = 0; i < 3; i++) {
            if (tryToMoveUsingLambda(gameTable, findSing, signMove, i, (k, j) -> new Cell(k, j))) {
                return true;
            }
        }
        return false;


    }

    private boolean tryToMoveByCol(GameTable gameTable, final Sign findSing, Sign signMove) {
        for (int i = 0; i < 3; i++) {
            if (tryToMoveUsingLambda(gameTable, findSing, signMove, i, (k, j) -> new Cell(j, k))) {
                return true;
            }
        }
        return false;


    }

    private boolean tryToMoveByMainDiagonal(GameTable gameTable, final Sign findSing, Sign signMove) {

        return tryToMoveUsingLambda(gameTable, findSing, signMove, -1, (k, j) -> new Cell(j, j));

    }

    private boolean tryToMoveBySecondaryDiagonal(GameTable gameTable, final Sign findSing, Sign signMove) {

        return tryToMoveUsingLambda(gameTable, findSing, signMove, -1, (k, j) -> new Cell(j, 2 - j));

    }

    private boolean tryToMoveUsingLambda(GameTable gameTable, final Sign findSing, Sign signMove, int i, Lambda lambda) {
        int numberOfSignCell = 0;
        int emptyCell = 0;
        Cell tempCell = null;
        for (int j = 0; j < 3; j++) {
            Cell targetCell = lambda.tryMove(i, j);
            if (gameTable.isEmpty(targetCell)) {
                tempCell = targetCell;
                emptyCell++;
            } else if (gameTable.getSign(targetCell) == findSing) {
                numberOfSignCell++;
            } else break;
        }
        if (tempCell != null && numberOfSignCell == expectedCountEmptyCell && emptyCell == 3 - expectedCountEmptyCell) {

            gameTable.setSign(tempCell, signMove);
            return true;
        }

        return false;


    }


    @FunctionalInterface
    private interface Lambda {
        Cell tryMove(int k, int j);
    }
}
