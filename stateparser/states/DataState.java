package com.mlaskows.tsplib.stateparser.states;

import com.mlaskows.tsplib.stateparser.KeywordAndValue;
import com.mlaskows.tsplib.stateparser.ParsingContext;

/**
 * Created by mlaskows on 21/04/2017.
 */
public interface DataState extends State {

    default boolean stateChanged(ParsingContext context, String line) {
        if (startsWithKeyword(line)) {
            KeywordAndValue keywordAndValue = extractKeywordAndValue(line);
            context.setState(getState(keywordAndValue.getKeyword()));
            return true;
        }
        return false;
    }

    /**
     * Takes as a param {@link String} with not known number of whitespaces
     * and values. Returns array of values represented as {@link String}
     *
     * @param s {@link String} with not known number of whitespaces
     *          and values
     * @return array of values represented as {@link String}
     */
    default String[] getValuesArray(String s) {
        return s.trim().split("\\s+");
    }

}
