/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mlaskows.tsplib.parser;

import com.mlaskows.tsplib.datamodel.tour.Tour;
import com.mlaskows.tsplib.datamodel.tsp.Tsp;
import com.mlaskows.tsplib.exception.TspLibException;
import com.mlaskows.tsplib.stateparser.DataBuffer;
import com.mlaskows.tsplib.stateparser.ParsingContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * The parser class for getting object representation of TSPLIB files.
 *
 * @author Maciej Laskowski
 */
public class TspLibParser {

    /**
     * Parses TSPLIB tsp file and returns it's object representation.
     *
     * @param pathToFile absolute path to tsp file
     * @return object representation of TSPLIB tsp file
     */
    public static Tsp parseTsp(String pathToFile) {
        return getFilledItemBuilder(pathToFile).buildTsp();
    }

    /**
     * Parses TSPLIB tour file and returns it's object representation.
     *
     * @param pathToFile absolute path to tour file
     * @return representation of TSPLIB tour file
     */
    public static Tour parseTour(String pathToFile) {
        return getFilledItemBuilder(pathToFile).buildTour();
    }

    private static DataBuffer getFilledItemBuilder(String pathToFile) {
        final DataBuffer builder = new DataBuffer();
        final ParsingContext context = new ParsingContext();

        try {
            getNonEmptyTrimmedLines(Files.lines(Paths.get(pathToFile)))
                    .forEach(line -> context.consumeLine(line, builder));
        } catch (IOException e) {
            throw new TspLibException(e.getMessage());
        }

        return builder;
    }

    private static Stream<String> getNonEmptyTrimmedLines(Stream<String> stream) {
        return stream.filter(Objects::nonNull)
                .map(String::trim)
                .filter(line -> !line.isEmpty());
    }

}
