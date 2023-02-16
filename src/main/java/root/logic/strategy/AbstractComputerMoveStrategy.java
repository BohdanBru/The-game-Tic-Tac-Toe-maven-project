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

public abstract class AbstractComputerMoveStrategy implements ComputerMoveStrategy {
    int count = 1;
    private final int expectedCountEmptyCell;
    int countEmptyCell = 0;
    Cell[] emptyCellArray = new Cell[7];
    boolean emptyIs = false;


    protected AbstractComputerMoveStrategy(int expectedCountEmptyCell) {
        this.expectedCountEmptyCell = expectedCountEmptyCell;
    }

    @Override
    public final boolean tryToMakeMove(GameTable gameTable, Sign signMove) {
        final Sign findSing = getFindSing(signMove);
        BestCell bestCell = new BestCell();
        findBestCellForMoveByCol(gameTable, findSing, bestCell);
        findBestCellForMoveByRow(gameTable, findSing, bestCell);
        findBestCellForMoveByMainDiagonal(gameTable, findSing, bestCell);
        findBestCellForMoveBySecondaryDiagonal(gameTable, findSing, bestCell);
        if (bestCell.count > 0) {
            final Cell cell = bestCell.emptyCells[new Random().nextInt(bestCell.count)];

            gameTable.setSign(cell, signMove);
            return true;
        } else {
            return false;
        }
       /* if (count++ >= 2) {

         }*/
    }

    private void findBestCellForMoveBySecondaryDiagonal(GameTable gameTable, Sign findSing, BestCell bestCell) {
        for (int i = 0; i < 3; i++) {
            findBestCellForMoveUsingLambda(gameTable, findSing, bestCell, i, (k, j) -> new Cell(k, j));
        }
    }

    private void findBestCellForMoveByMainDiagonal(GameTable gameTable, Sign findSing, BestCell bestCell) {
        for (int i = 0; i < 3; i++) {
            findBestCellForMoveUsingLambda(gameTable, findSing, bestCell, i, (k, j) -> new Cell(j, k));
        }
    }

    private void findBestCellForMoveByRow(GameTable gameTable, Sign findSing, BestCell bestCell) {
        findBestCellForMoveUsingLambda(gameTable, findSing, bestCell, -1, (k, j) -> new Cell(j, j));
    }

    protected void findBestCellForMoveByCol(GameTable gameTable, Sign findSing, BestCell bestCell) {
        findBestCellForMoveUsingLambda(gameTable, findSing, bestCell, -1, (k, j) -> new Cell(j, 2 - j));
    }

    protected abstract Sign getFindSing(Sign moveSing);


    /*private void tryToMoveByRow(GameTable gameTable, final Sign findSing, Sign signMove) {
        for (int i = 0; i < 3; i++) {
            findBestCellForMoveUsingLambda(gameTable, findSing, signMove, i, (k, j) -> new Cell(k, j));

            }



    }

    private void tryToMoveByCol(GameTable gameTable, final Sign findSing, Sign signMove) {
        for (int i = 0; i < 3; i++) {
            findBestCellForMoveUsingLambda(gameTable, findSing, signMove, i, (k, j) -> new Cell(j, k));


        }



    }

    private void tryToMoveByMainDiagonal(GameTable gameTable, final Sign findSing, Sign signMove) {

        findBestCellForMoveUsingLambda(gameTable, findSing, signMove, -1, (k, j) -> new Cell(j, j));

    }

    private void tryToMoveBySecondaryDiagonal(GameTable gameTable, final Sign findSing, Sign signMove) {

        findBestCellForMoveUsingLambda(gameTable, findSing, signMove, -1, (k, j) -> new Cell(j, 2 - j));

    }

    /*private void tryToMoveUsingLambda(GameTable gameTable, final Sign findSing, Sign signMove, int i, Lambda lambda) {
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

            emptyCellArray[countEmptyCell++] =tempCell;
            emptyIs = true;
            //gameTable.setSign(tempCell, signMove);

        }




    }*/
    private void findBestCellForMoveUsingLambda(GameTable gameTable, final Sign findSing, final BestCell bestCell, int i, Lambda lambda) {
        int numberOfSignCell = 0;
        int emptyCell = 0;
        Cell[] localEmptyCells = new Cell[3];
        int count = 0;
        for (int j = 0; j < 3; j++) {
            Cell targetCell = lambda.tryMove(i, j);
            if (gameTable.isEmpty(targetCell)) {
                localEmptyCells[count++] = targetCell;
                emptyCell++;
            } else if (gameTable.getSign(targetCell) == findSing) {
                numberOfSignCell++;
            } else break;
        }
        if (numberOfSignCell == expectedCountEmptyCell && emptyCell == 3 - expectedCountEmptyCell) {
            for (int j = 0; j < count; j++) {
                bestCell.add(localEmptyCells[j]);
            }
        }
    }

    @FunctionalInterface
    private interface Lambda {
        Cell tryMove(int k, int j);
    }

    private static class BestCell {
        private final Cell[] emptyCells = new Cell[9];
        private int count;

        private void add(final Cell cell) {
            emptyCells[count++] = cell;

        }
    }
}
