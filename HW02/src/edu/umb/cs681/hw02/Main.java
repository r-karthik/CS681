package edu.umb.cs681.hw02;

import java.util.ArrayList;


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

        double minimum = cars.stream().mapToDouble(Car::getPrice).min().getAsDouble();
        System.out.println("Minimum price of the car: " + minimum);

        double maximum= cars.stream().mapToDouble(Car::getPrice).max().getAsDouble();
        System.out.println("Maximum price of the car: " + maximum);


        int averagePrice = cars.stream().map(Car::getPrice).reduce(new int[2], (result, price) ->{
            double average = Math.round((result[0] * result[1] + price)/(result[0]+1));
            result[0]++;
            result[1] = (int) average;
            return result;},(finalResult, intermediateResult) -> finalResult)[1];

        System.out.println("Average price of all the cars: " + averagePrice);

    }
}
