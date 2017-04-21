package com.mlaskows.tsplib;

import com.mlaskows.tsplib.statemachine.TSPLIBParsingContext;

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
public class TSPLIBParser {

    public static TSPLIBItem parse(String pathToFile) throws IOException {
        TSPLIBItemBuilder builder = new TSPLIBItemBuilder();
        Stream<String> stream = Files.lines(Paths.get(pathToFile));

        List<String> lines = getNonEmptyTrimmedLines(stream);

        TSPLIBParsingContext context = new TSPLIBParsingContext();
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
