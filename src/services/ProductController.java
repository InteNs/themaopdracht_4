package services;

import domain.Product;
import services.exceptions.ValidateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Jorrit Meulenbeld & Oussama Aalili on 18/06/15.
 */
public class ProductController implements Serializable {
    @SuppressWarnings("CanBeFinal")
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
     * @param amount number of products
     * @param price  price of the product
     */
    public void addProduct(String name, int amount, double price) throws ValidateException {
        if (!productExists(name)){
            products.add(new Product(name,amount,price));
        }
    }

    /**
     * checks if the product exists
     * @param name name to check
     * @return true if the product exists
     */
    private boolean productExists(String name) {
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
    private Product findProduct(String name) {
        for (Product product : products)
            if (product.getName().equals(name)) return product;
        return null;
    }

    /**
     * ammend a product
     * @param originalProductName of the product to find
     */
    public void ammendProduct(String originalProductName, String productName, int productAmount, double productPrice) throws ValidateException {
        if (!productExists(productName)){
            Product product = findProduct(originalProductName);
            if (product != null) {
                product.setName(productName);
                product.setAmount(productAmount);
                product.setPrice(productPrice);
            }
        }
        else {
            HashMap<String,String> errormap = new HashMap<>();
            errormap.put("name_error","naam bestaat al");
            throw new ValidateException(errormap);
        }
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