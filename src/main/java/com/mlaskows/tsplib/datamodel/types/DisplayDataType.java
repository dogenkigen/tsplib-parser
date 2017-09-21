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
 * Specifies how graphical display of nodes can be obtained.
 *
 * @author Maciej Laskowski
 */
public enum DisplayDataType {

    /**
     * Display is generated for node coordinates. Default value if node
     * coordinates are specified and {@code NO_DISPLAY} otherwise.
     */
    COORD_DISPLAY,

    /**
     * Explicit coordinates in 2-D are given.
     */
    TWOD_DISPLAY,

    /**
     * No graphical display is possible.
     */
    NO_DISPLAY;
}
