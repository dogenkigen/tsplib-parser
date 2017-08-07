package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.datamodel.TspBuilder;
import com.mlaskows.tsplib.exception.TspLibException;

import java.util.stream.Stream;

/**
 * A state of parser.
 *
 * @author Maciej Laskowski
 */
interface State {

    void consumeLine(ParsingContext context, String line, TspBuilder builder);

    /**
     * Extracts {@link KeywordAndValue} object from a TSPLIB file line.
     *
     * @param line a line from TSPLIB file
     * @return {@link KeywordAndValue} object
     */
    default KeywordAndValue extractKeywordAndValue(String line) {
        String[] split = line.split(":");
        Keyword keyword = Keyword.valueOf(split[0].trim());
        String value = null;
        if (split.length > 1) {
            value = split[1].trim();
        }
        return new KeywordAndValue(keyword, value);
    }

    /**
     * Returns true if a line starts with keyword.
     *
     * @param line line to check
     * @return true if a line starts with keyword
     */
    default boolean startsWithKeyword(String line) {
        return Stream.of(Keyword.values())
                .anyMatch(v -> line.contains(v.toString()));
    }

    /**
     * Returns parser {@link State} for a specified keyword.
     *
     * @param keyword
     * @return parser {@link State} for a specified keyword
     */
    default State getState(Keyword keyword) {
        State newState;
        switch (keyword) {
            case NODE_COORD_SECTION:
                newState = new CoordinatesDataState();
                break;
            case EOF:
                newState = new TerminationState();
                break;
            default:
                throw new TspLibException("Can't determine state based on " +
                        "keyword" + keyword);
        }
        return newState;
    }

}