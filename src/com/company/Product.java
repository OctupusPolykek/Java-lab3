package com.company;

import java.io.Serializable;

public class Product implements Serializable {
    private final int amount;
    private final int price;
    private final int year;
    private final String manufacturer;

    public Product(int amount, int price, int year, String manufacturer) {
        if (amount > 0)
            this.amount = amount;
        else
            throw new Error("Amount must be > 0.");
        if (price > 0)
            this.price = price;
        else
            throw new Error("Price must be > 0.");
        if (year > 0)
            this.year = year;
        else
            throw new Error("Year must be > 0.");
        if (manufacturer != null && !manufacturer.isEmpty())
            this.manufacturer = manufacturer;
        else
            throw new Error("Manufacturer cannot be empty.");
    }
    //Getters
    public int getAmount() {
        return amount;
    }
    public int getPrice() {
        return price;
    }
    public int getYear() {
        return year;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Product {" + '\n' +
                " amount = " + amount + ",\n" +
                " price = " + price + ",\n" +
                " year = " + year + ",\n" +
                " manufacturer = " + manufacturer + '\n' +
                '}';
    }
}
