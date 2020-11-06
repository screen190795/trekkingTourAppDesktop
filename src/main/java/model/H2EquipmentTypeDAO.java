package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD операции для класса EquipmentType
 */
public class H2EquipmentTypeDAO implements EquipmentTypeDAO {
    @Override
    public void insertEquipmentType(EquipmentType equipmentType) {

            Connection connection = H2DAOFactory.createConnection();
            String sql = "INSERT INTO EQUIPMENT_TYPE VALUES(null, ?, ?, ?, ?)";

            try {
                assert connection != null;
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setString(1, equipmentType.getName());
                stm.setInt(2, equipmentType.getMaxWeight());
                stm.setString(3, equipmentType.getPurpose());
                stm.setString(4, equipmentType.getDescription());
                stm.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    @Override
    public boolean deleteEquipmentType(int id) throws SQLException {
        String sql = "DELETE FROM EQUIPMENT_TYPE WHERE EQUIPMENT_TYPE_ID = ?";
        Connection connection = H2DAOFactory.createConnection();
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.executeUpdate();

        System.out.println("Запись успешно удалена");
        return true;
    }

    @Override
    public boolean updateEquipmentType(EquipmentType equipmentType) {
        String sql = "UPDATE EQUIPMENT_TYPE SET EQUIPMENT_TYPE_NAME=?, MAX_WEIGHT=?, PURPOSE=?, DESCRIPTION=? WHERE EQUIPMENT_TYPE_ID=?";
        try (Connection connection = H2DAOFactory.createConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(5, equipmentType.getId());
                statement.setString(1, equipmentType.getName());
                statement.setInt(2, equipmentType.getMaxWeight());
                statement.setString(3, equipmentType.getPurpose());
                statement.setString(4, equipmentType.getDescription());
                int rowsAffected = statement.executeUpdate();
                statement.close();
                System.out.println(rowsAffected + " Rows affected");
                System.out.println("Items.Item with id " + equipmentType.getId() + " was updated in DB with following details: " + equipmentType.getName() + " " + equipmentType.getMaxWeight() + " " + equipmentType.getPurpose() + " " + equipmentType.getDescription());


            }
        } catch (SQLException | NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public List<EquipmentType> findAll() {
        List<EquipmentType> equipmentTypes = new ArrayList<>();
        String sql = "SELECT * FROM EQUIPMENT_TYPE";
        try (Connection connection = H2DAOFactory.createConnection()) {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int maxWeight = rs.getInt(3);
                String purpose = rs.getString(4);
                String description = rs.getString(5);
                EquipmentType equipmentType = new EquipmentType();
                equipmentType.setId(id);
                equipmentType.setName(name);
                equipmentType.setMaxWeight(maxWeight);
                equipmentType.setPurpose(purpose);
                equipmentType.setDescription(description);
                equipmentTypes.add(equipmentType);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return equipmentTypes;
    }

    @Override
    public EquipmentType selectEquipmentTypeById(int id) {
        return null;
    }

    public static void main(String[] args) {
        H2EquipmentTypeDAO h2EquipmentTypeDAO = new H2EquipmentTypeDAO();
        EquipmentType equipmentType = new EquipmentType();
        equipmentType.setName("name");
        equipmentType.setMaxWeight(222);
        equipmentType.setPurpose("purpose");
        equipmentType.setDescription("description");
        h2EquipmentTypeDAO.insertEquipmentType(equipmentType);
    }


}
