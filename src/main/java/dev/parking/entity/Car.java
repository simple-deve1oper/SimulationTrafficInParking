package dev.parking.entity;

import dev.parking.entity.component.Brand;
import dev.parking.entity.component.Color;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Класс для описания автомобиля
 * @version 1.0
 */
public class Car implements Cloneable, Serializable {
    private long id;        // идентификатор автомобиля
    private Brand brand;    // марка автомобиля
    private String model;   // модель автомобиля
    private Color color;    // цвет автомобиля

    /**
     * Конструктор для создания нового объекта типа Car
     * @param brand - марка автомобиля
     * @param model - модель автомобиля
     * @param color - цвет автомобиля
     */
    public Car(long id, Brand brand, String model, Color color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car car = (Car) super.clone();
        return car;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != this.getClass()) return false;
        Car car = (Car) obj;
        return (id == car.id) && (brand == car.brand) && (model == car.model || (model != null && model.equals(car.model))) &&
                (color == car.color);
    }

    @Override
    public int hashCode() {
        return (int)(31 * 1 + id + (brand == null ? 0 : brand.hashCode()) + (model == null ? 0 : model.hashCode()) +
                (color == null ? 0 : color.hashCode()));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}")
                .add("id=" + id).add("brand=" + brand.toString()).add("model=" + model)
                .add("color=" + color).toString();
    }
}
