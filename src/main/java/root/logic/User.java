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

import java.util.Scanner;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class User implements Move {
    CellNumberConverter cellNumberConverter;

    public User(CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public void step(GameTable gameTable, final Sign sign) {
        System.out.println("Please choose your possion:");
        Scanner scan = new Scanner(System.in);

        while (true) {
            String userStep = scan.nextLine();
            char userChar = userStep.charAt(0);
            if (userChar <= '9' && '0' < userChar) {
                Cell userCell = cellNumberConverter.toCell(userChar);
                if (gameTable.isEmpty(userCell)) {
                    gameTable.setSign(userCell, sign);
                    break;
                }


            }
            System.out.println("You choosed possion is wrong number. Please try again:");


        }

    }

}
