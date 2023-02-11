package dev.parking.entity.component;

import java.util.StringJoiner;

/**
 * Класс для описания цвета
 * @version 1.0
 */
public enum Color {
    RED("Красный"), WHITE("Белый"), BLACK("Чёрный"), YELLOW("Жёлтый"), GRAY("Серый");

    private String name;    // наименование

    /**
     * Конструктор для перечисления типа Color
     * @param name - наименование
     */
    Color(String name) {
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
