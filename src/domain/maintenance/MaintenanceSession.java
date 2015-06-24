package domain.maintenance;

import domain.Car;
import domain.Product;
import domain.users.Customer;
import domain.users.Mechanic;

import java.time.LocalDate;
import java.util.HashMap;

public class MaintenanceSession {
    public enum sessionStatus{NIEUW,FINISHED,ACTIVE}

    private sessionStatus status;
    private Customer customer;
    private Mechanic mechanic;
    private LocalDate date;
    private Car car;
    private HashMap<Product,Integer> products;
    private int hours;
    public MaintenanceSession(Customer customer, Mechanic mechanic, Car car){
        this.customer = customer;
        this.mechanic = mechanic;
        products = new HashMap<>();
        this.status = sessionStatus.NIEUW;
        this.date = LocalDate.now();
        this.car = car;
        this.hours = 0;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public void addProduct(Product product, int amount){
        this.products.put(product,amount);
    }
    public void removeProduct(Product product,int amount){
        this.products.put(product,products.get(product)-amount);
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public MaintenanceSession.sessionStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceSession.sessionStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

