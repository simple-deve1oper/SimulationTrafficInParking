package dev.parking.entity;

import dev.parking.entity.component.Brand;
import dev.parking.entity.component.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final Car car = new Car(1, Brand.BMW, "M5", Color.BLACK);

    @Test
    @DisplayName("Сравнение объекта с константными значениями")
    public void comparisonWithConstants() {
        long id = 1;
        Brand brand = Brand.BMW;
        String model = "M5";
        Color color = Color.BLACK;

        Assertions.assertTrue(
                (car.getId() == id) &&
                (car.getBrand() == brand) &&
                        car.getModel().equals(model) &&
                        (car.getColor() == color)
        );
    }

    @Test
    @DisplayName("Сравнение с идентичным объектом")
    public void comparisonWithAnIdenticalObject() {
        Car copyCar = new Car(1, Brand.BMW, "M5", Color.BLACK);

        Assertions.assertTrue(
                (car.getId() == copyCar.getId()) &&
                (car.getBrand() == copyCar.getBrand()) &&
                        car.getModel().equals(copyCar.getModel()) &&
                        (car.getColor() == copyCar.getColor())
        );
        Assertions.assertTrue(car.equals(copyCar));
    }

    @Test
    @DisplayName("Сравнение с объектом, у которого другие значения")
    public void comparisonWithAnotherObject() {
        Car audi = new Car(48, Brand.AUDI, "A8", Color.WHITE);

        Assertions.assertFalse(
                (car.getId() == audi.getId()) &&
                (car.getBrand() == audi.getBrand()) &&
                        car.getModel().equals(audi.getModel()) &&
                        (car.getColor() == audi.getColor())
        );
        Assertions.assertFalse(car.equals(audi));
    }

    @Test
    @DisplayName("Сравнение с клонируемым объектом")
    public void comparisonWithClonedObject() {
        Car cloneCar;
        try {
            cloneCar = car.clone();

            Assertions.assertTrue(
                    (car.getId() == cloneCar.getId()) &&
                    (car.getBrand() == cloneCar.getBrand()) &&
                            car.getModel().equals(cloneCar.getModel()) &&
                            (car.getColor() == cloneCar.getColor())
            );
            Assertions.assertTrue(car.equals(cloneCar));

            cloneCar.setColor(Color.GRAY);
            Assertions.assertEquals(Color.GRAY, cloneCar.getColor());
            Assertions.assertNotEquals(Color.GRAY, car.getColor());
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
    }
}
