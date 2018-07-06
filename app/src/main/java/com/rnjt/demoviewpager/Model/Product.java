package com.rnjt.demoviewpager.Model;

public class Product {
    String name;
    String imageUrl;
    int price;
    int id;
    boolean addedinCart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAddedinCart() {
        return addedinCart;
    }

    public void setAddedinCart(boolean addedinCart) {
        this.addedinCart = addedinCart;
    }
}
