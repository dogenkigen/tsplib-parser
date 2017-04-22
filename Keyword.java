package com.mlaskows.tsplib;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by mlaskows on 21/04/2017.
 */
public enum Keyword {

    //Specification part

    NAME,
    TYPE,
    COMMENT,
    DIMENSION,
    CAPACITY,
    EDGE_WEIGHT_TYPE,

    // Data part

    NODE_COORD_SECTION,
    EDGE_DATA_SECTION,
    EDGE_WEIGHT_SECTION;

    private static final Set<Keyword> specificationKeywords = EnumSet.of
            (NAME, TYPE, COMMENT, DIMENSION, CAPACITY, EDGE_WEIGHT_TYPE);

    private static final Set<Keyword> dataKeywords = EnumSet.of
            (NODE_COORD_SECTION, EDGE_DATA_SECTION, EDGE_WEIGHT_SECTION);


    public static boolean isSpecificationKeyword(Keyword keyword) {
        return specificationKeywords.contains(keyword);
    }

    public static boolean isDataKeyword(Keyword keyword) {
        return dataKeywords.contains(keyword);
    }

}
