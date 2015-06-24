package services;

import domain.parking.ParkingSpot;
import domain.parking.Reservation;
import domain.users.Car;
import domain.users.Customer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingController implements Serializable {
    private ArrayList<Reservation> reservations;
    private ArrayList<ParkingSpot> parkingSpots;
    int count = -1;
    public ParkingController(){
        reservations = new ArrayList<>();
        parkingSpots = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            parkingSpots.add(new ParkingSpot(i));
    }
    private int getNewID(){
        count++;
        return count;
    }

    /**
     * finds a specific reservation
     * @param ID ID to search for
     * @return returns an Optional that may or may not contain a reservation
     */
    private Optional<Reservation> findReservation(int ID){
        return reservations.stream().filter(reservation -> reservation.getID()==ID).findFirst();
    }

    /**
     *
     * @return returns all reservations
     */
    public List getReservations(){
        return reservations;
    }

    /**
     *  checks if parking spot is available on a specific day
     * @param spot the parking spot
     * @param date the day to check
     * @return true if available
     */
    private boolean isParkingSpotAvailable(ParkingSpot spot, LocalDate date){
        for (Reservation reservation : spot.getReservations())
            if (reservation.getDate().isEqual(date)) return false;
        return true;
    }

    /**
     * get all the available parking spots
     * @param date date to check for availability
     * @return List with ParkingSpots
     */
    public List<ParkingSpot> getAvailableParkingSpots(LocalDate date){
        return parkingSpots.stream()
                .filter(parkingSpot -> isParkingSpotAvailable(parkingSpot, date))
                .collect(Collectors.toList());
    }

    /**
     * adds a reservation
     * @param date  day the reservation is active
     * @param parkingSpot parkingSpot assigned to the reservation
     * @param customer  customer paying for the reservation
     * @param car car in question
     */
    public void addReservation(LocalDate date, ParkingSpot parkingSpot, Customer customer, Car car){
            reservations.add(new Reservation(getNewID(),date,parkingSpot,customer,car));
    }

    /**
     * removes a reservation
     * @param ID reservation ID
     */
    public void removeReservation(int ID){
        if (findReservation(ID).isPresent())
            reservations.remove(findReservation(ID).get());
    }

}
