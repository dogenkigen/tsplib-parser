package com.mlaskows.tsplib.stateparser.states;

import com.mlaskows.tsplib.datamodel.TspBuilder;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * A state which terminates parsing. Parser will get to this state when EOF
 * keyword occurs.
 *
 * @author Maciej Laskowski
 */
public class TerminationState implements State {

    @Override
    public void consumeLine(ParsingContext context, String line, TspBuilder builder) {
        return;
    }
}
