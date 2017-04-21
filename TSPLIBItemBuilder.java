package com.mlaskows.tsplib;

import java.util.ArrayList;
import java.util.List;

public class TSPLIBItemBuilder {
    private String name;
    private TSPLIBType type;
    private int dimension;
    private int capacity;
    private String comment;
    private List<Node> nodes;
    private EdgeWeightType edgeWeightType;

    public TSPLIBItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TSPLIBItemBuilder withType(TSPLIBType type) {
        this.type = type;
        return this;
    }

    public TSPLIBItemBuilder withEdgeWeightType(EdgeWeightType edgeWeightType) {
        this.edgeWeightType = edgeWeightType;
        return this;
    }

    public TSPLIBItemBuilder withDimension(int dimension) {
        this.dimension = dimension;
        return this;
    }

    public TSPLIBItemBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public TSPLIBItemBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public TSPLIBItemBuilder addNode(Node node) {
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        return this;
    }

    public TSPLIBItem build() {
        return new TSPLIBItem(name, type, edgeWeightType, dimension, capacity, comment, nodes);
    }
}