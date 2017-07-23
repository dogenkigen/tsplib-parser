package com.mlaskows.tsplib.datamodel;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class Node {

    private final Integer id;
    private final Double y;
    private final Double x;

    public Node(Integer id, Double y, Double x) {
        this.id = id;
        this.y = y;
        this.x = x;
    }

    public Integer getId() {
        return id;
    }

    public Double getY() {
        return y;
    }

    public Double getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return id != null ? id.equals(node.id) : node.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}