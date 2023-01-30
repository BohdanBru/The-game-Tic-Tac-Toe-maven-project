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
import root.model.Sign;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class User implements Move {
    private final UserInputReader userInputReader;
    private final ShowGame showGame;

    public User(UserInputReader userInputReader, ShowGame showGame) {
        this.userInputReader = userInputReader;
        this.showGame = showGame;
    }

    @Override
    public void step(final GameTable gameTable, final Sign sign) {
        showGame.printInfoMassage("Please choose your possion:");


        while (true) {
            Cell userCell = userInputReader.getUserInput();
            if (gameTable.isEmpty(userCell)) {
                gameTable.setSign(userCell, sign);
                return;
            } else {
                showGame.printErrorMassage("You choosed possion has wrong number. Please try again:");
            }


        }

    }

}
