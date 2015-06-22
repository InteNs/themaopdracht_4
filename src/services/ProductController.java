package services;

import domain.Product;
import services.exceptions.ValidateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Jorrit Meulenbeld & Oussama Aalili on 18/06/15.
 */
public class ProductController implements Serializable {
    private ArrayList<Product> products;

    /**
     * create a new controller(use only once)
     */
    public ProductController() {
        products = new ArrayList<>();
    }

    /**
     * Create new product
     *  @param name name of the product
     * @param stringAmount number of products(in stringformat)
     * @param stringPrice  price of the product(in stringformat)
     */
    public void addProduct(String name, String stringAmount, String stringPrice) throws ValidateException {
        boolean succes = true;
        String ERROR_NULL = "Dit veld mag niet leeg zijn!";
        String ERROR_NUM = "vul een getal in!";
        int amount = 0;
        double price = 0;
        HashMap<String, String> errorMap = new HashMap<>();
        if (productExists(name)) {
            succes = false;
            errorMap.put("name_error", "Deze naam bestaat al in ons systeem!");
        }
        if (Objects.equals(name, "")) {
            succes = false;
            errorMap.put("name_error", ERROR_NULL);
        }
        if (Objects.equals(stringAmount, "")) {
            succes = false;
            errorMap.put("amount_error", ERROR_NULL);
        }

        try {
            amount = Integer.parseInt(stringAmount);
        } catch (NumberFormatException e) {
            succes = false;
            errorMap.put("amount_error",ERROR_NUM);
        }
        try {
            price = Double.parseDouble(stringPrice);
        } catch (NumberFormatException e) {
            succes = false;
            errorMap.put("price_error", ERROR_NUM);
        }
        if (!name.matches(".*[a-zA-Z].*")) {
            succes = false;
            errorMap.put("name_error", "De naam is niet correct ingevuld");
        }
        if((""+amount).contains("-")) {
            succes = false;
            errorMap.put("amount_error","Mag geen negatief getal worden ingevuld");
        }
        if((""+price).contains("-")) {
            succes = false;
            errorMap.put("price_error","Mag geen negatief getal worden ingevuld");
        }
        if (succes) {
           Product test = new Product(name, amount,price);
            products.add(test);
            System.out.println(test);

        }
        else throw new ValidateException(errorMap);


    }

    /**
     * checks if the product exists
     * @param name name to check
     * @return true if the product exists
     */
    public boolean productExists(String name) {
        return products.stream().anyMatch(product -> product.getName().equals(name));
    }

    /**
     * @return an arraylist with all the products
     */
    public ArrayList<Product> getAllProducts() {
        return products;
    }

    /**
     * finds a product by name
     * @param name of the product to find
     * @return the product with the given name
     */
    public Product findProduct(String name) {
        for (Product product : products)
            if (product.getName().equals(name)) return product;
        return null;
    }

    /**
     * ammend a product
     * @param originalProductName of the product to find
     */
    public void ammendProduct(String originalProductName, String productName, int productAmount, double productPrice) {
        Product product = findProduct(originalProductName);
        product.setName(productName);
        product.setAmount(productAmount);
        product.setPrice(productPrice);
    }

    /**
     * remove product by name
     *
     * @param name from the product to be removed
     */

    public void removeProduct(String name) {
        for (Product product : products)
            if(product.getName().equals(name)) {
                products.remove(product);
                return;
            }
    }
}