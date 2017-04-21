package com.mlaskows.tsplib.statemachine;

/**
 * Created by mlaskows on 21/04/2017.
 */
public interface DataState extends State {

    default boolean stateChanged(TSPLIBParsingContext context, String line) {
        if (startsWithKeyword(line)) {
            KeywordAndValue keywordAndValue = extractKeywordAndValue(line);
            context.setState(getState(keywordAndValue.getKeyword()));
            return true;
        }
        return false;
    }

    default String[] getSplitted(String s) {
        return s.trim().split("\\s+");
    }

}
