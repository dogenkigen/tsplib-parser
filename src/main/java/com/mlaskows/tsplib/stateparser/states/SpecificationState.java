package com.mlaskows.tsplib.stateparser.states;

import com.mlaskows.tsplib.datamodel.ItemBuilder;
import com.mlaskows.tsplib.datamodel.types.*;
import com.mlaskows.tsplib.stateparser.Keyword;
import com.mlaskows.tsplib.stateparser.KeywordAndValue;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * State of the parser to consume specification of TSPLIB file.
 *
 * @author Maciej Laskowski
 */
public class SpecificationState implements State {

    @Override
    public void consumeLine(final ParsingContext context,
                            final String line,
                            ItemBuilder builder) {

        KeywordAndValue keywordAndValue = extractKeywordAndValue(line);

        if (Keyword.isDataKeyword(keywordAndValue.getKeyword())) {
            context.setState(getState(keywordAndValue.getKeyword()));
            return;
        }

        addToBuilder(keywordAndValue, builder);

    }

    private static void addToBuilder(KeywordAndValue keywordAndValue, ItemBuilder builder) {
        switch (keywordAndValue.getKeyword()) {
            case NAME:
                builder.withName(keywordAndValue.getValue());
                break;
            case TYPE:
                builder.withType(Type.valueOf(keywordAndValue
                        .getValue()));
                break;
            case COMMENT:
                builder.withComment(keywordAndValue.getValue());
                break;
            case DIMENSION:
                builder.withDimension(Integer.parseInt(keywordAndValue
                        .getValue()));
                break;
            case EDGE_WEIGHT_TYPE:
                builder.withEdgeWeightType(EdgeWeightType
                        .valueOf(keywordAndValue.getValue()));
                break;
            case DISPLAY_DATA_TYPE:
                builder.withDisplayDataType(DisplayDataType.valueOf
                        (keywordAndValue.getValue()));
                break;
            case EDGE_WEIGHT_FORMAT:
                builder.withEdgeWeightFormat(EdgeWeightFormat.valueOf
                        (keywordAndValue.getValue()));
                break;
            case NODE_COORD_TYPE:
                builder.withNodeCoordType(NodeCoordType.valueOf
                        (keywordAndValue.getValue()));
                break;
            default:
                break;
        }
    }

}
