package com.mlaskows.tsplib.stateparser;

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
     * and 3 values. Returns array of 3 values represented as {@link String}
     *
     * @param s {@link String} with not known number of whitespaces
     *          and 3 values
     * @return array of 3 values represented as {@link String}
     */
    default  String[] getValuesArray(String s) {
        return s.trim().split("\\s+");
    }

}
