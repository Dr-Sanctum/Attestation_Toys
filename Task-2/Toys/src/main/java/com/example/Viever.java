package com.example;

import java.util.Collection;
import java.util.Scanner;

public class Viever {
    Scanner scanner = new Scanner(System.in, "cp866");

    public void print(String text) {
        System.out.println(text);
    }

    public int printMenu() {
        int number;
        while (true) {
            System.out.println("Выберите пункт Меню:\n 1.Играть.\n 2.Добавить новыую игрушку\n 0.Выход");
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number >= 0 && number <= 2) {
                    if (number == 0) {
                        scanner.close();
                    }
                    return number;
                } else {
                    System.out.println("Неверный номер меню");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный номер меню");
                continue;
            }
        }
    }

    public int game(Collection<Integer> listNumberToy) {
        System.out.println("Выберите игрушку, которую хотите достать, по номеру (0 - выход в меню)");

        int number;
        while (true) {
            if (listNumberToy.size() == 0) {
                scanner.close();
                System.out.println("Игрушки кончились!");
                return 0;
            }
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный номер игрушки");
                continue;
            }
            if (listNumberToy.contains(number)) {
                return number;
            } else if (number == 0) {
                return 0;
            } else {
                System.out.println("Неверный номер игрушки");
            }
        }
    }

    public String getNameToy() {

        System.out.println("Введите имя игрушки ");
        return scanner.nextLine();
    }

    public int getQuantityToy() {
        int number;
        while (true) {
            System.out.println("Введите количество");
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Некорректный ввод");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
                continue;
            }
        }
    }

    public int getChanceToy() {
        int number;
        while (true) {
            System.out.println("Введите шанс получения (0-100)");
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number >= 0 && number <= 100) {
                    return number;
                } else {
                    System.out.println("Некорректный ввод");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
                continue;
            }
        }
    }

    public void win(String nameToy) {
        System.out.println("Вы вытащили - " + nameToy);
    }

    public void lost(String nameToy) {
        System.out.println("Не получилось вытащить - " + nameToy);
    }

}
