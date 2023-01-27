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

import root.model.GameTable;
import root.model.Player;

import java.util.Random;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class Game {
    private final ShowGame showGame;
    private final Player player1;
    private final Player player2;
    private final Verifier verefier;
    private final DrawVerifier drawVerifier;

    public Game(ShowGame showGame, Player player1, Player player2, Verifier verefier, DrawVerifier drawVerifier) {
        this.showGame = showGame;
        this.player1 = player1;
        this.player2 = player2;
        this.verefier = verefier;
        this.drawVerifier = drawVerifier;
    }


    public void play() {
        showGame.printTableRuls();
        final GameTable gameTable = new GameTable();

        if (new Random().nextBoolean()) {
            player2.makeStep(gameTable);
            showGame.printTable(gameTable);
        }

            final Player[] players = {player1, player2};
            while (true) {
                for (final Player player : players) {
                    player.makeStep(gameTable);
                    showGame.printTable(gameTable);
                    if (verefier.isWin(gameTable, player)) {
                        System.out.println(player + " WIN");
                        printGameOver();
                        return;
                    }
                    if (drawVerifier.isDraw(gameTable)) {
                        System.out.println("SORRY DRAW");
                        printGameOver();
                        return;
                    }
                }

            }
        }



    private void printGameOver() {
        System.out.println("GAME OVER");
    }
}



