package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2EquipmentDAO implements EquipmentDAO {


    @Override
    public void insertEquipment(Equipment equipment) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "INSERT INTO EQUIPMENT VALUES(?, ?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, equipment.getItemId());
            stm.setInt(2, equipment.getEquipmentTypeId());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    public boolean deleteEquipment(int itemId, int equipmentTypeId) {
        String sql = "DELETE FROM EQUIPMENT WHERE (ITEM_ID = ?) AND (EQUIPMENT_TYPE_ID = ?)";
        try (Connection connection = H2DAOFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, itemId);
            statement.setInt(2, equipmentTypeId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Запись успешно удалена");
        return true;
    }

    @Override
    public List<Equipment> findAll() {
        List<Equipment> equipmentList = new ArrayList<>();
        String sql = "SELECT * FROM EQUIPMENT";
        try (Connection connection = H2DAOFactory.createConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int itemId = rs.getInt(1);
                int equipmentTypeId = rs.getInt(2);
                Equipment equipment = new Equipment();
                equipment.setItemId(itemId);
                equipment.setEquipmentTypeId(equipmentTypeId);
                equipmentList.add(equipment);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return equipmentList;
    }


    @Override
    public List<Equipment> findEquipmentByType(int id) {
        H2ItemDAO h2ItemDAO = new H2ItemDAO();
        List<Equipment> equipmentList = new ArrayList<>();
        String sql = "SELECT * FROM EQUIPMENT";
        try (Connection connection = H2DAOFactory.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int itemId = rs.getInt(1);
                int equipmentTypeId = rs.getInt(2);
                if (equipmentTypeId == id) {
                    Item item = h2ItemDAO.findItemById(itemId);

                    Equipment equipment = new Equipment();
                    equipment.setItemId(itemId);
                    equipment.setEquipmentTypeId(equipmentTypeId);
                    equipmentList.add(equipment);
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return equipmentList;
    }


    public static void main(String[] args) {
        Equipment equipment = new Equipment();
        equipment.setItemId(3);
        equipment.setEquipmentTypeId(7);

        H2EquipmentDAO h2EquipmentDAO = new H2EquipmentDAO();
        h2EquipmentDAO.insertEquipment(equipment);

    }
}
