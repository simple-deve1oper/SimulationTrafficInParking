package dev.parking.action.impl;

import dev.parking.entity.Car;
import dev.parking.entity.component.Brand;
import dev.parking.entity.component.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueCarsTest {
    private QueueCars queue;
    
    @BeforeEach
    public void init() {
        queue = new QueueCars();
    }

    @Test
    @DisplayName("Добавление автомобилей в очередь")
    public void addingCarsInQueue() {
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        queue.addInQueue(volkswagenTaos);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        queue.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, queue.size());
        Car chevroletCamaro = new Car(6, Brand.CHEVROLET, "Camaro", Color.YELLOW);
        queue.addInQueue(chevroletCamaro);
        Assertions.assertEquals(3, queue.size());
    }

    @Test
    @DisplayName("Добавление автомобиля в очередь, если такой уже там существует")
    public void addingCarInQueueIfExists() {
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        queue.addInQueue(volkswagenTaos);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        queue.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, queue.size());
        queue.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    @DisplayName("Удаление автомобилей из очереди")
    public void removeCarInQueue() {
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        queue.addInQueue(volkswagenTaos);
        queue.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, queue.size());
        queue.exitFromQueue(toyotaYaris);
        Assertions.assertEquals(1, queue.size());
    }

    @Test
    @DisplayName("Удаление автомобиля из очереди, если такой там не сущесивует")
    public void removeCarInQueueIfNotExists() {
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        queue.addInQueue(volkswagenTaos);
        queue.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, queue.size());
        Car chevroletCamaro = new Car(6, Brand.CHEVROLET, "Camaro", Color.YELLOW);
        queue.exitFromQueue(chevroletCamaro);
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    @DisplayName("Получение следующего автомобиля из очереди")
    public void pullCarsFromQueue() {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        queue.addInQueue(bmwM5);
        queue.addInQueue(audiA8);
        queue.addInQueue(volkswagenTaos);
        queue.addInQueue(mazda6);
        queue.addInQueue(toyotaYaris);

        Car temp = queue.pullCar();
        Assertions.assertTrue(temp.equals(bmwM5));
        temp = queue.pullCar();
        Assertions.assertTrue(temp.equals(audiA8));
        temp = queue.pullCar();
        Assertions.assertTrue(temp.equals(volkswagenTaos));
    }

    @Test
    @DisplayName("Проверка наличия автомобиля в очереди")
    public void checkingForExistenceOfCarInQueue() {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        queue.addInQueue(bmwM5);
        queue.addInQueue(audiA8);
        queue.addInQueue(volkswagenTaos);
        Assertions.assertTrue(queue.checkingCarInTheQueue(audiA8));
    }

    @Test
    @DisplayName("Проверка на пустоту очереди")
    public void checkingForEmptyQueue() {
        Assertions.assertTrue(queue.isEmptyQueue());
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        queue.addInQueue(bmwM5);
        Assertions.assertFalse(queue.isEmptyQueue());
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        queue.addInQueue(audiA8);
        queue.addInQueue(volkswagenTaos);
        Assertions.assertFalse(queue.isEmptyQueue());
    }
}
