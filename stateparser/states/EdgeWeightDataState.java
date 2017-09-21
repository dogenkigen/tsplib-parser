package com.mlaskows.tsplib.stateparser.states;

import com.mlaskows.tsplib.datamodel.ItemBuilder;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * State of the parser to consume edge weight data.
 *
 * @author Maciej Laskowski
 */
public class EdgeWeightDataState implements DataState {

    @Override
    public void consumeLine(ParsingContext context, String line, ItemBuilder builder) {
        if (stateChanged(context, line)) {
            return;
        }
        final String[] valuesArray = getValuesArray(line);
        builder.addEdgeWeightData(convertToInt(valuesArray));
    }

    private int[] convertToInt(String[] valuesArray) {
        final int[] result = new int[valuesArray.length];
        for (int i = 0; i < valuesArray.length; i++) {
            result[i] = Integer.parseInt(valuesArray[i]);
        }
        return result;
    }

}
