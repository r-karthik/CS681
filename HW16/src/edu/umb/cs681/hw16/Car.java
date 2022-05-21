package edu.umb.cs681.hw16;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private int mileage;
    private int year;
    private int price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, int price, int dominationCount) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.dominationCount = dominationCount;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }
    public static void main(String[] args) {

        ArrayList<Car> numberOfCars = new ArrayList();
        numberOfCars.add(new Car("Bugatti", "Veyron", 2021, 3, 500000, 1));
        numberOfCars.add(new Car("Mustang", "Boss", 1969, 9, 25000, 4));
        numberOfCars.add(new Car("Tesla", "Roadster", 2022, 600, 200000, 2));
        numberOfCars.add(new Car("BMW", "4 Series", 2021, 30, 45000, 3));
        int highestPrice = numberOfCars.stream().parallel().map((Car car) ->car.getPrice() ).reduce(0, (ans,price)->ans > price ? ans : price);
        System.out.println("Costliest Price of a car is: " + highestPrice);

        int lowestPrice = numberOfCars.stream().parallel().map((Car car) ->car.getPrice() ).reduce(1000000000, (ans, price)->price>ans ? ans : price);
        System.out.println("Cheapest Car Price is: " + lowestPrice);

        int averagePrice = numberOfCars.stream().parallel().map((Car car) ->car.getPrice() ).reduce(0, (ans,price) -> ans+price, (finalAnswer, answer) -> finalAnswer)/numberOfCars.size();
        System.out.println("Mean Price of the car is: " + averagePrice);
    }
}