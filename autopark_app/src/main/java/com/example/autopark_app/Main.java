package com.example.autopark_app;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Camry", 2022, 5, new Vehicle.Engine(181, "бензиновый"));
        Vehicle motorcycle = new Motorcycle("Yamaha", "MT-07", 2021, false,
                new Vehicle.Engine(73, "бензиновый"));
        Vehicle motorcycleWithSidecar = new Motorcycle("Ural", "Gear Up", 2023, true,
                new Vehicle.Engine(41, "бензиновый"));
        Vehicle truck = new Truck("Volvo", "FH", 2020, 20.0, new Vehicle.Engine(500, "дизельный"));

        Vehicle demonstrationVehicle = new Vehicle(
                "Prototype", "Concept", 2024, new Vehicle.Engine(100, "электрический")) {
            @Override
            public void move() {
                System.out.println("Анонимное транспортное средство движется бесшумно.");
            }
        };

        Vehicle[] vehicles = {car, motorcycle, motorcycleWithSidecar, truck, demonstrationVehicle};

        for (Vehicle vehicle : vehicles) {
            vehicle.printInfo();
            vehicle.move();

            // Проверка instanceof выполняется до нисходящего преобразования.
            if (vehicle instanceof Car) {
                Car specificCar = (Car) vehicle;
                specificCar.openTrunk();
                specificCar.printPassengerCount();
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle specificMotorcycle = (Motorcycle) vehicle;
                specificMotorcycle.doWheelie();
            } else if (vehicle instanceof Truck) {
                Truck specificTruck = (Truck) vehicle;
                specificTruck.loadCargo(5.0);
            }

            System.out.println();
        }

        // Car invalid = (Car) motorcycle; // При выполнении возникнет ClassCastException.
        // Сначала нужно проверить тип через instanceof, как в цикле выше.
    }
}
