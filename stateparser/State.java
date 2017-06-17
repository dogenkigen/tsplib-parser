package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.ItemBuilder;
import com.mlaskows.tsplib.Keyword;

import java.util.stream.Stream;

/**
 * Created by mlaskows on 21/04/2017.
 */
interface State {

    void consumeLine(ParsingContext context, String line, ItemBuilder builder);

    default KeywordAndValue extractKeywordAndValue(String line) {
        String[] split = line.split(":");
        Keyword keyword = Keyword.valueOf(split[0].trim());
        String value = null;
        if (split.length > 1) {
            value = split[1].trim();
        }
        return new KeywordAndValue(keyword, value);
    }

    default boolean startsWithKeyword(String line) {
        return Stream.of(Keyword.values())
                .anyMatch(v -> line.contains(v.toString()));
    }


    default State getState(Keyword keyword) {
        State newState;
        switch (keyword){
            case NODE_COORD_SECTION:
                newState = new CoordinatesDataState();
                break;
            case EOF:
                newState = new TerminationState();
                break;
            default:
                throw new TSPLIBException("Can't determine state based on " +
                        "keyword" + keyword);
        }
        return newState;
    }


}