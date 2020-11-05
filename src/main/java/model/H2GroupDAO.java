package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2GroupDAO implements GroupDAO {


    public static void main(String[] args) {
        H2GroupDAO h2GroupDAO = new H2GroupDAO();
        List<Group> groupList = h2GroupDAO.findAllGroups();
        for(Group group: groupList){
            System.out.println(group.getClientId() + " " + group.getRouteTypeId());
        }
    }

    @Override
    public void insertGroup(Group group) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "INSERT INTO GROUPS VALUES(?, ?)";
        try {
            assert connection != null;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, group.getClientId());
            stm.setInt(2, group.getRouteTypeId());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteGroup(int clientId, int routeTypeId) {
        String sql = "DELETE FROM GROUPS WHERE (CLIENT_ID = ?) AND (ROUTE_TYPE_ID = ?)";
        try (Connection connection = H2DAOFactory.createConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, clientId);
                statement.setInt(2, routeTypeId);
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Запись успешно удалена");
        return true;
    }

    @Override
    public List<Group> findAllGroups() {
        List<Group> groupList = new ArrayList<>();
        String sql = "SELECT * FROM GROUPS";
        try (Connection connection = H2DAOFactory.createConnection()) {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int clientId = rs.getInt(1);
                int routeTypeId = rs.getInt(2);
                Group group = new Group();
                group.setClientId(clientId);
                group.setRouteTypeId(routeTypeId);
                groupList.add(group);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return groupList;
    }

    @Override
    public List<Group> findGroupByType(int id) {
        List<Group> groupList = new ArrayList<>();
        String sql = "SELECT * FROM GROUPS";
        try (Connection connection = H2DAOFactory.createConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);

                while (rs.next()) {
                    int clientId = rs.getInt(1);
                    int routeTypeId = rs.getInt(2);
                    if (routeTypeId == id) {

                        Group group = new Group();
                        group.setClientId(clientId);
                        group.setRouteTypeId(routeTypeId);
                        groupList.add(group);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return groupList;
    }

}
