package com.mlaskows.tsplib.statemachine;

import com.mlaskows.tsplib.TSPLIBItemBuilder;
import com.mlaskows.tsplib.TSPLIBKeyword;

import java.util.stream.Stream;

/**
 * Created by mlaskows on 21/04/2017.
 */
interface State {

    void consumeLine(TSPLIBParsingContext context, String line, TSPLIBItemBuilder builder);

    default KeywordAndValue extractKeywordAndValue(String line) {
        String[] split = line.split(":");
        TSPLIBKeyword keyword = TSPLIBKeyword.valueOf(split[0].trim());
        String value = null;
        if (split.length > 1) {
            value = split[1].trim();
        }
        return new KeywordAndValue(keyword, value);
    }

    default boolean startsWithKeyword(String line) {
        return Stream.of(TSPLIBKeyword.values())
                .anyMatch(v -> line.contains(v.toString()));
    }


    default State getState(TSPLIBKeyword keyword) {
        State newState;
        switch (keyword){
            case NODE_COORD_SECTION:
                newState = new CoordinatesDataState();
                break;
            default:
                newState = null;
                throw new TSPLIBException("Can't determine state based on " +
                        "keyword" + keyword);
        }
        return newState;
    }


}