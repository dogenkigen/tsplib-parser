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

package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.datamodel.tour.Tour;
import com.mlaskows.tsplib.datamodel.tsp.Tsp;
import com.mlaskows.tsplib.datamodel.types.*;
import com.mlaskows.tsplib.exception.TspLibException;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder used for creating representation of TSPLIB tsp or tour file.
 *
 * @author Maciej Laskowski
 */
public class DataBuffer {

    private String name;
    private Type type;
    private int dimension;
    private StringBuilder comment = new StringBuilder();
    private EdgeWeightType edgeWeightType;
    private EdgeWeightFormat edgeWeightFormat;
    private DisplayDataType displayDataType;
    private NodeCoordType nodeCoordType;
    private List<Tsp.Node> nodes;
    private List<int[]> tours;
    private int[][] edgeWeightData;
    private int lastTourEmptyIndex;
    private int lastEdgeWeightDataEmptyRowIndex;
    private int fillIndex;

    public DataBuffer withName(String name) {
        this.name = name;
        return this;
    }

    public DataBuffer withType(Type type) {
        this.type = type;
        return this;
    }

    public DataBuffer withEdgeWeightType(EdgeWeightType edgeWeightType) {
        this.edgeWeightType = edgeWeightType;
        return this;
    }

    public DataBuffer withEdgeWeightFormat(EdgeWeightFormat edgeWeightFormat) {
        this.edgeWeightFormat = edgeWeightFormat;
        return this;
    }

    public DataBuffer withDimension(int dimension) {
        this.dimension = dimension;
        return this;
    }

    public DataBuffer withComment(String comment) {
        this.comment.append(comment);
        return this;
    }

    public DataBuffer withDisplayDataType(DisplayDataType displayDataType) {
        this.displayDataType = displayDataType;
        return this;
    }

    public DataBuffer withNodeCoordType(NodeCoordType nodeCoordType) {
        this.nodeCoordType = nodeCoordType;
        return this;
    }

    public DataBuffer addNode(Tsp.Node node) {
        if (nodes == null) {
            nodes = new ArrayList<>(dimension);
        }
        nodes.add(node);
        return this;
    }

    public DataBuffer addTourStep(int step) {
        if (tours == null) {
            tours = new ArrayList<>();
        }
        if (lastTourEmptyIndex == 0) {
            tours.add(new int[dimension]);
        }
        tours.get(tours.size() - 1)[lastTourEmptyIndex] = step;
        lastTourEmptyIndex++;
        return this;
    }

    public void finishLastTour() {
        lastTourEmptyIndex = 0;
    }

    public DataBuffer withEdgeWeightData(int[] data) {
        if (edgeWeightData == null) {
            edgeWeightData = new int[dimension][dimension];
            if (EdgeWeightFormat.UPPER_DIAG_ROW.equals(edgeWeightFormat)) {
                lastEdgeWeightDataEmptyRowIndex = -1;
            }
        }
        switch (edgeWeightFormat) {
            case FULL_MATRIX:
                edgeWeightData[lastEdgeWeightDataEmptyRowIndex] = data;
                lastEdgeWeightDataEmptyRowIndex++;
                break;
            case UPPER_ROW:
                putinEdgeWeightData(data, lastEdgeWeightDataEmptyRowIndex + 1);
                break;
            case LOWER_ROW:
                putinEdgeWeightData(data, 0);
                break;
            case LOWER_DIAG_ROW:
                putInEdgeWeightDataLowerDiag(data);
                break;
            case UPPER_DIAG_ROW:
                putInEdgeWeightDataUpperDiag(data);
                break;
            default:
                throw new TspLibException("Can't parseTsp for edge weight format " + edgeWeightFormat);
        }
        return this;
    }

    private void putinEdgeWeightData(int[] data, int initialFillIndex) {
        fillIndex = initialFillIndex;
        for (int element : data) {
            edgeWeightData[lastEdgeWeightDataEmptyRowIndex][fillIndex] = element;
            fillIndex++;
        }
        lastEdgeWeightDataEmptyRowIndex++;
    }

    private void putInEdgeWeightDataLowerDiag(int[] data) {
        for (int element : data) {
            if (element == 0) {
                lastEdgeWeightDataEmptyRowIndex++;
                fillIndex = 0;
            } else {
                edgeWeightData[lastEdgeWeightDataEmptyRowIndex][fillIndex] = element;
                fillIndex++;
            }
        }
    }

    private void putInEdgeWeightDataUpperDiag(int[] data) {
        for (int element : data) {
            if (element == 0) {
                lastEdgeWeightDataEmptyRowIndex++;
                fillIndex = lastEdgeWeightDataEmptyRowIndex + 1;
            } else {
                edgeWeightData[lastEdgeWeightDataEmptyRowIndex][fillIndex] = element;
                fillIndex++;
            }
        }
    }

    public Tsp buildTsp() {
        if (edgeWeightData != null
                && EdgeWeightFormat.isTriangular(edgeWeightFormat)) {
            fillInvertedValues();
        }
        return new Tsp(name, type, edgeWeightType, edgeWeightFormat, dimension,
                comment.toString(), displayDataType, nodeCoordType, nodes,
                edgeWeightData);
    }

    public Tour buildTour() {
        return new Tour(name, type, dimension, comment.toString(), tours);
    }

    private void fillInvertedValues() {
        for (int i = 0; i < edgeWeightData.length; i++) {
            for (int j = 0; j < edgeWeightData.length; j++) {
                if (edgeWeightData[i][j] != 0) {
                    edgeWeightData[j][i] = edgeWeightData[i][j];
                }
            }
        }
    }

}