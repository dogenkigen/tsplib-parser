package com.mlaskows.tsplib.datamodel.types;

public enum EdgeWeightFormat {

    /**
     * Weights are given by function.
     */
    FUNCTION,
    // TODO add comments
    FULL_MATRIX,
    UPPER_ROW,
    LOWER_ROW,
    UPPER_DIAG_ROW,
    LOWER_DIAG_ROW,

}
