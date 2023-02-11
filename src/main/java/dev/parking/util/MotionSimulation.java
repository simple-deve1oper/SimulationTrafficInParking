package dev.parking.util;

import dev.parking.entity.Car;

/**
 * Класс для описания моделирования движения
 * @version 1.0
 */
public class MotionSimulation {
    /**
     * Метод для моделирования движения по парковке
     * @param car - автомобиль
     * @param number - номер парковочного места
     */
    public static void parkingTraffic(Car car, int number) {
        String descriptionCar = FormattingObject.getFormatCarToString(car);
        System.out.println(descriptionCar + " заезжает на автостоянку");

        if (number != 1) {
            for (int i = 1; i < number; i++) {
                System.out.println("Автомобиль едет вправо к " + i + " парковочному месту. Оно занято...");
            }
        }
        System.out.println("Парковочное место под номером " + number + " свободно");
        System.out.println(descriptionCar + " занял место на автостоянке под номером " + number);
    }
}
