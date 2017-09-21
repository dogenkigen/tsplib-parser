/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
