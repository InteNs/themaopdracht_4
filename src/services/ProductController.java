package services;

import domain.Product;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jorrit Meulenbeld & Oussama Aalili on 18/06/15.
 */
public class ProductController implements Serializable {
    private ArrayList<Product> products;

    public ProductController(){
        products = new ArrayList<>();
    }

    /**
     * Create new product
     * @param name
     * @param amount
     * @param price
     */
    public void addProduct(String name, int amount, double price){
        products.add(new Product(name,amount,price));
    }
}
