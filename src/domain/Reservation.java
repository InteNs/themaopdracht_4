package domain;

import java.time.LocalDate;
import java.time.Period;


public class Reservation {
    private LocalDate fromDate, toDate;
    private final static double fee = 10;
    private final ParkingSpace parkingSpace;
    private boolean isActive;
    private boolean isPayed;
    private String numberPlate;

    public Reservation(LocalDate fromDate, LocalDate toDate, String numberPlate, ParkingSpace parkingSpace) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.parkingSpace = parkingSpace;
        parkingSpace.setAvailable(false);
        this.numberPlate = numberPlate;
        checkDate();
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String isActive() {
        if (LocalDate.now().isAfter(toDate)) {
            isActive = false;
            parkingSpace.setAvailable(true);
            return "done";
        }
        if (LocalDate.now().isBefore(fromDate)) {
            isActive = false;
            parkingSpace.setAvailable(true);
            return "before";
        }
        isActive = true;
        parkingSpace.setAvailable(false);
        return "active";
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    private void checkDate() {
        isActive = !LocalDate.now().isAfter(toDate);
        if (LocalDate.now().isBefore(fromDate)) isActive = false;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public double getTotalPrice() {
        Period p = Period.between(fromDate, toDate);
        System.out.println("" + p.getDays());
        return (p.getDays()) * fee;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public String toString() {
        return numberPlate;
    }
}
