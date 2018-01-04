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
import com.mlaskows.tsplib.datamodel.tsp.Tsp;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * State of the parser to consume coordinates data.
 *
 * @author Maciej Laskowski
 */
public class CoordinatesDataState implements DataState {

    @Override
    public void consumeLine(final ParsingContext context, final String line,
                            DataBuffer builder) {
        if (stateChanged(context, line)) {
            return;
        }
        Tsp.Node node = mapToNode(getValuesArray(line));
        builder.addNode(node);
    }

    private Tsp.Node mapToNode(String[] values) {
        return new Tsp.Node(Integer.parseInt(values[0]), Double.parseDouble(values[1]),
                Double.parseDouble(values[2]));
    }

}
