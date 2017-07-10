package com.mlaskows.tsplib;

import java.util.List;

/**
 * Created by mlaskows on 21/04/2017.
 */
//TODO add info about thread safety everywhere
public final class Item {
    // TODO consider refactor for Optionals
    private final String name;
    private final Type type;
    private final EdgeWeightType edgeWeightType;
    private final int dimension;
    private final int capacity;
    private final String comment;
    // TODO use immutable collections
    private final List<Node> nodes;
    private final DisplayDataType displayDataType;

    public Item(String name, Type type, EdgeWeightType edgeWeightType,
                int dimension, int capacity, String comment,
                DisplayDataType displayDataType, List<Node> nodes) {
        this.name = name;
        this.type = type;
        this.edgeWeightType = edgeWeightType;
        this.dimension = dimension;
        this.capacity = capacity;
        this.comment = comment;
        this.nodes = nodes;
        this.displayDataType = displayDataType;
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

    public int getDimension() {
        return dimension;
    }

    @Deprecated
    public int getCapacity() {
        return capacity;
    }

    public String getComment() {
        return comment;
    }

    public DisplayDataType getDisplayDataType() {
        return displayDataType;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
