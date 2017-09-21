package com.mlaskows.tsplib;

import com.mlaskows.tsplib.datamodel.Tour;
import com.mlaskows.tsplib.datamodel.Tsp;
import com.mlaskows.tsplib.datamodel.ItemBuilder;
import com.mlaskows.tsplib.stateparser.ParsingContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class TspLibParser {

    public static Tsp parseTsp(String pathToFile) throws IOException {
        return getFilledItemBuilder(pathToFile).buildTsp();
    }

    public static Tour parseTour(String pathToFile) throws IOException {
        return getFilledItemBuilder(pathToFile).buildTour();
    }

    private static ItemBuilder getFilledItemBuilder(String pathToFile) throws IOException {
        ItemBuilder builder = new ItemBuilder();
        Stream<String> stream = Files.lines(Paths.get(pathToFile));

        List<String> lines = getNonEmptyTrimmedLines(stream);

        ParsingContext context = new ParsingContext();
        for (String line : lines) {
            context.consumeLine(line, builder);
        }
        return builder;
    }

    private static List<String> getNonEmptyTrimmedLines(Stream<String> stream) {
        return stream
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(l -> !l.isEmpty())
                .collect(Collectors.toList());
    }

}
