package org.example;

import java.math.BigDecimal;

public class Flower {
    private int id;
    private String name;
    private int height;
    private BigDecimal price;
    private int betterBefore;

    public Flower() {
    }

    public Flower(int id, String name, int height, BigDecimal price, int betterBefore) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.price = price;
        this.betterBefore = betterBefore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getBetterBefore() {
        return betterBefore;
    }

    public void setBetterBefore(int betterBefore) {
        this.betterBefore = betterBefore;
    }
}
