package com.example.Data;

public class Toy {
    private int id;
    private String nameToy;
    private int quantity;
    private int chance;

    public Toy (int id, String text, int quantity, int chance){
        this.id = id;
        this.nameToy = text;
        this.quantity = quantity;
        if (chance < 0) {
            this.chance = 0;
        } else if (chance > 100) {
            this.chance = 100;
        }
        else {
            this.chance = chance;
        }
    }

    public int getId() {
        return id;
    }
    public void setQuantity(int number_quantity) {
        this.quantity = number_quantity;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        builder.append(id);
        builder.append(") ");
        builder.append(nameToy);
        builder.append("\nКоличество: ");
        builder.append(quantity);
        builder.append(" шт. ");
        builder.append("\nШанс вытянуть = ");
        builder.append(chance);
        builder.append("%.");
        return builder.toString();
    }
}
