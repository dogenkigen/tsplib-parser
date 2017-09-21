package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.datamodel.types.*;

import java.util.EnumSet;
import java.util.Set;

/**
 * This enum contains keywords used in TSPLIB.
 *
 * @author Maciej Laskowski
 */
public enum Keyword {

    //Specification part

    /**
     * Identifies the data file.
     */
    NAME,

    /**
     * Specifies the type of data. Possible types are in
     * {@link Type}
     */
    TYPE,

    /**
     * Additional comments.
     */
    COMMENT,

    /**
     * For TSP the dimension is number of it's nodes. For a TOUR file it is
     * the dimension of corresponding problem.
     */
    DIMENSION,

    /**
     * Specifies how the edge weights (or distances) are given. Possible
     * types are in {@link EdgeWeightType}.
     */
    EDGE_WEIGHT_TYPE,

    /**
     * Describes the format of the edge weights if they are given explicitly.
     * Possible values are in {@link EdgeWeightFormat}.
     */
    EDGE_WEIGHT_FORMAT,

    /**
     * Specifies how a graphical display of nodes can be obtained. Possible
     * values are in {@link DisplayDataType}.
     */
    DISPLAY_DATA_TYPE,

    /**
     * Specifies whether coordinates are associated with each node (which,
     * for example may be used for either graphical display or distance
     * computations). The values are in {@link NodeCoordType}
     */
    NODE_COORD_TYPE,

    // Data part

    /**
     * Node coordinates are given in this section. Each line is of the form
     * {@code int} {@code double} {@code double}
     */
    NODE_COORD_SECTION,

    /**
     * The edge weights are given in specified format
     * {@link EdgeWeightFormat}. At present all explicit data is integral and
     * it's given in one of the (self-explanatory) matrix formats, with
     * implicitly known lengths.
     */
    EDGE_WEIGHT_SECTION,

    /**
     * If it's {@code DisplayDataType.TWOD_DISPLAY}, the 2-dimensional
     * coordinates form which a display can be generated are given in the
     * form (per line)
     * {@code int} {@code double} {@code double}
     * The integers specify the respective nodes and the doubles give the
     * associated coordinates.
     */
    DISPLAY_DATA_SECTION,

    /**
     * A collection of tours is specified in this section. Each tour is given
     * by a list of integers giving the sequence in which the nodes are
     * visited in this tour. Every such tour is terminated by a -1. An
     * additional -1 terminates this section.
     */
    TOUR_SECTION,

    /**
     * Terminates the input data. This entry is optional.
     */
    EOF;

    private static final Set<Keyword> DATA_KEYWORDS =
            EnumSet.of(NODE_COORD_SECTION, EDGE_WEIGHT_SECTION,
                    DISPLAY_DATA_SECTION, TOUR_SECTION);

    /**
     * Returns true if the keyword is data keyword.
     *
     * @param keyword keyword to be checked
     * @return true if the keyword is data keyword
     */
    public static boolean isDataKeyword(Keyword keyword) {
        return DATA_KEYWORDS.contains(keyword);
    }

}
