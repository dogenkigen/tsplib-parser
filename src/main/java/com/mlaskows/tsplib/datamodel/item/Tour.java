package com.mlaskows.tsplib.datamodel.item;

import com.mlaskows.tsplib.datamodel.types.Type;

import java.util.List;

/**
 * Representation of TSPLIB tour file.
 *
 * @author Maciej Laskowski
 */
public class Tour {

    private final String name;
    private final Type type;
    private final int dimension;
    private final String comment;
    private final List<int[]> tours;

    public Tour(String name, Type type, int dimension, String comment,
                List<int[]> tours) {
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.comment = comment;
        this.tours = tours;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getDimension() {
        return dimension;
    }

    public String getComment() {
        return comment;
    }

    public List<int[]> getTour() {
        return tours;
    }
}
