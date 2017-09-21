package com.mlaskows.tsplib.exception;

/**
 * Exception thrown for parsing errors.
 *
 * @author Maciej Laskowski
 */
public class TspLibException extends RuntimeException {

    public TspLibException(String message) {
        super(message);
    }

}
