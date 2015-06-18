package services;

import domain.Product;
import services.exceptions.ValidateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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
    public void addProduct(String name, int amount, double price) throws ValidateException{
        boolean succes = true;
        String ERROR_NULL = "Dit veld mag niet leeg zijn!";
        HashMap<String,String> errorMap = new HashMap<>();
        if(productExists(name)) {
            succes = false;

            errorMap.put("name_error","Deze naam bestaat al in ons systeem!");
        }
        if(Objects.equals(name, "")) {
            succes = false;
            errorMap.put("name_error",ERROR_NULL);
        }
        if(Objects.equals(amount, "")) {
            succes = false;
            errorMap.put("amount_error",ERROR_NULL);
        }
        if(Objects.equals(price, "")) {
            succes = false;
            errorMap.put("price_error",ERROR_NULL);
        }
        if(succes) {
            products.add(new Product(name, amount, price));
            System.out.println("hij doet het");
        }
        else throw new ValidateException(errorMap);


    }

    public boolean productExists(String name){
        return products.stream().anyMatch(product -> product.getName().equals(name));
    }

}
