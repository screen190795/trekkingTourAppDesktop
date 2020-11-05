package geoData;

public class GoogleGeoDataFactory extends geoDataFactory {
    @Override
    public CoordinatesParser getCoordinatesParser() {
        return new GoogleMapsCoordinatesParser();
    }
}
