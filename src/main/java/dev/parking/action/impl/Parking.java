package dev.parking.action.impl;

import dev.parking.action.ParkingActions;
import dev.parking.entity.Car;
import dev.parking.util.FormattingObject;
import dev.parking.util.MotionSimulation;

import java.util.*;

/**
 * Класс для описания автостоянки
 * @version 1.0
 */
public class Parking implements ParkingActions {
    private int numberParkingSpaces;            // количество парковочных мест
    private Map<Integer, Car> placesForCars;    // места для автомобилей
    private QueueCars queue;                    // очередь автомобилей

    /**
     * Конструктор для создания нового объекта типа Parking
     * @param numberParkingSpaces - количество всего мест на автостоянке
     */
    public Parking(int numberParkingSpaces) {
        this.numberParkingSpaces = numberParkingSpaces;
        this.placesForCars = new TreeMap<>();
        this.queue = new QueueCars();
    }

    @Override
    public boolean arrivalOfCar(Car car) {
        if (queue.checkingCarInTheQueue(car)) {
            System.out.println("Вы стоите в очереди. Когда освободится парковочное место и очередь дойдет до вас, " +
                    "то вы сможете встать на парковочное место");
            return false;
        }

        if (checkingForAvailableSeats()) {
            int number = getParkingSpaceNumber();
            MotionSimulation.parkingTraffic(car, number);
            placesForCars.put(number, car);
            return true;
        } else {
            System.out.println("На данный момент свободных парковочных мест на автостоянке нет");
            queue.addInQueue(car);
            return false;
        }
    }

    @Override
    public void departureOfCar(int number) {
        if (number > numberParkingSpaces) {
            System.out.println("Парковочного места с таким номером не существует");
        } else if (!placesForCars.containsKey(number)) {
            System.out.println("Парковочное место под таким номером пустое");
        } else {
            Car car = placesForCars.get(number);
            placesForCars.remove(number);
            String descriptionCar = FormattingObject.getFormatCarToString(car);
            System.out.println(descriptionCar + " покинул стоянку");
            System.out.println("Парковочное место под номером " + number + " свободно");

            if (!queue.isEmptyQueue()) {
                car = queue.pullCar();
                arrivalOfCar(car);
            }
        }
    }

    @Override
    public boolean exitQueue(Car car) {
        if (!queue.checkingCarInTheQueue(car)) {
            return false;
        }
        return queue.exitFromQueue(car);
    }

    /**
     * Метод для получения номера свободного парковочного места
     * @return номер свободного парковочного места
     */
    private int getParkingSpaceNumber() {
        for (int i = 1; i <= numberParkingSpaces; i++) {
            if (!placesForCars.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Метод для проверки наличия свободных мест на стоянке
     * @return результат свободного места на автостоянке
     */
    private boolean checkingForAvailableSeats() {
        if (placesForCars.size() == numberParkingSpaces) {
            return false;
        }
        return true;
    }

    public int getNumberParkingSpaces() {
        return numberParkingSpaces;
    }
    public void setNumberParkingSpaces(int numberParkingSpaces) {
        this.numberParkingSpaces = numberParkingSpaces;
    }
    public Map<Integer, Car> getPlacesForCars() {
        return Map.copyOf(placesForCars);
    }
    public QueueCars getQueue() {
        return queue;
    }
}
