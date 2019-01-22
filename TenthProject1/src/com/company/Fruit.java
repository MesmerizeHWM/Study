package com.company;

public class Fruit {

    enum Type {
        APPLE, LEMON, BANANA
    }

    enum Color {
        RED, YELLOW, GREEN
    }

    private Type type;
    private Color color;
    private int weight;
    private double price;

    public Fruit() {
    }

    public Fruit(Type type, Color color, int weight, double price) {
        this.type = type;
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double countPrice() {
        return this.price * this.weight / 1000;
    }
}
