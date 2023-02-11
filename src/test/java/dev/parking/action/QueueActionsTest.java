package dev.parking.action;

import dev.parking.action.impl.QueueCars;
import dev.parking.entity.Car;
import dev.parking.entity.component.Brand;
import dev.parking.entity.component.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueActionsTest {
    private QueueActions actions;

    @BeforeEach
    public void init() {
        actions = new QueueCars();
    }

    @Test
    @DisplayName("Добавление автомобилей в очередь")
    public void addingCarsInQueue() {
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        actions.addInQueue(volkswagenTaos);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        actions.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, actions.size());
        Car chevroletCamaro = new Car(6, Brand.CHEVROLET, "Camaro", Color.YELLOW);
        actions.addInQueue(chevroletCamaro);
        Assertions.assertEquals(3, actions.size());
    }

    @Test
    @DisplayName("Добавление автомобиля в очередь, если такой уже там существует")
    public void addingCarInQueueIfExists() {
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        actions.addInQueue(volkswagenTaos);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        actions.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, actions.size());
        actions.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, actions.size());
    }

    @Test
    @DisplayName("Удаление автомобилей из очереди")
    public void removeCarInQueue() {
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        actions.addInQueue(volkswagenTaos);
        actions.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, actions.size());
        actions.exitFromQueue(toyotaYaris);
        Assertions.assertEquals(1, actions.size());
    }

    @Test
    @DisplayName("Удаление автомобиля из очереди, если такой там не сущесивует")
    public void removeCarInQueueIfNotExists() {
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        actions.addInQueue(volkswagenTaos);
        actions.addInQueue(toyotaYaris);
        Assertions.assertEquals(2, actions.size());
        Car chevroletCamaro = new Car(6, Brand.CHEVROLET, "Camaro", Color.YELLOW);
        actions.exitFromQueue(chevroletCamaro);
        Assertions.assertEquals(2, actions.size());
    }

    @Test
    @DisplayName("Получение следующего автомобиля из очереди")
    public void pullCarsFromQueue() {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        actions.addInQueue(bmwM5);
        actions.addInQueue(audiA8);
        actions.addInQueue(volkswagenTaos);
        actions.addInQueue(mazda6);
        actions.addInQueue(toyotaYaris);

        Car temp = actions.pullCar();
        Assertions.assertTrue(temp.equals(bmwM5));
        temp = actions.pullCar();
        Assertions.assertTrue(temp.equals(audiA8));
        temp = actions.pullCar();
        Assertions.assertTrue(temp.equals(volkswagenTaos));
    }

    @Test
    @DisplayName("Проверка наличия автомобиля в очереди")
    public void checkingForExistenceOfCarInQueue() {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        actions.addInQueue(bmwM5);
        actions.addInQueue(audiA8);
        actions.addInQueue(volkswagenTaos);
        Assertions.assertTrue(actions.checkingCarInTheQueue(audiA8));
    }

    @Test
    @DisplayName("Проверка на пустоту очереди")
    public void checkingForEmptyQueue() {
        Assertions.assertTrue(actions.isEmptyQueue());
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        actions.addInQueue(bmwM5);
        Assertions.assertFalse(actions.isEmptyQueue());
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        actions.addInQueue(audiA8);
        actions.addInQueue(volkswagenTaos);
        Assertions.assertFalse(actions.isEmptyQueue());
    }
}
