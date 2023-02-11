package dev.parking.action;

import dev.parking.action.impl.Parking;
import dev.parking.entity.Car;
import dev.parking.entity.component.Brand;
import dev.parking.entity.component.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParkingActionsTest {
    private ParkingActions actions;

    @BeforeEach
    public void init() {
        actions = new Parking(2);
    }

    @Test
    @DisplayName("Припарковать автомобиль на автостоянке")
    public void parkCar() {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        boolean result = actions.arrivalOfCar(bmwM5);
        Assertions.assertTrue(result);
        result = actions.arrivalOfCar(audiA8);
        Assertions.assertTrue(result);
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        result = actions.arrivalOfCar(mazda6);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Выход из очереди, когда автостоянка заполнена и автомобиль помещают в очередь")
    public void exitFromQueue() {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        boolean result = actions.arrivalOfCar(bmwM5);
        Assertions.assertTrue(result);
        result = actions.arrivalOfCar(audiA8);
        Assertions.assertTrue(result);
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        result = actions.arrivalOfCar(mazda6);
        Assertions.assertFalse(result);
        boolean resultExitFromQueue = actions.exitQueue(mazda6);
        Assertions.assertTrue(resultExitFromQueue);
    }

    @Test
    @DisplayName("Припарковать автомобиль, встать очередь и выйти из очереди при отъезде автомобиля с парковки")
    public void pullCarFromQueue() {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        boolean result = actions.arrivalOfCar(bmwM5);
        Assertions.assertTrue(result);
        result = actions.arrivalOfCar(audiA8);
        Assertions.assertTrue(result);
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        result = actions.arrivalOfCar(mazda6);
        Assertions.assertFalse(result);
        actions.departureOfCar(2);
    }
}
