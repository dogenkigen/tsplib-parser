package com.mlaskows.tsplib.statemachine;

import com.mlaskows.tsplib.TSPLIBKeyword;

public class KeywordAndValue {

    private final TSPLIBKeyword keyword;
    private final String value;

    public KeywordAndValue(TSPLIBKeyword keyword, String value) {
        this.keyword = keyword;
        this.value = value;
    }

    public TSPLIBKeyword getKeyword() {
        return keyword;
    }

    public String getValue() {
        return value;
    }
}