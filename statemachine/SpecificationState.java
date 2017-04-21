package com.mlaskows.tsplib.statemachine;

import com.mlaskows.tsplib.EdgeWeightType;
import com.mlaskows.tsplib.TSPLIBItemBuilder;
import com.mlaskows.tsplib.TSPLIBKeyword;
import com.mlaskows.tsplib.TSPLIBType;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class SpecificationState implements State {

    @Override
    public void consumeLine(final TSPLIBParsingContext context,
                            final String line,
                            TSPLIBItemBuilder builder) {

        KeywordAndValue keywordAndValue = extractKeywordAndValue(line);

        if (TSPLIBKeyword.isDataKeyword(keywordAndValue.getKeyword())) {
            context.setState(getState(keywordAndValue.getKeyword()));
            return;
        }

        addToBuilder(keywordAndValue, builder);

    }


    private static void addToBuilder(KeywordAndValue keywordAndValue, TSPLIBItemBuilder builder) {
        switch (keywordAndValue.getKeyword()) {
            case NAME:
                builder.withName(keywordAndValue.getValue());
                break;
            case TYPE:
                builder.withType(TSPLIBType.valueOf(keywordAndValue
                        .getValue()));
                break;
            case COMMENT:
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
            default:
                break;
        }
    }

}
