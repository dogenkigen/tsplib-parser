package com.mlaskows.tsplib.statemachine;

import com.mlaskows.tsplib.TSPLIBItemBuilder;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class TSPLIBParsingContext {
    private State state;
    public TSPLIBParsingContext() {
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

    public void consumeLine(final String line, TSPLIBItemBuilder builder) {
        state.consumeLine(this, line, builder);
    }
}
