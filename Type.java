package com.mlaskows.tsplib;

/**
 * Created by mlaskows on 21/04/2017.
 */
public enum Type {

    /**
     * Data for symmetric travelling salesman problem
     */
    TSP,

    /**
     * Data for asymmetric travelling salesman problem
     */
    ATSP,

    /**
     * Data for sequential ordering problem
     */
    SOP,

    /**
     * Hamiltonian cycle problem data
     */
    HCP,

    /**
     * Capacitated vehicle routing problem
     */
    CVRP,

    /**
     * A collection of tours
     */
    TOUR;

}
