package com.example.autopark_app;

public class Motorcycle extends Vehicle {
    private final boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar, Engine engine) {
        super(brand, model, year, engine);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void move() {
        System.out.println("Мотоцикл едет по дороге.");
    }

    public void doWheelie() {
        if (hasSidecar) {
            System.out.println("Мотоцикл с коляской не может безопасно выполнить вилли.");
        } else {
            System.out.println("Мотоциклист выполняет вилли.");
        }
    }
}
