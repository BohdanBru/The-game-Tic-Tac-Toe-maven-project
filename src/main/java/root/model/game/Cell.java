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

package root.model.game;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class Cell {
    private final int row;
    private final int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /*public Cell(int i) {
        switch (i) {
            case 1 -> {
                row = 0;
                col = 2;
            }
            case 2 -> {
                row = 1;
                col = 2;
            }
            case 3 -> {
                row = 2;
                col = 2;
            }
            case 4 -> {
                row = 0;
                col = 1;
            }
            case 5 -> {
                row = 1;
                col = 1;
            }
            case 6 -> {
                row = 2;
                col = 1;
            }
            case 7 -> {
                row = 0;
                col = 0;
            }
            case 8 -> {
                row = 1;
                col = 0;
            }
            case 9 -> {
                row = 2;
                col = 0;
            }
        }
    }*/


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", cal=" + col +
                '}';
    }
}
