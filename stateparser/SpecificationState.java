package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.datamodel.TspBuilder;
import com.mlaskows.tsplib.types.DisplayDataType;
import com.mlaskows.tsplib.types.EdgeWeightType;
import com.mlaskows.tsplib.types.Type;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class SpecificationState implements State {

    @Override
    public void consumeLine(final ParsingContext context,
                            final String line,
                            TspBuilder builder) {

        KeywordAndValue keywordAndValue = extractKeywordAndValue(line);

        if (Keyword.isDataKeyword(keywordAndValue.getKeyword())) {
            context.setState(getState(keywordAndValue.getKeyword()));
            return;
        }

        addToBuilder(keywordAndValue, builder);

    }


    private static void addToBuilder(KeywordAndValue keywordAndValue, TspBuilder builder) {
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
                builder.withDimension(Integer.valueOf(keywordAndValue
                        .getValue()));
                break;
            case CAPACITY:
                builder.withCapacity(Integer.valueOf(keywordAndValue
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
            default:
                break;
        }
    }

}
