/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mlaskows.tsplib.util;

import com.mlaskows.tsplib.datamodel.tsp.Tsp;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightType;
import com.mlaskows.tsplib.exception.TspLibException;

import java.util.function.BiFunction;

/**
 * This class provides edge weight calculation methods for {@link EdgeWeightType}.
 *
 * @author Maciej Laskowski
 */
public class EdgeWeightCalculationMethodFactory {

    private static final double EARTH_RADIUS = 6378.388;

    /**
     * Returns {@link BiFunction} with edge weight calculation method for
     * specified {@link EdgeWeightType}.
     *
     * @param edgeWeightType type of edge weight
     * @return {@link BiFunction} with edge weight calculation method for
     * specified {@link EdgeWeightType}
     */
    public static BiFunction<Tsp.Node, Tsp.Node, Integer> getEdgeWeightCalculationMethod(EdgeWeightType edgeWeightType) {
        switch (edgeWeightType) {
            case EUC_2D:
                return getEuc2dFunction();
            case GEO:
                return getGeoFunction();
            case MAN_2D:
                return getMan2dFunction();
            case MAX_2D:
                return getMax2dFunction();
            case CEIL_2D:
                return getCeil2dFunction();
            case ATT:
                return getAttFunction();
            default:
                throw new TspLibException(edgeWeightType + " not implemented yet");
        }
    }

    private static BiFunction<Tsp.Node, Tsp.Node, Integer> getEuc2dFunction() {
        return (i, j) -> (int) calculateEuc2d(i, j);
    }

    private static double calculateEuc2d(Tsp.Node i, Tsp.Node j) {
        double xd = i.getX() - j.getX();
        double yd = i.getY() - j.getY();
        return Math.sqrt(xd * xd + yd * yd) + 0.5;
    }

    private static BiFunction<Tsp.Node, Tsp.Node, Integer> getGeoFunction() {
        return (i, j) -> {
            double latitudeI = convertToRadians(i.getY());
            double longitudeI = convertToRadians(i.getX());
            double latitudeJ = convertToRadians(j.getY());
            double longitudeJ = convertToRadians(j.getX());
            double q1 = Math.cos(longitudeI - longitudeJ);
            double q2 = Math.cos(latitudeI - latitudeJ);
            double q3 = Math.cos(latitudeI + latitudeJ);
            return (int) (EARTH_RADIUS *
                    Math.acos(0.5 * ((1.0 + q1) * q2 - (1.0 - q1) * q3)) + 1.0);
        };
    }

    private static double convertToRadians(Double v) {
        int deg = v.intValue();
        double min = v - deg;
        return Math.PI * (deg + 0.5 * min / 3.0) / 180;
    }

    private static BiFunction<Tsp.Node, Tsp.Node, Integer> getMan2dFunction() {
        return (i, j) -> {
            double xd = Math.abs(i.getX() - j.getX());
            double yd = Math.abs(i.getY() - j.getY());
            return (int) (xd + yd);
        };
    }

    private static BiFunction<Tsp.Node, Tsp.Node, Integer> getMax2dFunction() {
        return (i, j) -> {
            double xd = Math.abs(i.getX() - j.getX());
            double yd = Math.abs(i.getY() - j.getY());
            return (int) Math.max(xd, yd);
        };
    }

    private static BiFunction<Tsp.Node, Tsp.Node, Integer> getCeil2dFunction() {
        return (i, j) -> (int) Math.ceil(calculateEuc2d(i, j));
    }

    private static BiFunction<Tsp.Node, Tsp.Node, Integer> getAttFunction() {
        return (i, j) -> {
            double xd = i.getX() - j.getX();
            double yd = i.getY() - j.getY();
            double rij = Math.sqrt((xd * xd + yd * yd) / 10.0);
            double tij = cutDecimal(rij);

            return (int) (tij < rij ? tij + 1 : tij);
        };
    }

    private static double cutDecimal(double x) {
        return (int) x;
    }

}
