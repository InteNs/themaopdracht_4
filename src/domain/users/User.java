package domain.users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {


    public enum userType{CUSTOMER,OWNER,MECHANIC}
    private userType userType;
    private String email;
    private String password;
    private String realName;
    private String address;
    private String phoneNumber;
    private String postal;
    private LocalDate dateOfBirth;


    public User(userType userType, String email, String password, String realName, LocalDate dateOfBirth, String address, String postal, String phoneNumber) {
        this.userType = userType;
        this.email = email;
        this.password = password;
        this.realName = realName;
        this.postal = postal;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;

    }

    public User.userType getUserType() {
        return userType;
    }
    public List<String> getDetails(){
        ArrayList<String> result = new ArrayList<>();
        result.add(userType.toString());
        result.add(email);
        result.add(password);
        result.add(realName);
        result.add(address);
        result.add(phoneNumber);
        result.add(postal);
        result.add(dateOfBirth.toString());
        return result;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPostal() {
        return postal;
    }

    @Override
    public String toString() {
        return email;
    }
}
