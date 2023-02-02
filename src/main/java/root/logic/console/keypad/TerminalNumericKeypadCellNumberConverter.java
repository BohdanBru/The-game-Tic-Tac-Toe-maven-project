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

package root.logic.console.keypad;

import root.logic.console.CellNumberConverter;
import root.model.game.Cell;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {
    private final char[][] mapping = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    @Override
    public Cell toCell(char number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mapping[i][j] == number) {
                    return new Cell(i, j);
                }

            }

        }
        return null;
    }

    @Override
    public char toNumber(Cell cell) {
        return mapping[cell.getRow()][cell.getCol()];
    }
}
