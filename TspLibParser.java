package com.mlaskows.tsplib;

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

    public static Item parse(String pathToFile) throws IOException {
        ItemBuilder builder = new ItemBuilder();
        Stream<String> stream = Files.lines(Paths.get(pathToFile));

        List<String> lines = getNonEmptyTrimmedLines(stream);

        ParsingContext context = new ParsingContext();
        for (String line : lines) {
            context.consumeLine(line, builder);
        }

        return builder.build();
    }

    private static List<String> getNonEmptyTrimmedLines(Stream<String> stream) {
        return stream
                .filter(Objects::nonNull)
                .map(l -> l.trim())
                .filter(l -> !l.isEmpty())
                .collect(Collectors.toList());
    }

}
