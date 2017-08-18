package com.mlaskows.tsplib.datamodel;

import com.mlaskows.tsplib.datamodel.types.DisplayDataType;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightFormat;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightType;
import com.mlaskows.tsplib.datamodel.types.Type;
import com.mlaskows.tsplib.exception.TspLibException;

import java.util.ArrayList;
import java.util.List;

public class TspBuilder {
    private String name;
    private Type type;
    private int dimension;
    private StringBuilder comment = new StringBuilder();
    private EdgeWeightType edgeWeightType;
    private EdgeWeightFormat edgeWeightFormat;
    private DisplayDataType displayDataType;
    private List<Node> nodes;
    private int[][] edgeWeightData;
    private int lastEdgeWeightDataEmptyRowIndex;
    private int fillIndex;

    public TspBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TspBuilder withType(Type type) {
        this.type = type;
        return this;
    }

    public TspBuilder withEdgeWeightType(EdgeWeightType edgeWeightType) {
        this.edgeWeightType = edgeWeightType;
        return this;
    }

    public TspBuilder withEdgeWeightFormat(EdgeWeightFormat edgeWeightFormat) {
        this.edgeWeightFormat = edgeWeightFormat;
        return this;
    }

    public TspBuilder withDimension(int dimension) {
        this.dimension = dimension;
        return this;
    }

    public TspBuilder withComment(String comment) {
        this.comment.append(comment);
        return this;
    }

    public TspBuilder withDisplayDataType(DisplayDataType displayDataType) {
        this.displayDataType = displayDataType;
        return this;
    }

    public TspBuilder addNode(Node node) {
        if (nodes == null) {
            nodes = new ArrayList<>(dimension);
        }
        nodes.add(node);
        return this;
    }

    public TspBuilder addEdgeWeightData(int[] data) {
        if (edgeWeightData == null) {
            edgeWeightData = new int[dimension][dimension];
        }
        switch (edgeWeightFormat) {
            case FULL_MATRIX:
                edgeWeightData[lastEdgeWeightDataEmptyRowIndex] = data;
                lastEdgeWeightDataEmptyRowIndex++;
                break;
            case LOWER_ROW:
            case LOWER_DIAG_ROW:
                putInEdgeWeightDataLower(data);
                break;
            default:
                throw new TspLibException("Can't parse for edge weight format "
                        + edgeWeightFormat);
        }
        return this;
    }

    private void putInEdgeWeightDataLower(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                lastEdgeWeightDataEmptyRowIndex++;
                fillIndex = 0;
            } else {
                edgeWeightData[lastEdgeWeightDataEmptyRowIndex][fillIndex] = data[i];
                fillIndex++;
            }
        }
    }

    public Tsp build() {
        if (edgeWeightData != null
                && !EdgeWeightFormat.FULL_MATRIX.equals(edgeWeightFormat)) {
            // This means there is upper or lower triangular matrix so it
            // needs to be filled in symmetrical way
            fillInvertedValues();
        }
        return new Tsp(name, type, edgeWeightType, edgeWeightFormat, dimension,
                comment.toString(), displayDataType, nodes,
                edgeWeightData);
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