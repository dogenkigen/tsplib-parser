package com.mlaskows.tsplib.datamodel;

import com.mlaskows.tsplib.types.DisplayDataType;
import com.mlaskows.tsplib.types.EdgeWeightType;
import com.mlaskows.tsplib.types.Type;

import java.util.ArrayList;
import java.util.List;

public class TspBuilder {
    private String name;
    private Type type;
    private int dimension;
    private StringBuilder comment = new StringBuilder();
    private EdgeWeightType edgeWeightType;
    private DisplayDataType displayDataType;
    private List<Node> nodes;

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
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        return this;
    }

    public Tsp build() {
        return new Tsp(name, type, edgeWeightType, dimension,
                comment.toString(), displayDataType, nodes);
    }
}