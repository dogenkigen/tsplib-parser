package com.mlaskows.tsplib.datamodel.item;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class Node {

    private final int id;
    private final double y;
    private final double x;

    public Node(int id, double y, double x) {
        this.id = id;
        this.y = y;
        this.x = x;
    }

    public int getId() {
        return id;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (id != node.id) return false;
        if (Double.compare(node.y, y) != 0) return false;
        return Double.compare(node.x, x) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
