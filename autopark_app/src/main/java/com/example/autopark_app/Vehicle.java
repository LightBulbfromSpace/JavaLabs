package com.example.autopark_app;

public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
    private final Engine engine;

    protected Vehicle(String brand, String model, int year, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    // final запрещает классам-наследникам переопределять вывод основной информации.
    public final void printInfo() {
        System.out.println("Транспортное средство: " + brand + " " + model + ", год выпуска: " + year);
        engine.printEngineInfo();
    }

    public abstract void move();

    public static final class Engine {
        private final int power;
        private final String type;

        public Engine(int power, String type) {
            this.power = power;
            this.type = type;
        }

        public void printEngineInfo() {
            System.out.println("Двигатель: " + type + ", мощность: " + power + " л.с.");
        }
    }
}
