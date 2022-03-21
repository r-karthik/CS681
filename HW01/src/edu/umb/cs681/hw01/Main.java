package edu.umb.cs681.hw01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();

        Car car1 = new Car("Mitsubishi","OutLander", 2019, 18, 40000);
        Car car2 = new Car("Tesla", "Roadster", 2022, 420, 200000);
        Car car3 = new Car("Tesla", "Model 3", 2021, 400, 70000);
        Car car4 = new Car("Bentley","Continental GT", 2018, 5, 202500);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        cars.forEach((Car car) -> car.setDominationCount(cars));

        List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());

        System.out.println("Sorted by Price:");
        sortByPrice.forEach((Car car) -> System.out.println( car.getMake() + "-"+car.getModel() + ": " + car.getPrice()));

        List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());
        System.out.println("\nSorted by Year:");
        sortByYear.forEach((Car car) -> System.out.printf("%4s-%s :%6d \n", car.getMake(),car.getModel(), car.getYear()));

        List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage)).collect(Collectors.toList());
        System.out.println("\nSorted by Mileage:");
        sortByMileage.forEach((Car car) -> System.out.println(car.getMake() + "-"+car.getModel() + ": " + car.getMileage()));

        List<Car> sortByDomination = cars.stream().sorted(Comparator.comparing(Car::getDominationCount)).collect(Collectors.toList());
        System.out.println("\nSorted by Domination:");
        sortByDomination.forEach((Car car) -> System.out.println(car.getMake() + "-"+car.getModel() + ": "+ car.getDominationCount()));

    }
}
