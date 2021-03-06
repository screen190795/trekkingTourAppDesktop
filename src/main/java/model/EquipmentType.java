package model;

import java.io.Serializable;


/**
 * Класс описывает тип экипировки (по способу передвижения, сезону и т.д.)
 */
public class EquipmentType implements Serializable {

    int id;
    String name;
    //Максимально допустимый общий вес снаряжения в наборе
    int maxWeight;
    //Назначение набора
    String purpose;
    String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "Наименование='" + name + '\'' +
                ", Вес, max=" + maxWeight +
                ", Назначение='" + purpose + '\'' +
                ", Дополнительные сведения='" + description + '\'' +
                '}';
    }
}
