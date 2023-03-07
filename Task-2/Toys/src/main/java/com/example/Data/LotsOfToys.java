package com.example.Data;

import java.util.Collection;
import java.util.HashMap;

public class LotsOfToys {
    private HashMap<Integer, Toy> lots_of_toys = new HashMap<>();

    public void addNewToy(int id, String nameToy, int startQuantity, int chance) {
        lots_of_toys.put(id, new Toy(id, nameToy, startQuantity, chance));
    }

    public void addNewToy(Toy toy) {
        lots_of_toys.put(toy.getId(), toy);
    }

    public Collection<Integer> getNumberList() {
        return lots_of_toys.keySet();
    }

    public int getChanceToy(int numberToy) {
        return lots_of_toys.get(numberToy).getChance();
    }

    public int getQuantityToy(int numberToy) {
        return lots_of_toys.get(numberToy).getQuantity();
    }

    public void setQuantityToy(int numberToy) {
        Toy temp = lots_of_toys.get(numberToy);
        temp.setQuantity(temp.getQuantity() - 1);
        if (temp.getQuantity() <= 0) {
            lots_of_toys.remove(numberToy);
        }
    }

    public String getNameToy(int numberToy) {
        return lots_of_toys.get(numberToy).getNameToy();
    }

    public int getSize() {
        return lots_of_toys.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Toy toy : lots_of_toys.values()) {
            builder.append(toy.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}