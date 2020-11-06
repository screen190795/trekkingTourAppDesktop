package model;

import java.io.Serializable;


/**
 * Класс описывает отдельный набор экипировки
 */
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
        return "Элемент набора:" +
                "itemId=" + itemId +
                ", equipmentTypeId=" + equipmentTypeId;
    }
}



