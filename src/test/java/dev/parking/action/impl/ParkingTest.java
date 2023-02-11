package dev.parking.action.impl;

import dev.parking.entity.Car;
import dev.parking.entity.component.Brand;
import dev.parking.entity.component.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParkingTest {
    private Parking parking;
    
    @BeforeEach
    public void init() {
        parking = new Parking(2);
    }

    @Test
    @DisplayName("Припарковать автомобиль на автостоянке")
    public void parkCar() {
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        boolean result = parking.arrivalOfCar(bmwM5);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, parking.getQueue().size());
        result = parking.arrivalOfCar(audiA8);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, parking.getQueue().size());
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        result = parking.arrivalOfCar(mazda6);
        Assertions.assertFalse(result);
        Assertions.assertEquals(1, parking.getQueue().size());
        Assertions.assertFalse(parking.getQueue().isEmptyQueue());
    }

    @Test
    @DisplayName("Выход из очереди, когда автостоянка заполнена и автомобиль помещают в очередь")
    public void exitFromQueue() {
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        boolean result = parking.arrivalOfCar(bmwM5);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, parking.getQueue().size());
        result = parking.arrivalOfCar(audiA8);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, parking.getQueue().size());
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        result = parking.arrivalOfCar(mazda6);
        Assertions.assertFalse(result);
        Assertions.assertEquals(1, parking.getQueue().size());
        boolean resultExitFromQueue = parking.exitQueue(mazda6);
        Assertions.assertTrue(resultExitFromQueue);
        Assertions.assertEquals(0, parking.getQueue().size());
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
    }

    @Test
    @DisplayName("Припарковать автомобиль, встать очередь и выйти из очереди при отъезде автомобиля с парковки")
    public void pullCarFromQueue() {
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        boolean result = parking.arrivalOfCar(bmwM5);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, parking.getQueue().size());
        result = parking.arrivalOfCar(audiA8);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, parking.getQueue().size());
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        result = parking.arrivalOfCar(mazda6);
        Assertions.assertFalse(result);
        Assertions.assertEquals(1, parking.getQueue().size());
        parking.departureOfCar(2);
        Assertions.assertEquals(0, parking.getQueue().size());
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
    }

    @Test
    @DisplayName("Припарковать автомобили и затем выехать с парковки")
    public void freeUpParkingSpace() {
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        boolean result = parking.arrivalOfCar(bmwM5);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, parking.getQueue().size());
        result = parking.arrivalOfCar(audiA8);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, parking.getQueue().size());
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
        parking.departureOfCar(1);
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
        parking.departureOfCar(1);
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
    }

    @Test
    @DisplayName("Добавить в очередь 3 автомобиля")
    public void addInQueueThreeCars() {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        parking.arrivalOfCar(bmwM5);
        parking.arrivalOfCar(audiA8);
        Assertions.assertTrue(parking.getQueue().isEmptyQueue());
        Assertions.assertEquals(0, parking.getQueue().size());
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        parking.arrivalOfCar(volkswagenTaos);
        parking.arrivalOfCar(toyotaYaris);
        parking.arrivalOfCar(mazda6);
        Assertions.assertFalse(parking.getQueue().isEmptyQueue());
        Assertions.assertEquals(3, parking.getQueue().size());
    }
}
