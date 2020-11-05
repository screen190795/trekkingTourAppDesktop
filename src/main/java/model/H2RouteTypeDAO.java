package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2RouteTypeDAO implements RouteTypeDAO {
    @Override
    public void insertRouteType(RouteType routeType) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "INSERT INTO ROUTE_TYPES VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            assert connection != null;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, routeType.getRouteTypeName());
            stm.setDouble(2, routeType.getRouteTypeStartX());
            stm.setDouble(3, routeType.getRouteTypeStartY());
            stm.setDouble(4, routeType.getRouteTypeFinishX());
            stm.setDouble(5, routeType.getRouteTypeFinishY());
            stm.setFloat(6, routeType.getRouteTypeDistance());
            stm.setString(7, routeType.getRouteTypeDescription());
            stm.setFloat(8, routeType.getRouteTypeDuration());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteRouteType(int id) {
        String sql = "DELETE FROM ROUTE_TYPES WHERE ROUTE_TYPE_ID = ?";
        try (Connection connection = H2DAOFactory.createConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Запись успешно удалена");
        return true;
    }

    @Override
    public RouteType selectRouteTypeById(int id) {
        return null;
    }

    @Override
    public boolean updateRouteType(RouteType routeType) {
        String sql = "UPDATE ROUTE_TYPES SET ROUTE_TYPE_NAME=?,  ROUTE_TYPE_STARTX=?, ROUTE_TYPE_STARTY=?, ROUTE_TYPE_FINISHX=?, ROUTE_TYPE_FINISHY=?, ROUTE_TYPE_DISTANCE=?, ROUTE_TYPE_DESCRIPTION=?, ROUTE_TYPE_DURATION=? WHERE ROUTE_TYPE_ID=?";
        try (Connection connection = H2DAOFactory.createConnection()) {
            assert connection != null;
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                stm.setInt(9,routeType.getRouteTypeId());
                stm.setString(1, routeType.getRouteTypeName());
                stm.setDouble(2, routeType.getRouteTypeStartX());
                stm.setDouble(3, routeType.getRouteTypeStartY());
                stm.setDouble(4, routeType.getRouteTypeFinishX());
                stm.setDouble(5, routeType.getRouteTypeFinishY());
                stm.setFloat(6, routeType.getRouteTypeDistance());
                stm.setString(7, routeType.getRouteTypeDescription());
                stm.setFloat(8, routeType.getRouteTypeDuration());
                int rowsAffected = stm.executeUpdate();
                stm.close();
                System.out.println(rowsAffected + " Rows affected");
            }
        } catch (SQLException | NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public List<RouteType> findAllRouteTypes() {
        List<RouteType> routeTypes = new ArrayList<>();
        String sql = "SELECT * FROM ROUTE_TYPES";
        try (Connection connection = H2DAOFactory.createConnection()) {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double startX = rs.getDouble(3);
                double startY = rs.getDouble(4);
                double finishX = rs.getDouble(5);
                double finishY = rs.getDouble(6);
                float distance = rs.getFloat(7);
                String description = rs.getString(8);
                float duration = rs.getFloat(9);
                RouteType routeType = new RouteType();
                routeType.setRouteTypeId(id);
                routeType.setRouteTypeName(name);
                routeType.setRouteTypeStartX(startX);
                routeType.setRouteTypeStartY(startY);
                routeType.setRouteTypeFinishX(finishX);
                routeType.setRouteTypeFinishY(finishY);
                routeType.setRouteTypeDistance(distance);
                routeType.setRouteTypeDescription(description);
                routeType.setRouteTypeDuration(duration);
                routeTypes.add(routeType);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return routeTypes;
    }

    public static void main(String[] args) {
        H2RouteTypeDAO h2RouteTypeDAO = new H2RouteTypeDAO();
        List<RouteType> routeTypes = h2RouteTypeDAO.findAllRouteTypes();
        for(RouteType routeType: routeTypes){
            System.out.println(routeType.getRouteTypeDescription());
        }
    }
}
