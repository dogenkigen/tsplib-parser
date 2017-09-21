package com.mlaskows.tsplib.datamodel.types;

/**
 * Specifies whether coordinates are associated with each node (which,
 * for example may be used for either graphical display or distance
 * computations).
 *
 * @author Maciej Laskowski
 */
public enum NodeCoordType {

    /**
     * Nodes are specified by coordinates in 2-D.
     */
    TWOD_COORDS,

    /**
     * Nodes are specified by coordinates in 3-D.
     */
    THREED_COORDS,

    /**
     * The nodes do not have associated coordinates.
     */
    NO_COORDS;
}
