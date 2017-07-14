package com.mlaskows.tsplib;

/**
 * Created by mlaskows on 21/04/2017.
 */
public enum EdgeWeightType {

    /**
     * Weights are listed explicitly in the corresponding section
     */
    EXPLICIT,

    /**
     * Weights are Euclidean distances in 2-D
     */
    EUC_2D,

    /**
     * Weights are maximum distances in 2-D
     */
    MAX_2D,

    /**
     * Weights are Manhattan distances in 2-D
     */
    MAN_2D,

    /**
     * Weights are Euclidean distances in 2-D rounded up
     */
    CEIL_2D,

    /**
     * Weights are geographical distances
     */
    GEO;

}
