package model;

import java.sql.SQLException;
import java.util.List;

public interface EquipmentTypeDAO {
    void insertEquipmentType(EquipmentType equipmentType);
    boolean deleteEquipmentType(int id) throws SQLException;
    boolean updateEquipmentType(EquipmentType equipmentType);
    List<EquipmentType> findAll();
    EquipmentType selectEquipmentTypeById(int id);
}
