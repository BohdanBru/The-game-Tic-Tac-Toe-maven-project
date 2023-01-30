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

package root.logic.console;

import root.logic.CellNumberConverter;
import root.model.Cell;

import java.util.Scanner;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class UserInputReader implements root.logic.UserInputReader {
    private final CellNumberConverter cellNumberConverter;
    private final ShowGame showGame;

    public UserInputReader(CellNumberConverter cellNumberConverter, ShowGame showGame) {
        this.cellNumberConverter = cellNumberConverter;
        this.showGame = showGame;
    }

    @Override
    public Cell getUserInput() {
        while (true) {
            //System.out.println("Please type number between 1 and 9 :");
            showGame.printInfoMassage("Please type number between 1 and 9 :");
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                final char ch = userInput.charAt(0);
                if (ch <= '9' && '0' < ch) {
                    return cellNumberConverter.toCell(ch);
                }
            }

            System.out.println("You choosed possion is wrong number. Please try again:");


        }
    }
}
