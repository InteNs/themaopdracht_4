package domain.parking;

import java.io.Serializable;
import java.util.ArrayList;

public class ParkingSpot implements Serializable {
    private int ID;
    private ArrayList<Reservation> reservations;
    public ParkingSpot(int ID){
        reservations = new ArrayList<>();
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
    private void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }
    private void removeReservation(Reservation reservation){
        this.reservations.remove(reservation);
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
