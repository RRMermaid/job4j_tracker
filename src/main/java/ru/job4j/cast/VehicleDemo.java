package ru.job4j.cast;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Airplane();
        vehicles[1] = new Train();
        vehicles[2] = new Bus();

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}