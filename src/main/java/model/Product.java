package model;

import java.io.Serializable;

/**
 * Класс описывает свойства отдельного продукта питания в походе
 */
public class Product implements Serializable {
    int id;
    String name;
    float weight;
    float calories;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
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
        return "Product{" +
                "id=" + id +
                ", Наименование='" + name + '\'' +
                ", Вес=" + weight +
                ", Калории=" + calories +
                ", Белки=" + proteins +
                ", Жиры=" + fats +
                ", Углеводы=" + carbohydrates +
                ", Дополнительные сведения='" + description + '\'' +
                '}';
    }
}
