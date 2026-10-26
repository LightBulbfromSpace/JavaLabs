package com.example.autopark_app;

public class Car extends Vehicle {
    private final int passengerCount;

    public Car(String brand, String model, int year, int passengerCount, Engine engine) {
        super(brand, model, year, engine);
        this.passengerCount = passengerCount;
    }

    @Override
    public void move() {
        System.out.println("Легковой автомобиль едет по дороге.");
    }

    public void openTrunk() {
        System.out.println("Багажник автомобиля открыт.");
    }

    public void printPassengerCount() {
        System.out.println("Количество пассажирских мест: " + passengerCount + ".");
    }
}
