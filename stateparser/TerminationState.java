package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.datamodel.TspBuilder;

/**
 * Created by mlaskows on 17/06/2017.
 */
public class TerminationState implements State {

    @Override
    public void consumeLine(ParsingContext context, String line, TspBuilder builder) {
        return;
    }
}
