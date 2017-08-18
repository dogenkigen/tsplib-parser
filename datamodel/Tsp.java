package com.mlaskows.tsplib.datamodel;

import com.mlaskows.tsplib.datamodel.types.DisplayDataType;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightFormat;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightType;
import com.mlaskows.tsplib.datamodel.types.Type;

import java.util.List;
import java.util.Optional;

/**
 * Created by mlaskows on 21/04/2017.
 */
public final class Tsp {
    // TODO consider refactor for Optionals
    private final String name;
    private final Type type;
    private final EdgeWeightType edgeWeightType;
    private final EdgeWeightFormat edgeWeightFormat;
    private final int dimension;
    private final String comment;
    private final DisplayDataType displayDataType;
    private final List<Node> nodes;
    private final Optional<int[][]> edgeWeightData;

    public Tsp(String name, Type type, EdgeWeightType edgeWeightType,
               EdgeWeightFormat edgeWeightFormat, int dimension, String comment,
               DisplayDataType displayDataType, List<Node> nodes,
               Optional<int[][]> edgeWeightData) {
        this.name = name;
        this.type = type;
        this.edgeWeightType = edgeWeightType;
        this.edgeWeightFormat = edgeWeightFormat;
        this.dimension = dimension;
        this.comment = comment;
        this.nodes = nodes;
        this.displayDataType = displayDataType;
        this.edgeWeightData = edgeWeightData;
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

    public List<Node> getNodes() {
        return nodes;
    }

    public Optional<int[][]> getEdgeWeightData() {
        return edgeWeightData;
    }
}
