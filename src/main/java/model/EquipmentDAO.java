package model;

import java.util.List;

public interface EquipmentDAO {
    void insertEquipment(Equipment equipment);
    boolean deleteEquipment(int itemId, int equipmentTypeId);
    List<Equipment> findAll();
    List<Equipment> findEquipmentByType(int id);
}
