package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        final String question = input.nextLine();
        final int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                System.out.println("Да.");
                break;
            case 1:
                System.out.println("Нет.");
                break;
            default:
                System.out.println("Может быть.");
        }
    }
}

