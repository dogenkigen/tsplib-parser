package com.mlaskows.tsplib.types;

/**
 * Specifies how graphical display of nodes can be obtained.
 *
 * @author Maciej Laskowski
 */
public enum DisplayDataType {

    /**
     * Display is generated for node coordinates. Default value if node
     * coordinates are specified and {@code NO_DISPLAY} otherwise.
     */
    COORD_DISPLAY,

    /**
     * Explicit coordinates in 2-D are given.
     */
    TWOD_DISPLAY,

    /**
     * No graphical display is possible.
     */
    NO_DISPLAY;
}
