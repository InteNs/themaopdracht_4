package domain.users;

import java.time.LocalDate;

/**
 * Created by InteNs on 05.jun.2015.
 */
public class Mechanic extends User {
    private double uurloon;
    public Mechanic( String email, String password, String realName, LocalDate dateOfBirth, String address, String postal, String phoneNumber) {
        super(userType.MECHANIC, email, password, realName, dateOfBirth, address, postal, phoneNumber);
        this.uurloon = 15;
    }

    public double getUurloon() {
        return uurloon;
    }
}
