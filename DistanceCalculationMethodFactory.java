package com.mlaskows.tsplib;

import com.mlaskows.tsplib.stateparser.TSPLIBException;

import java.util.function.BiFunction;

/**
 * Created by mlaskows on 22/04/2017.
 */
public class DistanceCalculationMethodFactory {

    public static BiFunction<Node, Node, Integer>
    getTwoNodesDistanceCalculationMethod(EdgeWeightType edgeWeightType) {
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
                break;
            default:
                //TODO add more intelligent exception here since method might
                // be called to get 3 nodes function
                throw new TSPLIBException(edgeWeightType + " not implemented " +
                        "yet");
        }
        return null;
    }

    private static BiFunction<Node, Node, Integer> getEuc2dFunction() {
        BiFunction<Node, Node, Integer> function = (n1, n2) -> {
            double xd = n1.getX() - n2.getX();
            double yd = n1.getY() - n2.getY();
            return (int) Math.sqrt(xd * xd + yd * yd);
        };
        return function;
    }

}
