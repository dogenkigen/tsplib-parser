package com.mlaskows.tsplib;

import com.mlaskows.tsplib.datamodel.Tour;
import com.mlaskows.tsplib.datamodel.Tsp;
import com.mlaskows.tsplib.datamodel.types.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

/**
 * Created by mlaskows on 21/04/2017.
 */
public class TspLibParserTest implements BaseWithTspTest {

    @Test
    public void testUsa13509() throws IOException {
        Tsp tsp = getTsp("tsplib/usa13509.tsp");

        assertEquals(tsp.getName(), "usa13509");
        assertEquals(tsp.getDimension(), 13509);
        assertEquals(tsp.getType(), Type.TSP);
        Assert.assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.EUC_2D);
        assertTrue(tsp.getNodes().isPresent());
        assertEquals(tsp.getNodes().get().size(), 13509);
    }

    @Test
    public void testAli535() throws IOException {
        Tsp tsp = getTsp("tsplib/ali535.tsp");

        assertEquals(tsp.getName(), "ali535");
        assertEquals(tsp.getDimension(), 535);
        assertEquals(tsp.getType(), Type.TSP);
        Assert.assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.GEO);
        Assert.assertEquals(tsp.getDisplayDataType(), DisplayDataType.COORD_DISPLAY);
        assertTrue(tsp.getNodes().isPresent());
        assertEquals(tsp.getNodes().get().size(), 535);
        assertEquals(tsp.getComment(), "535 Airports around the globe (Padberg/Rinaldi)");
    }

    @Test
    public void testBerlin52() throws IOException {
        final Tsp tsp = getTsp("tsplib/berlin52.tsp");

        assertEquals(tsp.getName(), "berlin52");
        assertEquals(tsp.getType(), Type.TSP);
        assertEquals(tsp.getComment(), "52 locations in Berlin (Groetschel)");
        assertEquals(tsp.getDimension(), 52);
        Assert.assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.EUC_2D);
    }

    @Test
    public void testBerlin52Tour() throws IOException {
        final Tour tour = getTour("tsplib/berlin52.opt.tour");

        assertEquals(tour.getName(), "berlin52.opt.tour");
        assertEquals(tour.getType(), Type.TOUR);
        assertEquals(tour.getDimension(), 52);
        final int[] expectedTour = {1, 49, 32, 45, 19, 41, 8, 9, 10, 43, 33,
                51, 11, 52, 14, 13, 47, 26, 27, 28, 12, 25, 4, 6, 15, 5, 24,
                48, 38, 37, 40, 39, 36, 35, 34, 44, 46, 16, 29, 50, 20, 23,
                30, 2, 7, 42, 21, 17, 3, 18, 31, 22};
        assertArrayEquals(expectedTour, tour.getTour().get(0));
    }

    @Test
    public void testAtt532() throws IOException {
        final Tsp tsp = getTsp("tsplib/att532.tsp");

        assertEquals(tsp.getName(), "att532");
        assertEquals(tsp.getType(), Type.TSP);
        assertEquals(tsp.getComment(), "532-city problem (Padberg/Rinaldi)");
        assertEquals(tsp.getDimension(), 532);
        assertTrue(tsp.getNodes().isPresent());
        assertEquals(tsp.getNodes().get().size(), 532);
        assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.ATT);
    }

    @Test
    public void testSwiss42() throws IOException {
        final Tsp tsp = getTsp("tsplib/swiss42.tsp");

        assertEquals(tsp.getName(), "swiss42");
        assertEquals(tsp.getType(), Type.TSP);
        assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.EXPLICIT);
        assertEquals(tsp.getEdgeWeightFormat(), EdgeWeightFormat.FULL_MATRIX);
        assertEquals(tsp.getDimension(), 42);
        assertTrue(tsp.getEdgeWeightData().isPresent());
        final int[][] data = tsp.getEdgeWeightData().get();
        assertEquals(data[0][0], 0);
        assertEquals(data[0][1], 15);
        assertEquals(data[41][40], 81);
    }

    @Test
    public void testBays29() throws IOException {
        final Tsp tsp = getTsp("tsplib/bays29.tsp");

        assertEquals(tsp.getName(), "bays29");
        assertEquals(tsp.getType(), Type.TSP);
        assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.EXPLICIT);
        assertEquals(tsp.getEdgeWeightFormat(), EdgeWeightFormat.FULL_MATRIX);
        assertEquals(tsp.getDisplayDataType(), DisplayDataType.TWOD_DISPLAY);
        assertEquals(tsp.getDimension(), 29);
        assertTrue(tsp.getEdgeWeightData().isPresent());
        assertTrue(tsp.getNodes().isPresent());
        assertEquals(tsp.getNodes().get().size(), 29);
    }

    @Test
    public void testDantzig42() throws IOException {
        final Tsp tsp = getTsp("tsplib/dantzig42.tsp");

        assertEquals(tsp.getName(), "dantzig42");
        assertEquals(tsp.getType(), Type.TSP);
        assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.EXPLICIT);
        assertEquals(tsp.getEdgeWeightFormat(), EdgeWeightFormat.LOWER_DIAG_ROW);
        assertEquals(tsp.getDisplayDataType(), DisplayDataType.TWOD_DISPLAY);
        assertEquals(tsp.getDimension(), 42);
        assertTrue(tsp.getEdgeWeightData().isPresent());
        final int[][] ints = tsp.getEdgeWeightData().get();
        final int[] expected = {5, 12, 55, 41, 53, 64, 61, 61, 66, 84, 111, 113,
                150, 186, 192, 166, 147, 180, 188, 167, 140, 124, 119, 90, 87,
                90, 94, 107, 114, 77, 86, 92, 98, 80, 74, 77, 60, 48, 38, 32,
                6, 0};
        assertArrayEquals(ints[41], expected);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                assertEquals(ints[i][j], ints[j][i]);
            }
        }
        assertTrue(tsp.getNodes().isPresent());
        assertEquals(tsp.getNodes().get().size(), 42);
    }

    @Test
    public void testSi175() throws IOException {
        final Tsp tsp = getTsp("tsplib/si175.tsp");
        assertEquals(tsp.getName(), "si175");
        assertEquals(tsp.getType(), Type.TSP);
        assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.EXPLICIT);
        assertEquals(tsp.getEdgeWeightFormat(), EdgeWeightFormat.UPPER_DIAG_ROW);
        assertEquals(tsp.getDisplayDataType(), DisplayDataType.NO_DISPLAY);
        assertEquals(tsp.getDimension(), 175);
        assertTrue(tsp.getEdgeWeightData().isPresent());
        final int[][] ints = tsp.getEdgeWeightData().get();
        final int[] expected = {0, 113, 189, 299, 189, 177, 187, 187, 187,
                162, 187, 162, 187, 162, 187, 177, 189, 202, 213, 234, 245,
                256, 266, 274, 282, 289, 296, 311, 319, 326, 333, 340, 262,
                246, 262, 246, 262, 312, 262, 262, 262, 278, 278, 278, 278,
                278, 278, 278, 262, 246, 246, 262, 246, 262, 246, 262, 246,
                262, 246, 262, 256, 262, 266, 272, 274, 282, 283, 289, 294,
                296, 304, 305, 311, 316, 319, 326, 333, 314, 294, 320, 320,
                278, 273, 287, 320, 287, 273, 287, 320, 314, 294, 312, 314,
                314, 321, 345, 294, 314, 314, 294, 312, 294, 314, 314, 312,
                294, 314, 314, 321, 345, 345, 370, 370, 370, 370, 370, 384,
                384, 340, 416, 416, 416, 416, 416, 416, 416, 416, 416, 416,
                416, 416, 416, 416, 416, 416, 416, 416, 416, 416, 416, 416,
                416, 416, 416, 416, 416, 345, 345, 368, 368, 370, 370, 370,
                370, 370, 370, 370, 370, 370, 370, 370, 384, 384, 384, 384,
                384, 384, 384, 384, 384, 384, 384, 384, 384, 384};
        assertArrayEquals(ints[0], expected);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                assertEquals(ints[i][j], ints[j][i]);
            }
        }
    }

    @Test
    public void testBrazil58() throws IOException {
        final Tsp tsp = getTsp("tsplib/brazil58.tsp");
        assertEquals(tsp.getName(), "brazil58");
        assertEquals(tsp.getType(), Type.TSP);
        assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.EXPLICIT);
        assertEquals(tsp.getEdgeWeightFormat(), EdgeWeightFormat.UPPER_ROW);
        assertEquals(tsp.getDimension(), 58);
        assertTrue(tsp.getEdgeWeightData().isPresent());
    }

    @Test
    public void testPa561() throws IOException {
        final Tsp tsp = getTsp("tsplib/pa561.tsp");

        assertEquals(tsp.getName(), "pa561.tsp");
        assertEquals(tsp.getType(), Type.TSP);
        assertEquals(tsp.getEdgeWeightType(), EdgeWeightType.EXPLICIT);
        assertEquals(tsp.getEdgeWeightFormat(), EdgeWeightFormat.LOWER_DIAG_ROW);
        assertEquals(tsp.getDimension(), 561);
        assertTrue(tsp.getEdgeWeightData().isPresent());
        assertEquals(NodeCoordType.NO_COORDS, tsp.getNodeCoordType());
    }

    @Test
    public void testGr24Tour() throws IOException {
        final Tour tour = getTour("tsplib/gr24.opt.tour");

        assertEquals(tour.getName(), "gr24.opt.tour");
        assertEquals(tour.getType(), Type.TOUR);
        assertEquals(tour.getDimension(), 24);
        assertEquals(tour.getComment(), "Optimal solution for gr24 (1272)");
    }

    @Test
    public void testAll() throws IOException {
        final List<String> tsps = Files.list(Paths.get("tsplib"))
                .map(path -> path.toAbsolutePath())
                .map(Path::toString)
                .filter(s -> s.endsWith("tsp") || s.endsWith("tour"))
                .collect(toList());
        for (String path : tsps) {
            try {
                TspLibParser.parseTsp(path);
            } catch (Exception e) {
                System.out.println(path + " " + e.getMessage());
            }
        }
    }

}
