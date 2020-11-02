package org.example.model;

import java.io.Serializable;


public class Equipment implements Serializable {
    int itemId;
    int equipmentTypeId;


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(int equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "itemId=" + itemId +
                ", equipmentTypeId=" + equipmentTypeId +
                '}';
    }
}


