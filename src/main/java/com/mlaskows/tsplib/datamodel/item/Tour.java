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

package com.mlaskows.tsplib.datamodel.item;

import com.mlaskows.tsplib.datamodel.types.Type;

import java.util.List;

/**
 * Representation of TSPLIB tour file.
 *
 * @author Maciej Laskowski
 */
public class Tour {

    private final String name;
    private final Type type;
    private final int dimension;
    private final String comment;
    private final List<int[]> tours;

    public Tour(String name, Type type, int dimension, String comment,
                List<int[]> tours) {
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.comment = comment;
        this.tours = tours;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getDimension() {
        return dimension;
    }

    public String getComment() {
        return comment;
    }

    public List<int[]> getTour() {
        return tours;
    }
}
