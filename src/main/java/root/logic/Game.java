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

import root.model.game.GameTable;
import root.model.game.Player;

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
    private final GameOverHandler gameOverHandler;

    public Game(ShowGame showGame, Player player1, Player player2, Verifier verefier, DrawVerifier drawVerifier, GameOverHandler gameOverHandler) {
        this.showGame = showGame;
        this.player1 = player1;
        this.player2 = player2;
        this.verefier = verefier;
        this.drawVerifier = drawVerifier;
        this.gameOverHandler = gameOverHandler;
    }


    public void play() {
        showGame.printTableRules();
        final GameTable gameTable = new GameTable();

        if (new Random().nextBoolean()) {
            player2.makeStep(gameTable);
            showGame.printTable(gameTable);
            DrawVerifier.count++;
        }

            final Player[] players = {player1, player2};
            while (true) {
                for (final Player player : players) {
                    player.makeStep(gameTable);
                    showGame.printTable(gameTable);
                    if (verefier.isWin(gameTable, player)) {
                        showGame.printInfoMessage(player + " WIN");
                        gameOverHandler.gameOver();
                        return;
                    }
                    if (drawVerifier.isDraw(gameTable)) {
                        showGame.printInfoMessage("SORRY DRAW");
                        gameOverHandler.gameOver();
                        return;
                    }
                }

            }
        }


}



