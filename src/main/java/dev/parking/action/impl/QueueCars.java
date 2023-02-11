package dev.parking.action.impl;

import dev.parking.action.QueueActions;
import dev.parking.entity.Car;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс-оболочка для структуры данных очереди Deque чтобы хранить автомобили
 * @version 1.0
 */
public class QueueCars implements QueueActions {
    private Deque<Car> queue;   // очередь автомобилей

    /**
     * Конструктор для создания нового объекта типа QueueCars
     */
    public QueueCars() {
        this.queue = new ArrayDeque<>();
    }


    @Override
    public boolean addInQueue(Car car) {
        if (checkingCarInTheQueue(car)) {
            return false;
        }
        return queue.add(car);
    }

    @Override
    public boolean exitFromQueue(Car car) {
        if (!checkingCarInTheQueue(car)) {
            return false;
        }
        return queue.remove(car);
    }

    @Override
    public Car pullCar() {
        return queue.removeFirst();
    }

    @Override
    public boolean isEmptyQueue() {
        return queue.isEmpty();
    }

    @Override
    public boolean checkingCarInTheQueue(Car car) {
        return queue.contains(car);
    }

    @Override
    public int size() {
        return queue.size();
    }
}
