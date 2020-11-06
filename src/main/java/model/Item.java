package model;

import java.io.Serializable;


/**
 * Класс описывает элементы экипировки
 */
public class Item implements Serializable {
    int id;
    String name;
    float weight;
    float volume;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", Наименование='" + name + '\'' +
                ", Вес=" + weight +
                ", Объем=" + volume +
                ", Описание='" + description + '\'' +
                '}';
    }
}
