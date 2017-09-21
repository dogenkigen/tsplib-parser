package com.mlaskows.tsplib.stateparser.states;

import com.mlaskows.tsplib.datamodel.ItemBuilder;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * State of the parser to consume tour data.
 *
 * @author Maciej Laskowski
 */
public class TourDataState implements DataState {

    @Override
    public void consumeLine(ParsingContext context, String line, ItemBuilder builder) {
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
