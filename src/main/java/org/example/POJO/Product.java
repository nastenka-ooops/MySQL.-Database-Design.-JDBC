package org.example.POJO;

import java.math.BigDecimal;

public class Product {
    private long id;
    private String name;
    private int height;
    private BigDecimal price;
    public Product() {
    }

    public Product(long id, String name, int height, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
