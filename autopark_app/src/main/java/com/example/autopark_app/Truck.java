package com.example.autopark_app;

public class Truck extends Vehicle {
    private final double maxLoad;

    public Truck(String brand, String model, int year, double maxLoad, Engine engine) {
        super(brand, model, year, engine);
        this.maxLoad = maxLoad;
    }

    @Override
    public void move() {
        System.out.println("Грузовой автомобиль перевозит груз по дороге.");
    }

    public void loadCargo(double weight) {
        if (weight <= 0 || weight > maxLoad) {
            System.out.println("Невозможно загрузить " + weight + " т: допустимая нагрузка — до " + maxLoad + " т.");
            return;
        }

        System.out.println("Загружен груз весом " + weight + " т.");
    }
}
