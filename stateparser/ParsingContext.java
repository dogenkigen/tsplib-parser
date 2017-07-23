package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.datamodel.TspBuilder;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class ParsingContext {
    private State state;
    public ParsingContext() {
        setState(new SpecificationState());
    }

    /**
     * Setter method for the state.
     * Normally only called by classes implementing the State interface.
     * @param newState the new state of this context
     */
    void setState(final State newState) {
        state = newState;
    }

    public void consumeLine(final String line, TspBuilder builder) {
        state.consumeLine(this, line, builder);
    }
}
