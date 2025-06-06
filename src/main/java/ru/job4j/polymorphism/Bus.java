package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В автобусе " + count + " пассажиров.");
    }

    @Override
    public int refuel(int fuel) {
        System.out.println("Заправлено " + fuel + " литров топлива в автобус.");
        return fuel;
    }
}