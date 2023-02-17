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

package root.logic.config;

import root.model.config.LevelOfDifficult;
import root.model.config.PlayerType;
import root.model.config.UserInterface;

import static root.model.config.LevelOfDifficult.*;
import static root.model.config.PlayerType.COMPUTER;
import static root.model.config.PlayerType.USER;
import static root.model.config.UserInterface.CONSOLE;
import static root.model.config.UserInterface.GUI;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class CommandLineArgumentParser {
    private final String[] args;

    public CommandLineArgumentParser(String[] args) {
        this.args = args;
    }

    public CommandLineArguments parser() {
        PlayerType player1Type = null;
        PlayerType player2Type = null;
        UserInterface userInterface = null;
        LevelOfDifficult level = THIRD;
        for (final String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(arg.toUpperCase());
                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsuported command line argument: '" + arg + "'");
                }
            } else if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                if (userInterface == null) {
                    userInterface = UserInterface.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsuported command line argument: '" + arg + "'");
                }
            } else if (FIRST.name().equalsIgnoreCase(arg) ||
                    SECOND.name().equalsIgnoreCase(arg) ||
                    THIRD.name().equalsIgnoreCase(arg)) {
                level = LevelOfDifficult.valueOf(arg.toUpperCase());

            } else if ("1".equals(arg)) {
                level = FIRST;
            } else if ("2".equals(arg)) {
                level = SECOND;
            } else if ("3".equals(arg)) {
                level = THIRD;
            } else {
                System.err.println("Unsuported command line argument: '" + arg + "'");
            }
        }
        if (userInterface == null) {
            userInterface = CONSOLE;
        }
        if (player1Type == null) {
            return new CommandLineArguments(USER, COMPUTER, userInterface, level);
        } else if (player2Type == null) {
            return new CommandLineArguments(USER, player1Type, userInterface, level);
        } else {
            return new CommandLineArguments(player1Type, player2Type, userInterface, level);
        }
    }


    public static class CommandLineArguments {
        private final PlayerType player1Type;

        private final PlayerType player2Type;
        private final UserInterface userInterface;
        private final LevelOfDifficult level;

        private CommandLineArguments(PlayerType player1Type,
                                     PlayerType player2Type,
                                     UserInterface userInterface,
                                     LevelOfDifficult level) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
            this.userInterface = userInterface;
            this.level = level;

        }

        public LevelOfDifficult getLevel() {
            return level;
        }

        public PlayerType getPlayer1Type() {
            return player1Type;
        }

        public PlayerType getPlayer2Type() {
            return player2Type;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }

    }
}
