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
public enum Sign {
    X,
    O,
    EMPTY;

    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        } else
            return name();
    }

    public Sign oppositeSign() {
        if (this == X) {
            return O;
        } else if (this == O) {
            return X;
        } else
            throw new IllegalArgumentException("Current Cell is EMPTY. Empty Cell does not have opposite sign");
    }
}
