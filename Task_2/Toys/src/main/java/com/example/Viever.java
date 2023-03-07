package com.example;

import java.util.Collection;
import java.util.Scanner;

public class Viever {
    public void print(String text) {
        System.out.println(text);
    }

    public int printMenu(Collection<Integer> listNumberToy) {

        System.out.println("Выберите игрушку, которую хотите достать, по номеру");
        Scanner scanner = new Scanner(System.in, "cp866");
        while (true) {
            int number = Integer.parseInt(scanner.nextLine());
            if (listNumberToy.contains(number)) {
                scanner.close();
                return number;
            } else {
                System.out.println("Неверный номер игрушки");
            }
        }
    }
}
