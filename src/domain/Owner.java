package domain;

import java.time.LocalDate;

/**
 * Created by InteNs on 05.jun.2015.
 */
public class Owner extends User {
    public Owner(String email, String password, String realName, LocalDate dateOfBirth, String address, String postal, String phoneNumber) {
        super(User.userType.OWNER, email, password, realName, dateOfBirth, address, postal, phoneNumber);
    }
}
