package model;

import java.io.Serializable;

public class ProductMenuType implements Serializable {
    int id;
    String name;
    int weight;
    int calories;
    float proteins;
    float fats;
    float carbohydrates;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "ProductMenuType{" +
                "id=" + id +
                ", Наименование='" + name + '\'' +
                ", Вес=" + weight +
                ", Калории, норма" + calories +
                ", Белки, норма=" + proteins +
                ", Жиры,норма=" + fats +
                ", Углеводы, норма=" + carbohydrates +
                ", Дополнительные сведения='" + description + '\'' +
                '}';
    }
}
