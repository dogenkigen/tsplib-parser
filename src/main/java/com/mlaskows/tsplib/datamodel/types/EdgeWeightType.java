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

/**
 * This class contains all types of edge weights or distances.
 *
 * @author Maciej Laskowski
 */
public enum EdgeWeightType {

    /**
     * Weights are listed explicitly in the corresponding section.
     */
    EXPLICIT,

    /**
     * Weights are Euclidean distances in 2-D.
     */
    EUC_2D,

    /**
     * Weights are maximum distances in 2-D.
     */
    MAX_2D,

    /**
     * Weights are Manhattan distances in 2-D.
     */
    MAN_2D,

    /**
     * Weights are Euclidean distances in 2-D rounded up.
     */
    CEIL_2D,

    /**
     * Weights are geographical distances.
     */
    GEO,

    /**
     * Special distance function for problems att48 and att532.
     */
    ATT;

}
