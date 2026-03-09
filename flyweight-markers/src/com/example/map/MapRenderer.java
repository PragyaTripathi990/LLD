package com.example.map;

import java.util.List;

public class MapRenderer {

    public void render(List<MapMarker> markers) {
        System.out.println("Rendering " + markers.size() + " markers...");
        int displayed = 0;

        for (MapMarker m : markers) {
            if (displayed < 8) {
                System.out.println(format(m));
                displayed++;
            }
        }

        if (markers.size() > displayed) {
            System.out.println("... (" + (markers.size() - displayed) + " more not shown)");
        }
    }

    private String format(MapMarker m) {
        return String.format("%s @ (%.4f, %.4f) style=%s",
                m.getLabel(), m.getLat(), m.getLng(), m.getStyle());
    }
}
