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

package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.stateparser.states.SpecificationState;
import com.mlaskows.tsplib.stateparser.states.State;

/**
 * A context of the parser.
 *
 * @author Maciej Laskowski
 */
public class ParsingContext {
    private State state;
    public ParsingContext() {
        setState(new SpecificationState());
    }

    /**
     * Setter method for the state.
     * Normally only called by classes implementing the State interface.
     *
     * @param newState the new state of this context
     */
    public void setState(final State newState) {
        state = newState;
    }

    /**
     * Consumes line by passing it's value to the actual state.
     *
     * @param line a line to be consumed
     * @param builder
     */
    public void consumeLine(final String line, DataBuffer builder) {
        state.consumeLine(this, line, builder);
    }
}
