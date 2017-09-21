package com.mlaskows.tsplib.stateparser.states;

import com.mlaskows.tsplib.datamodel.item.Node;
import com.mlaskows.tsplib.datamodel.ItemBuilder;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * State of the parser to consume coordinates data.
 *
 * @author Maciej Laskowski
 */
public class CoordinatesDataState implements DataState {

    @Override
    public void consumeLine(final ParsingContext context, final String line,
                            ItemBuilder builder) {
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
