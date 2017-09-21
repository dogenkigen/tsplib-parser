package com.mlaskows.tsplib;

import com.mlaskows.tsplib.datamodel.item.Tour;
import com.mlaskows.tsplib.datamodel.item.Tsp;
import com.mlaskows.tsplib.parser.TspLibParser;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by maciej_laskowski on 05.07.2017.
 */
public interface BaseWithTspTest {

    default Tsp getTsp(String fileName) throws IOException {
        return TspLibParser.parseTsp(getFileAbsolutePath(fileName));
    }

    default Tour getTour(String fileName) throws IOException {
        return TspLibParser.parseTour(getFileAbsolutePath(fileName));
    }

    default String getFileAbsolutePath(String fileName) {
        return Paths.get(fileName).toAbsolutePath().toString();
    }

}
