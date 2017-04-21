package com.mlaskows.tsplib;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class Node {

    private Integer id;
    private Double y;
    private Double x;

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

}
