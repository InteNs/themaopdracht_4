package services;

import domain.Car;
import domain.parking.ParkingSpot;
import domain.parking.Reservation;
import domain.users.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingController {
    private ArrayList<Reservation> reservations;
    private ArrayList<ParkingSpot> parkingSpots;
    public ParkingController(){
        reservations = new ArrayList<>();
        parkingSpots = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            parkingSpots.add(new ParkingSpot(i));
    }

    private Optional<Reservation> findReservation(int ID){
        return reservations.stream().filter(reservation -> reservation.getID()==ID).findFirst();
    }
    public void removeReservation(int ID){
        if (findReservation(ID).isPresent())
            reservations.remove(findReservation(ID).get());
    }
    public List getReservations(){
        return reservations;
    }
    private boolean isParkingSpotAvailable(ParkingSpot spot, LocalDate date){
        for (Reservation reservation : spot.getReservations())
            if (reservation.getDate().isEqual(date)) return false;
        return true;
    }
    private List getAvailableParkingSpots(LocalDate date){
        return parkingSpots.stream()
                .filter(parkingSpot -> isParkingSpotAvailable(parkingSpot, date))
                .collect(Collectors.toList());
    }
    public void addReservation(int ID, LocalDate date, ParkingSpot parkingSpot, Customer customer, Car car){
            reservations.add(new Reservation(ID,date,parkingSpot,customer,car));
    }


}
