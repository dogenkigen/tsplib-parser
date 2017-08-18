package com.mlaskows.tsplib.datamodel;

import com.mlaskows.tsplib.datamodel.types.DisplayDataType;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightFormat;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightType;
import com.mlaskows.tsplib.datamodel.types.Type;
import com.mlaskows.tsplib.exception.TspLibException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                final int index = getLastEdgeWeightDataEmptyRowIndex();
                edgeWeightData[index] = data;
                break;
            default:
                throw new TspLibException("Can't parse for edge weight format"
                        + edgeWeightFormat);
        }
        return this;
    }

    private int getLastEdgeWeightDataEmptyRowIndex() {
        for (int i = 0; i < edgeWeightData.length; i++) {
            if (edgeWeightData[i][0] == 0
                    && edgeWeightData[i][edgeWeightData.length - 1] == 0) {
                return i;
            }
        }
        throw new TspLibException("Can't find empty index");
    }

    public Tsp build() {
        return new Tsp(name, type, edgeWeightType, edgeWeightFormat, dimension,
                comment.toString(), displayDataType, nodes,
                Optional.ofNullable(edgeWeightData));
    }
}