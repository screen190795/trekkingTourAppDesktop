package geoData;

public abstract class geoDataFactory {
    public abstract CoordinatesParser getCoordinatesParser();
    public static geoDataFactory getGeoDataFactory(){
        return  new GoogleGeoDataFactory();
    }
}
