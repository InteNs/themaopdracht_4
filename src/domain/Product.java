package domain;

/**
 * Created by Jorrit Meulenbeld & Oussama Aalili on 18/06/15. */
public class Product {
    private String name;
    private int amount;
    private double price;
    // TODO: Make Product-Supplier Class

    public Product(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // TODO Make getter & setter for Product-Supplier
}
