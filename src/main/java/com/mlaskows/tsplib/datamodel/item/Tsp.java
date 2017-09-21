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

import com.mlaskows.tsplib.datamodel.types.*;

import java.util.List;
import java.util.Optional;

/**
 * Representation of TSPLIB tsp file.
 *
 * @author Maciej Laskowski
 */
public final class Tsp {

    private final String name;
    private final Type type;
    private final EdgeWeightType edgeWeightType;
    private final EdgeWeightFormat edgeWeightFormat;
    private final int dimension;
    private final String comment;
    private final DisplayDataType displayDataType;
    private final NodeCoordType nodeCoordType;
    private final Optional<List<Node>> nodes;
    private final Optional<int[][]> edgeWeightData;

    public Tsp(String name, Type type, EdgeWeightType edgeWeightType,
               EdgeWeightFormat edgeWeightFormat, int dimension, String comment,
               DisplayDataType displayDataType, NodeCoordType nodeCoordType,
               List<Node> nodes, int[][] edgeWeightData) {
        this.name = name;
        this.type = type;
        this.edgeWeightType = edgeWeightType;
        this.edgeWeightFormat = edgeWeightFormat;
        this.dimension = dimension;
        this.comment = comment;
        this.nodes = Optional.ofNullable(nodes);
        this.displayDataType = displayDataType;
        this.nodeCoordType = nodeCoordType;
        this.edgeWeightData = Optional.ofNullable(edgeWeightData);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public EdgeWeightType getEdgeWeightType() {
        return edgeWeightType;
    }

    public EdgeWeightFormat getEdgeWeightFormat() {
        return edgeWeightFormat;
    }

    public int getDimension() {
        return dimension;
    }

    public String getComment() {
        return comment;
    }

    public DisplayDataType getDisplayDataType() {
        return displayDataType;
    }

    public NodeCoordType getNodeCoordType() {
        return nodeCoordType;
    }

    public Optional<List<Node>> getNodes() {
        return nodes;
    }

    public Optional<int[][]> getEdgeWeightData() {
        return edgeWeightData;
    }
}
