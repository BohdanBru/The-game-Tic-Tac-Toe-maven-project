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

import java.util.Random;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class Computer {
    public void step(GameTable gameTable) {
        while (true) {
            int row = new Random().nextInt(3);
            int col = new Random().nextInt(3);
            Cell cell = new Cell(row, col);
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(new Cell(row, col), 'O');
                break;
            }
        }
    }
}
