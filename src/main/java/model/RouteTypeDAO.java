package model;

import java.util.List;

public interface RouteTypeDAO {
    void insertRouteType(RouteType routeType);
    boolean deleteRouteType(int id);
    RouteType selectRouteTypeById(int id);
    boolean updateRouteType(RouteType routeType);

    default List<RouteType> findAllRouteTypes() {
        return null;
    }
}
