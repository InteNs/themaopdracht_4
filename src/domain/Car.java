package domain;

import java.io.Serializable;

/**
 * Created by InteNs on 05.jun.2015.
 */
public class Car implements Serializable {

    private String type;
    private String numberPlate;

    public Car(String type, String kenteken) {
        this.type = type;
        this.numberPlate = kenteken;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return numberPlate;
    }
}
