package com.mlaskows.tsplib.datamodel.types;

/**
 * This class contains all types of edge weights or distances.
 *
 * @author Maciej Laskowski
 */
public enum EdgeWeightType {

    /**
     * Weights are listed explicitly in the corresponding section.
     */
    EXPLICIT,

    /**
     * Weights are Euclidean distances in 2-D.
     */
    EUC_2D,

    /**
     * Weights are maximum distances in 2-D.
     */
    MAX_2D,

    /**
     * Weights are Manhattan distances in 2-D.
     */
    MAN_2D,

    /**
     * Weights are Euclidean distances in 2-D rounded up.
     */
    CEIL_2D,

    /**
     * Weights are geographical distances.
     */
    GEO,

    /**
     * Special distance function for problems att48 and att532.
     */
    ATT;

}
