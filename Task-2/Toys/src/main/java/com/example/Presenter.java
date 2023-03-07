package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import com.example.Data.LotsOfToys;

public class Presenter {
    private LotsOfToys lotsOfToys;
    private Viever viever;

    public Presenter(LotsOfToys lotsOfToys, Viever viever) {
        this.lotsOfToys = lotsOfToys;
        this.viever = viever;
    }

    public void Run() {
        int number;
        Boolean run = true;
        while (run) {
            number = viever.printMenu();
            switch (number) {
                // Играть
                case 1:
                    while (true) {
                        viever.print(lotsOfToys.toString());
                        number = viever.game(lotsOfToys.getNumberList());
                        if (number == 0) {
                            break;
                        }
                        if (tryGetToy(lotsOfToys.getChanceToy(number))) {
                            viever.win(lotsOfToys.getNameToy(number));
                            lotsOfToys.setQuantityToy(number);
                            try (FileWriter writer = new FileWriter("notes3.txt", true)) {
                                // запись всей строки
                                String text = lotsOfToys.getNameToy(number);
                                writer.write(text + "\n");

                                writer.flush();
                            } catch (IOException ex) {

                                System.out.println(ex.getMessage());
                            }
                        } else {
                            viever.lost(lotsOfToys.getNameToy(number));
                        }
                    }
                    break;

                // Добавлять
                case 2:
                    String nameToy = viever.getNameToy();
                    int quantityToy = viever.getQuantityToy();
                    int chanceToy = viever.getChanceToy();
                    lotsOfToys.addNewToy(lotsOfToys.getSize() + 1, nameToy, quantityToy, chanceToy);
                    break;
                // Выход
                case 0:
                    run = false;
                    break;

            }
        }
    }

    public int attempt() {
        int temp = ThreadLocalRandom.current().nextInt(101);
        System.out.println(temp);
        return temp;
    }

    public Boolean tryGetToy(int chanceToy) {
        if (chanceToy >= attempt()) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }
}
