package com.mlaskows.tsplib.stateparser.states;

import com.mlaskows.tsplib.datamodel.Node;
import com.mlaskows.tsplib.datamodel.TspBuilder;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class CoordinatesDataState implements DataState {

    @Override
    public void consumeLine(final ParsingContext context, final String line,
                            TspBuilder builder) {
        if (stateChanged(context, line)) {
            return;
        }
        Node node = mapToNode(getValuesArray(line));
        builder.addNode(node);
    }

    private Node mapToNode(String[] values) {
        return new Node(Integer.parseInt(values[0]), Double.parseDouble(values[1]),
                Double.parseDouble(values[2]));
    }
}
