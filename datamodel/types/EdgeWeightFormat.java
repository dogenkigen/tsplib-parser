package com.mlaskows.tsplib.datamodel.types;

import java.util.EnumSet;
import java.util.Set;

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
    LOWER_DIAG_ROW;

    public static boolean isTriangular(EdgeWeightFormat edgeWeightFormat) {
        return TRIANGULAR_SET.contains(edgeWeightFormat);
    }

    private static final Set<EdgeWeightFormat> TRIANGULAR_SET =
            EnumSet.of(UPPER_DIAG_ROW, LOWER_DIAG_ROW, UPPER_ROW, LOWER_ROW);
}
