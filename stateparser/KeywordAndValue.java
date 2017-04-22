package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.Keyword;

public class KeywordAndValue {

    private final Keyword keyword;
    private final String value;

    public KeywordAndValue(Keyword keyword, String value) {
        this.keyword = keyword;
        this.value = value;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public String getValue() {
        return value;
    }
}