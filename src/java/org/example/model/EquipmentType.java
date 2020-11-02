package org.example.model;

import java.io.Serializable;

public class EquipmentType implements Serializable {

    int id;
    String name;
    int maxWeight;
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
        return "EquipmentType{" +
                "id=" + id +
                ", Наименование='" + name + '\'' +
                ", Вес, норма=" + maxWeight +
                ", Назначение='" + purpose + '\'' +
                ", Дополнительные сведения='" + description + '\'' +
                '}';
    }
}
