package services;

import com.sun.org.apache.xpath.internal.SourceTree;
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

    /**
     * create a new controller(use only once)
     */
    public ProductController() {
        products = new ArrayList<>();
    }

    /**
     * Create new product
     *
     * @param name
     * @param amount
     * @param price
     */
    public void addProduct(String name, int amount, double price) throws ValidateException {
        boolean succes = true;
        String ERROR_NULL = "Dit veld mag niet leeg zijn!";
        HashMap<String, String> errorMap = new HashMap<>();
        if (productExists(name)) {
            succes = false;

            errorMap.put("name_error", "Deze naam bestaat al in ons systeem!");
        }
        if (Objects.equals(name, "")) {
            succes = false;
            errorMap.put("name_error", ERROR_NULL);
        }
        if (Objects.equals(amount, "")) {
            succes = false;
            errorMap.put("amount_error", ERROR_NULL);
        }
        if (Objects.equals(price, "")) {
            succes = false;
            errorMap.put("price_error", ERROR_NULL);
        }
        if (succes) {
           Product test = new Product(name, amount, price);
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
    public Product findProduct(String nameProduct) {
        for (Product product : products)
            if (product.getName().equals(nameProduct)) return product;
        return null;
    }

    /**
     * ammend a product
     * @param originalProductName of the product to find
     * @return the product with the given name,amount,price
     */
    public void ammendProduct(String originalProductName, String productName, int amount, double price) {
        Product product = findProduct(originalProductName);
        product.setName(productName);
        product.setAmount(amount);
        product.setPrice(price);
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