package com.mlaskows.tsplib.stateparser;

import com.mlaskows.tsplib.datamodel.types.DisplayDataType;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightFormat;
import com.mlaskows.tsplib.datamodel.types.EdgeWeightType;
import com.mlaskows.tsplib.datamodel.types.Type;

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

    // Data part

    /**
     * Node coordinates are given in this section. Each line is of the form
     * integer double double
     */
    NODE_COORD_SECTION,


    EDGE_DATA_SECTION,
    EDGE_WEIGHT_SECTION,

    /**
     * Terminates the input data. This entry is optional.
     */
    EOF;

    private static final Set<Keyword> dataKeywords =
            EnumSet.of(NODE_COORD_SECTION, EDGE_DATA_SECTION,
                    EDGE_WEIGHT_SECTION);

    /**
     * Returns true if the keyword is data keyword.
     *
     * @param keyword keyword to be checked
     * @return true if the keyword is data keyword
     */
    public static boolean isDataKeyword(Keyword keyword) {
        return dataKeywords.contains(keyword);
    }

}
