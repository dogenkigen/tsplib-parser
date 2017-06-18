package com.mlaskows.tsplib;

import com.mlaskows.tsplib.stateparser.TSPLIBException;

import java.util.function.BiFunction;

/**
 * Created by mlaskows on 22/04/2017.
 */
public class DistanceCalculationMethodFactory {

    private static final double EARTH_RADIUS = 6378.388;

    public static BiFunction<Node, Node, Integer>
    getDistanceCalculationMethod(EdgeWeightType edgeWeightType) {
        switch (edgeWeightType) {
            case EXPLICIT:
                break;
            case EUC_2D:
                return getEuc2dFunction();
            case MAX_2D:
                break;
            case MAN_2D:
                break;
            case CEIL_2D:
                break;
            case GEO:
                return getGeoFunction();
            default:
                //TODO add more intelligent exception here since method might
                // be called to get 3 nodes function
                throw new TSPLIBException(edgeWeightType + " not implemented " +
                        "yet");
        }
        return null;
    }

    private static BiFunction<Node, Node, Integer> getGeoFunction() {
        return (i, j) -> {
            double latitudeI = convertToGeographical(i.getX());
            double longitudeI = convertToGeographical(i.getY());
            double latitudeJ = convertToGeographical(j.getX());
            double longitudeJ = convertToGeographical(j.getY());
            double q1 = Math.cos(longitudeI - longitudeJ);
            double q2 = Math.cos(latitudeI - latitudeJ);
            double q3 = Math.cos(latitudeI + latitudeJ);
            return (int) (EARTH_RADIUS * Math.acos(0.5 * ((1.0 + q1) * q2 -
                    (1.0 - q1) * q3)) + 1.0);
        };
    }

    private static double convertToGeographical(Double v) {
        int deg = v.intValue();
        double min = v - deg;
        return Math.PI * (deg + 0.5 * min / 3.0) / 180;
    }

    private static BiFunction<Node, Node, Integer> getEuc2dFunction() {
        return (i, j) -> {
            double xd = i.getX() - j.getX();
            double yd = i.getY() - j.getY();
            return (int) (Math.sqrt(xd * xd + yd * yd) + 0.5);
        };
    }

}
