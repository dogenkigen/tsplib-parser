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

import com.mlaskows.tsplib.stateparser.DataBuffer;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * State of the parser to consume tour data.
 *
 * @author Maciej Laskowski
 */
public class TourDataState implements DataState {

    @Override
    public void consumeLine(ParsingContext context, String line, DataBuffer builder) {
        if (stateChanged(context, line)) {
            return;
        }

        final String[] valuesArray = getValuesArray(line);
        for (String value : valuesArray) {
            final int step = Integer.parseInt(value);
            if (step > 0) {
                builder.addTourStep(step);
            } else {
                builder.finishLastTour();
            }
        }
    }

}
