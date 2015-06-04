package domain;

public class ParkingSpace {
    private boolean isAvailable = true;
    private final int ID;

    public ParkingSpace(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String toString() {
        return Integer.toString(ID);
    }
}
