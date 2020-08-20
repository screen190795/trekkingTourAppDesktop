package model;

import javax.sql.RowSet;
import java.util.Collection;
import java.util.List;

public interface RouteTypeDAO {
    void insertRouteType(RouteType routeType);
    boolean deleteRouteType(int id);
    RouteType selectRouteTypeById(int id);
    boolean updateRouteType(RouteType routeType);
    List<RouteType> findAllRouteTypes();
}
