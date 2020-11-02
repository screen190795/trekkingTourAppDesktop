package org.example.model;

import javax.sql.RowSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface EquipmentTypeDAO {
    void insertEquipmentType(EquipmentType equipmentType);
    boolean deleteEquipmentType(int id) throws SQLException;
    boolean updateEquipmentType(EquipmentType equipmentType);
    List<EquipmentType> findAll();
    EquipmentType selectEquipmentTypeById(int id);
}
