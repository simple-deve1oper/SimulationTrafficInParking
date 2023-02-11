package dev.parking.entity.component;

import java.util.StringJoiner;

/**
 * Перечисление для описания автомобильной марки
 * @version 1.0
 */
public enum Brand {
    AUDI("Audi"), BMW("BMW"), MAZDA("Mazda"), TOYOTA("Toyota"), CHEVROLET("Chevrolet"),
    VOLKSWAGEN("Volkswagen");

    private String name;    // наименование

    /**
     * Конструктор для перечисления типа Brand
     * @param name - наименование
     */
    Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}")
                .add("name=" + name).toString();
    }
}
