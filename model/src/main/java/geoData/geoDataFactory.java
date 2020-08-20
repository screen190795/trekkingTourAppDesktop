package geoData;

import model.DAOFactory;
import model.H2DAOFactory;

public abstract class geoDataFactory {
    public abstract CoordinatesParser getCoordinatesParser();
    public static geoDataFactory getGeoDataFactory(){
        return  new GoogleGeoDataFactory();
    }
}
