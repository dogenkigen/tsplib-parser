package com.mlaskows.tsplib.datamodel;

import com.mlaskows.tsplib.datamodel.types.DisplayDataType;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightType;
import com.mlaskows.tsplib.datamodel.types.Type;

import java.util.List;

/**
 * Created by mlaskows on 21/04/2017.
 */
public final class Tsp {
    // TODO consider refactor for Optionals
    private final String name;
    private final Type type;
    private final EdgeWeightType edgeWeightType;
    private final int dimension;
    private final String comment;
    private final List<Node> nodes;
    private final DisplayDataType displayDataType;

    public Tsp(String name, Type type, EdgeWeightType edgeWeightType,
               int dimension, String comment,
               DisplayDataType displayDataType, List<Node> nodes) {
        this.name = name;
        this.type = type;
        this.edgeWeightType = edgeWeightType;
        this.dimension = dimension;
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
