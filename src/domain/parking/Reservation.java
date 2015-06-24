package domain.parking;

import domain.Car;
import domain.users.Customer;

import java.time.LocalDate;

public class Reservation {
    private int ID;
    private LocalDate date;
    private ParkingSpot parkingSpot;
    private Customer customer;
    private Car car;

    public Reservation(int ID, LocalDate date, ParkingSpot parkingSpot, Customer customer, Car car) {
        this.ID = ID;
        this.date = date;
        this.parkingSpot = parkingSpot;
        this.customer = customer;
        this.car = car;
    }

    public int getID() {
        return ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }
}

