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

package com.mlaskows.tsplib.datamodel.tsp;

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

    /**
     * The class represents a node which contains it's ID and coordinates.
     *
     * @author Maciej Laskowski
     */
    public static class Node {

        private final int id;
        private final double y;
        private final double x;

        public Node(int id, double y, double x) {
            this.id = id;
            this.y = y;
            this.x = x;
        }

        public int getId() {
            return id;
        }

        public double getY() {
            return y;
        }

        public double getX() {
            return x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (id != node.id) return false;
            if (Double.compare(node.y, y) != 0) return false;
            return Double.compare(node.x, x) == 0;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = id;
            temp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(x);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

    }
}
