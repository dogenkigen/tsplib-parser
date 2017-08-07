package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.datamodel.TspBuilder;

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
    void setState(final State newState) {
        state = newState;
    }

    /**
     * Consumes line by passing it's value to the actual state.
     *
     * @param line a line to be consumed
     * @param builder
     */
    public void consumeLine(final String line, TspBuilder builder) {
        state.consumeLine(this, line, builder);
    }
}
