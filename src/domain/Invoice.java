package domain;

import domain.users.Customer;

import java.util.HashMap;

/**
 * Created by InteNs on 24.jun.2015.
 */
public class Invoice {
    private int ID;
    private double price;
    private Customer customer;
    private HashMap<String,Double> invoiceList;

    public Invoice(int ID, double price, Customer customer) {
        this.ID = ID;
        this.price = price;
        this.customer = customer;
        this.invoiceList = new HashMap<>();
    }

    public int getID() {
        return ID;
    }
    public void addItem(String name, Double price){
        invoiceList.put(name,price);
        this.price +=price;
    }
    public void removeItem(String name){
        this.price -= invoiceList.get(name);
        invoiceList.remove(name);
    }

    public double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public HashMap<String, Double> getInvoiceList() {
        return invoiceList;
    }
}
