package dev.parking.util;

import dev.parking.entity.Car;

/**
 * Класс для форматирования объекта в строку
 * @version 1.0
 */
public class FormattingObject {
    /**
     * Метод для перевода объекта автомобиля в отформатированную строку
     * @param car - автомобиль
     * @return отформатированная строка
     */
    public static String getFormatCarToString(Car car) {
        return String.format("Автомобиль %s %s %s с идентификатором %d", car.getColor().getName(),
                car.getBrand().getName(), car.getModel(), car.getId());
    }
}
