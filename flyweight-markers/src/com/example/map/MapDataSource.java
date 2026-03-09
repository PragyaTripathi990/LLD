package com.example.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapDataSource {

    private static final String[] SHAPES = {"PIN", "CIRCLE", "SQUARE"};
    private static final String[] COLORS = {"RED", "BLUE", "GREEN", "ORANGE"};
    private static final int[] SIZES = {10, 12, 14, 16};

    private final MarkerStyleFactory styleCache = new MarkerStyleFactory();

    public List<MapMarker> loadMarkers(int count) {
        Random rng = new Random(7);
        List<MapMarker> result = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            double lat = 12.9000 + rng.nextDouble() * 0.2000;
            double lng = 77.5000 + rng.nextDouble() * 0.2000;
            String label = "M-" + i;

            String shape = SHAPES[rng.nextInt(SHAPES.length)];
            String color = COLORS[rng.nextInt(COLORS.length)];
            int size = SIZES[rng.nextInt(SIZES.length)];
            boolean filled = rng.nextBoolean();

            MarkerStyle style = styleCache.get(shape, color, size, filled);

            result.add(new MapMarker(lat, lng, label, style));
        }

        System.out.println("[factory] unique styles cached: " + styleCache.cacheSize());
        return result;
    }
}
