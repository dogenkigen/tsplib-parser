package com.mlaskows.tsplib.statemachine;

import com.mlaskows.tsplib.Node;
import com.mlaskows.tsplib.TSPLIBItemBuilder;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class CoordinatesDataState implements DataState {

    @Override
    public void consumeLine(final TSPLIBParsingContext context,
                            final String line,
                            TSPLIBItemBuilder builder) {
        if (stateChanged(context, line)) {
            return;
        }
        Node node = mapToNode(getSplitted(line));
        builder.addNode(node);
    }

    private Node mapToNode(String[] values) {
        return new Node(Integer.valueOf(values[0]), Double.valueOf(values[1]),
                Double.valueOf(values[2]));
    }
}
