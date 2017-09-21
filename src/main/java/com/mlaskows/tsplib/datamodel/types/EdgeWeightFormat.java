package com.mlaskows.tsplib.datamodel.types;

import java.util.EnumSet;
import java.util.Set;

/**
 * Describes the format of the edge weights if they are given explicitly.
 *
 * @author Maciej Laskowski
 */
public enum EdgeWeightFormat {

    /**
     * Weights are given by function.
     */
    FUNCTION,

    /**
     * Weights are given by full matrix.
     */
    FULL_MATRIX,

    /**
     * Upper triangular matrix (row-wise without diagonal entries).
     */
    UPPER_ROW,

    /**
     * Lower triangular matrix (row-wise without diagonal entries).
     */
    LOWER_ROW,

    /**
     * Upper triangular matrix (row-wise including diagonal entries).
     */
    UPPER_DIAG_ROW,

    /**
     * Lower triangular matrix (row-wise including diagonal entries).
     */
    LOWER_DIAG_ROW;

    /**
     * Returns true if {@code EdgeWeightFormat} describes triangular matrix.
     *
     * @param edgeWeightFormat given format
     * @return true if {@code EdgeWeightFormat} describes triangular matrix
     */
    public static boolean isTriangular(EdgeWeightFormat edgeWeightFormat) {
        return TRIANGULAR_SET.contains(edgeWeightFormat);
    }

    private static final Set<EdgeWeightFormat> TRIANGULAR_SET =
            EnumSet.of(UPPER_DIAG_ROW, LOWER_DIAG_ROW, UPPER_ROW, LOWER_ROW);
}
