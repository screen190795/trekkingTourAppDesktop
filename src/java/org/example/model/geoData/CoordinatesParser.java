package org.example.model.geoData;

import java.util.List;

public interface CoordinatesParser {
    List<GeoPoint> parseURL(String url);
    double distanceTo(GeoPoint gp1, GeoPoint gp2);
    double wholeDistance(List geoPoints);
}
