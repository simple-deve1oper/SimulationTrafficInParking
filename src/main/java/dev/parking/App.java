package dev.parking;

import dev.parking.action.impl.Parking;
import dev.parking.entity.Car;
import dev.parking.entity.component.Brand;
import dev.parking.entity.component.Color;
import dev.parking.util.FormattingObject;

import java.util.Map;

/**
 * Главный класс для запуска приложения
 * @version 1.0
 */
public class App {
    public static void main(String[] args) {
        // автостоянка на 5 автомобилей
        System.out.println("Создание автостоянки на 5 мест");
        Parking parking = new Parking(5);
        System.out.println("Размер очереди: " + parking.getQueue().size());
        System.out.println("----------------");
        // заполнение автостоянки автомобилями
        System.out.println("Заполнение автостоянки автомобилями:");
        fillParking(parking);
        System.out.println("Размер очереди: " + parking.getQueue().size());
        System.out.println("----------------");
        // добавление в очередь
        Car volkswagenGolf = new Car(15, Brand.VOLKSWAGEN, "Golf", Color.GRAY);
        Car audiQ5 = new Car(67, Brand.AUDI, "Q5", Color.RED);
        System.out.println("Добавление автомобилей в очередь:");
        System.out.print(FormattingObject.getFormatCarToString(volkswagenGolf) + ": ");
        parking.arrivalOfCar(volkswagenGolf);
        System.out.println("-");
        System.out.print(FormattingObject.getFormatCarToString(audiQ5) + ": ");
        parking.arrivalOfCar(audiQ5);
        System.out.println("-");
        System.out.println("Размер очереди: " + parking.getQueue().size());
        System.out.println("----------------");
        // отъезд машины с парковки
        System.out.println("Отъезд автомобиля с парковки");
        parking.departureOfCar(4);
        System.out.println("Размер очереди: " + parking.getQueue().size());
        System.out.println("----------------");
        // досрочный выход из очереди
        System.out.println("Досрочный выход из очереди");
        parking.exitQueue(audiQ5);
        System.out.println(FormattingObject.getFormatCarToString(audiQ5) + " досрочно вышел из очереди");
        System.out.println("Размер очереди: " + parking.getQueue().size());
        System.out.println("----------------");
        System.out.println("Вывод автомобилей на автостоянке: ");
        printCars(parking.getPlacesForCars());
        System.out.println("----------------");
        System.out.println("Освобождение автостоянки: ");
        freeUpParking(parking);
        System.out.println("Парковка пуста: " + parking.getPlacesForCars().isEmpty());
    }

    /**
     * Метод для заполнения автостоянки объектами типа Car
     * @param parking - автостоянка
     */
    private static void fillParking(Parking parking) {
        Car bmwM5 = new Car(1, Brand.BMW, "M5", Color.WHITE);
        Car audiA8 = new Car(2, Brand.AUDI, "A8", Color.RED);
        Car volkswagenTaos = new Car(3, Brand.VOLKSWAGEN, "Taos", Color.GRAY);
        Car toyotaYaris = new Car(4, Brand.TOYOTA, "Yaris", Color.RED);
        Car mazda6 = new Car(5, Brand.MAZDA, "6", Color.GRAY);
        parking.arrivalOfCar(bmwM5);
        System.out.println("-");
        parking.arrivalOfCar(audiA8);
        System.out.println("-");
        parking.arrivalOfCar(volkswagenTaos);
        System.out.println("-");
        parking.arrivalOfCar(toyotaYaris);
        System.out.println("-");
        parking.arrivalOfCar(mazda6);
        System.out.println("-");
    }

    /**
     * Метод для вывода информации о машинах, которые находятся на автостоянке
     * @param carMap - карта с автомобилями
     */
    private static void printCars(Map<Integer, Car> carMap) {
        carMap.forEach((k, v) -> System.out.println(k + " " + v));
    }

    /**
     * Метод для освобождения автостоянки
     * @param parking - автостоянка
     */
    private static void freeUpParking(Parking parking) {
        parking.getPlacesForCars().forEach((k, v) -> parking.departureOfCar(k));
    }
}
