package domain;

import java.io.Serializable;

public class Car implements Serializable {

    private String type;
    private String licensePlate;

    public Car(String type, String kenteken) {
        this.type = type;
        this.licensePlate = kenteken;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return licensePlate;
    }
}
