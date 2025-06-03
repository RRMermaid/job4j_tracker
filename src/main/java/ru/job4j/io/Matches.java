package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;

        while (count > 0) {
            final String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + ", введите число от 1 до 3:");

            final int matches = Integer.parseInt(input.nextLine());

            if (matches >= 1 && matches <= 3 && matches <= count) {
                count -= matches;

                if (count == 0) {
                    System.out.println("Выиграл " + player);
                } else {
                    turn = !turn;
                }

            } else {
                if (matches < 1 || matches > 3) {
                    System.out.println("Ошибка: введите число от 1 до 3.");
                } else if (matches > count) {
                    System.out.println("Ошибка: нельзя взять больше, чем осталось ("
                            + count + ").");
                }
            }
        }
    }
}