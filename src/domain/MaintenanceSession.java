package domain;

import java.time.LocalDate;
import java.util.HashMap;


public class MaintenanceSession {
    private LocalDate plannedDate;
    private boolean isFinished;
    private String numberPlate;
    private Mechanic mechanic;
    private final Stock stock;
    private int totalParts = 0;

    private final HashMap<Product, Integer> usedParts;

    public MaintenanceSession(String numberPlate, Stock stock, LocalDate plannedDate) {
        this.stock = stock;
        this.numberPlate = numberPlate;
        this.plannedDate = plannedDate;
        usedParts = new HashMap<>();
    }

    public boolean usePart(Product product) {
        if (product.getAmount() <= 0) return false;
        if (usedParts.containsKey(product)) {
            usedParts.put(product, usedParts.get(product) + 1);
            stock.useProduct(product, 1);
            totalParts++;
            return true;
        } else {
            usedParts.put(product, 1);
            totalParts++;
            return true;
        }
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setPlannedDate(LocalDate date) {
        plannedDate = date;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Mechanic getMechanic() {
        return this.mechanic;
    }

    public void endSession(int hours) {
        mechanic.setWorkedHours(mechanic.getWorkedHours() + hours);
        isFinished = true;
    }

    public HashMap<Product, Integer> getUsedParts() {
        return usedParts;

    }

    public int getTotalParts() {
        return totalParts;
    }

    public String toString() {
        return numberPlate;
    }
}
