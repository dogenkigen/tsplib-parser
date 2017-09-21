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
 * Specifies whether coordinates are associated with each node (which,
 * for example may be used for either graphical display or distance
 * computations).
 *
 * @author Maciej Laskowski
 */
public enum NodeCoordType {

    /**
     * Nodes are specified by coordinates in 2-D.
     */
    TWOD_COORDS,

    /**
     * Nodes are specified by coordinates in 3-D.
     */
    THREED_COORDS,

    /**
     * The nodes do not have associated coordinates.
     */
    NO_COORDS;
}
