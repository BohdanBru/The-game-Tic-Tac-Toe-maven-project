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

public class WinNowComputerMoveStrategy implements ComputerMoveStrategy {
    int count = 1;

    @Override
    public boolean tryToMakeMove(GameTable gameTable, Sign sign) {

        if (count++ >= 2) {
            return tryToMoveByCol(gameTable, sign) ||
                    tryToMoveByRow(gameTable, sign) ||
                    tryToMoveByMainDiagonal(gameTable, sign) ||
                    tryToMoveBySecondaryDiagonal(gameTable, sign);
        }
        /*if (count >= 2) {
            if (gameTable.getSign(new Cell(0, 0)) == sign
                    && gameTable.getSign(new Cell(1, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(2, 2))) {
                    gameTable.setSign(new Cell(2, 2), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 2)) == sign
                    && gameTable.getSign(new Cell(1, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(0, 0))) {
                    gameTable.setSign(new Cell(0, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 2)) == sign
                    && gameTable.getSign(new Cell(0, 0)) == sign) {
                if (gameTable.isEmpty(new Cell(1, 1))) {
                    gameTable.setSign(new Cell(1, 1), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 2)) == sign
                    && gameTable.getSign(new Cell(1, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(2, 0))) {
                    gameTable.setSign(new Cell(2, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 0)) == sign
                    && gameTable.getSign(new Cell(1, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(0, 2))) {
                    gameTable.setSign(new Cell(0, 2), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 2)) == sign
                    && gameTable.getSign(new Cell(2, 0)) == sign) {
                if (gameTable.isEmpty(new Cell(1, 1))) {
                    gameTable.setSign(new Cell(1, 1), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 0)) == sign
                    && gameTable.getSign(new Cell(0, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(0, 2))) {
                    gameTable.setSign(new Cell(0, 2), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 0)) == sign
                    && gameTable.getSign(new Cell(0, 2)) == sign) {
                if (gameTable.isEmpty(new Cell(0, 1))) {
                    gameTable.setSign(new Cell(0, 1), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 2)) == sign
                    && gameTable.getSign(new Cell(0, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(0, 0))) {
                    gameTable.setSign(new Cell(0, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(1, 0)) == sign
                    && gameTable.getSign(new Cell(1, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(1, 2))) {
                    gameTable.setSign(new Cell(1, 2), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(1, 0)) == sign
                    && gameTable.getSign(new Cell(1, 2)) == sign) {
                if (gameTable.isEmpty(new Cell(1, 1))) {
                    gameTable.setSign(new Cell(1, 1), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(1, 2)) == sign
                    && gameTable.getSign(new Cell(1, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(1, 0))) {
                    gameTable.setSign(new Cell(1, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 0)) == sign
                    && gameTable.getSign(new Cell(2, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(2, 2))) {
                    gameTable.setSign(new Cell(2, 2), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 0)) == sign
                    && gameTable.getSign(new Cell(2, 2)) == sign) {
                if (gameTable.isEmpty(new Cell(2, 1))) {
                    gameTable.setSign(new Cell(2, 1), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 2)) == sign
                    && gameTable.getSign(new Cell(2, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(2, 0))) {
                    gameTable.setSign(new Cell(2, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 0)) == sign
                    && gameTable.getSign(new Cell(1, 0)) == sign) {
                if (gameTable.isEmpty(new Cell(2, 0))) {
                    gameTable.setSign(new Cell(2, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 0)) == sign
                    && gameTable.getSign(new Cell(2, 0)) == sign) {
                if (gameTable.isEmpty(new Cell(1, 0))) {
                    gameTable.setSign(new Cell(1, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 0)) == sign
                    && gameTable.getSign(new Cell(1, 0)) == sign) {
                if (gameTable.isEmpty(new Cell(0, 0))) {
                    gameTable.setSign(new Cell(0, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 1)) == sign
                    && gameTable.getSign(new Cell(1, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(2, 1))) {
                    gameTable.setSign(new Cell(2, 1), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 1)) == sign
                    && gameTable.getSign(new Cell(2, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(1, 1))) {
                    gameTable.setSign(new Cell(1, 1), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 1)) == sign
                    && gameTable.getSign(new Cell(1, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(0, 1))) {
                    gameTable.setSign(new Cell(0, 1), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 2)) == sign
                    && gameTable.getSign(new Cell(1, 2)) == sign) {
                if (gameTable.isEmpty(new Cell(2, 2))) {
                    gameTable.setSign(new Cell(2, 2), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, 2)) == sign
                    && gameTable.getSign(new Cell(2, 2)) == sign) {
                if (gameTable.isEmpty(new Cell(1, 2))) {
                    gameTable.setSign(new Cell(1, 2), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(2, 2)) == sign
                    && gameTable.getSign(new Cell(1, 2)) == sign) {
                if (gameTable.isEmpty(new Cell(0, 2))) {
                    gameTable.setSign(new Cell(0, 2), sign);
                    return true;
                }
            } else return false;
        }
            return false;

        }*/
        return false;

    }

    private boolean tryToMoveByRow(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMoveUsingLambda(gameTable, sign, i, (k, j) -> new Cell(k, j))) {
                return true;
            }
        }
        return false;



    }

    private boolean tryToMoveByCol(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMoveUsingLambda(gameTable, sign, i, (k, j) -> new Cell(j, k))) {
                return true;
            }
        }
        return false;


    }

    private boolean tryToMoveByMainDiagonal(GameTable gameTable, Sign sign) {

        return tryToMoveUsingLambda(gameTable, sign, -1, (k, j) -> new Cell(j, j));

    }

    private boolean tryToMoveBySecondaryDiagonal(GameTable gameTable, Sign sign) {

        return tryToMoveUsingLambda(gameTable, sign, -1, (k, j) -> new Cell(j, 2 - j));

    }

    private boolean tryToMoveUsingLambda(GameTable gameTable, Sign sign, int i, Lambda lambda) {
        int numberOfSignCell = 0;
        int emptyCell = 0;
        Cell tempCell = null;
        for (int j = 0; j < 3; j++) {
            Cell targetCell = lambda.tryMove(i, j);
            if (gameTable.isEmpty(targetCell)) {
                tempCell = targetCell;
                emptyCell++;
            } else if (gameTable.getSign(targetCell) == sign) {
                numberOfSignCell++;
            } else break;
        }
        if (numberOfSignCell == 2 && emptyCell == 1) {

            gameTable.setSign(tempCell, sign);
            return true;
        }

        return false;


    }

    @FunctionalInterface
    private interface Lambda {
        Cell tryMove(int k, int j);
    }
}
