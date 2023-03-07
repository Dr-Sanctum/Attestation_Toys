package com.example.Data;

import java.util.HashMap;


public class LotsOfToys {
private HashMap<Integer,Toy> lots_of_toys = new HashMap<>();

    public void addNewToy(int id, String nameToy, int startQuantity, int chance ) {
        lots_of_toys.put(id,new Toy(id, nameToy, startQuantity, chance));
    }

    public void addNewToy(Toy toy) {
        lots_of_toys.put(toy.getId(),toy);
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