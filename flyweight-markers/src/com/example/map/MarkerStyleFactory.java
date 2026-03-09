package com.example.map;

import java.util.HashMap;
import java.util.Map;

public class MarkerStyleFactory {

    private final Map<String, MarkerStyle> styles = new HashMap<>();

    public MarkerStyle get(String shape, String color, int size, boolean filled) {
        String lookupKey = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
        if (!styles.containsKey(lookupKey)) {
            styles.put(lookupKey, new MarkerStyle(shape, color, size, filled));
        }
        return styles.get(lookupKey);
    }

    public int cacheSize() {
        return styles.size();
    }
}
