/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mlaskows.tsplib.stateparser.states;

import com.mlaskows.tsplib.stateparser.KeywordAndValue;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * Interface for state of the parser to consume data.
 *
 * @author Maciej Laskowski
 */
public interface DataState extends State {

    default boolean stateChanged(ParsingContext context, String line) {
        if (startsWithKeyword(line)) {
            KeywordAndValue keywordAndValue = extractKeywordAndValue(line);
            context.setState(getState(keywordAndValue.getKeyword()));
            return true;
        }
        return false;
    }

    /**
     * Takes as a param {@link String} with not known number of whitespaces
     * and values. Returns array of values represented as {@link String}
     *
     * @param line {@link String} with not known number of whitespaces
     *          and values
     * @return array of values represented as {@link String}
     */
    default String[] getValuesArray(String line) {
        return line.trim().split("\\s+");
    }

}
