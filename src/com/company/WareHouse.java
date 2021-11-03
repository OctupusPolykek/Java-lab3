package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WareHouse {
    private final ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void getDearestProduct() {
        System.out.println("The most expensive product");
        Product max = Collections.max(this.products, new ProductComparator());
        System.out.print(max);
    }
}
class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}