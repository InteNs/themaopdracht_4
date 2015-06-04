package services.controllers;

import domain.Customer;
import domain.User;
import services.controllers.exceptions.LoginException;
import services.controllers.exceptions.RegisterException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by InteNs on 04.jun.2015.
 */
public class UserController implements Serializable {
    ArrayList<User> users;

    /**
     * create a new controller(use only once)
     */
    public UserController() {
        users = new ArrayList<>();
    }

    /**
     * @return an arraylist with all the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    public User findUser(String email){
        for(User user :users)
            if (user.getEmail().equals(email))return user;
        return null;
    }

    /**
     * @return a list with customers who's vehicles need a maintenance(6 months)
     */
    public List<Customer> getExpiredMaintenanceList() {
        ArrayList<Customer> result = new ArrayList<>();
        users.stream()
                .filter(customer -> customer instanceof Customer && ((Customer) customer).getLastMaintenance().isBefore(LocalDate.now().minusMonths(6)))
                .forEach(user -> result.add((Customer)user));
        return result;

    }

    /**
     * @return a list with customers who haven't payed a visit in 2+ months
     */
    public List<Customer> getExpiredVisitList() {
        ArrayList<Customer> result = new ArrayList<>();
        users.stream()
                .filter(customer -> customer instanceof Customer && ((Customer) customer).getLastVisit().isBefore(LocalDate.now().minusMonths(2)))
                .forEach(user -> result.add((Customer)user));
        return result;
    }

    /**
     * @return a list with customers currently on the blacklist
     */
    public List<Customer> getBlackListedList() {
        ArrayList<Customer> result = new ArrayList<>();
        users.stream()
                .filter(user -> ((Customer)user).isOnBlackList())
                .forEach(user -> result.add((Customer)user));
        return result;
    }

    /**
     *
     * @param email filled in email
     * @param password filled in password
     * @throws LoginException
     */
    public void isLoginValid(String email,String password) throws LoginException {
        assert !users.stream().anyMatch(user -> user.getEmail().equals(email) && user.getPassword().equals(password));
    }

    /**
     * checks if the user exists
     * @param email email to check
     * @return true if the user exists
     */
    public Boolean userExists(String email){
        return users.stream()
                .anyMatch(user -> user.getEmail().equals(email));

    }

    /**
     * change a customer deetail
     * @param customer      the customer that needs to be changed
     * @param email         @nullable
     * @param password      @nullable
     * @param realName      @nullable
     * @param dateOfBirth   @nullable
     * @param postal        @nullable
     * @param address       @nullable
     * @param phoneNumber   @nullable
     */
    public void changeCustomerInfo(Customer customer,String email, String password, String realName,LocalDate dateOfBirth, String address,String postal,String phoneNumber) {
        if (email !=null)       customer.setEmail(email);
        if (password !=null)    customer.setPassword(password);
        if (realName !=null)   customer.setRealName(realName);
        if (dateOfBirth !=customer.getDateOfBirth()) customer.setDateOfBirth(dateOfBirth);
        if (postal != null)     customer.setPostal(postal);
        if (address !=null)     customer.setAddress(address);
        if (phoneNumber != null)customer.setPhoneNumber(phoneNumber);
    }

    /**
     * create a new customer
     *
     * @param email       emailadress
     * @param password    password
     * @param realName   firstname
     * @param address     adress(street + house number)
     * @param dateOfBirth dateOfBirth
     */
    public void newCustomer(String email,String emailRepeat, String password,String passwordRepeat, String realName,LocalDate dateOfBirth, String address, String postal, String phoneNumber ) throws RegisterException {
        boolean succes = true;
        String ERROR_NULL = "Dit veld mag niet leeg zijn!";
        HashMap<String,String> errorMap = new HashMap<>();
        if(userExists(email)) {
            succes = false;
            errorMap.put("email_error","Dit emailadres bestaat al in ons systeem!");
        }
        if(Objects.equals(email, "")) {
            succes = false;
            errorMap.put("email_error",ERROR_NULL);
        }
        if(Objects.equals(password, "")) {
            succes = false;
            errorMap.put("password_error",ERROR_NULL);
        }
        if(Objects.equals(realName, "")) {
            succes = false;
            errorMap.put("realname_error",ERROR_NULL);
        }
        if(Objects.equals(dateOfBirth, null)) {
            succes = false;
            errorMap.put("dateofbirth_error",ERROR_NULL);
        }
        if(Objects.equals(address, "")) {
            succes = false;
            errorMap.put("address_error",ERROR_NULL);
        }
        if(Objects.equals(postal, "")) {
            errorMap.put("postal_error",ERROR_NULL);
            succes = false;
        }
        if(Objects.equals(phoneNumber, "")) {
            errorMap.put("phonenumber_error",ERROR_NULL);
            succes = false;
        }
        if(!email.equals(emailRepeat)) {
            succes = false;
            errorMap.put("email_error","Email adres komt niet overeen!");
        }
        if(!password.equals(passwordRepeat)) {
            succes = false;
            errorMap.put("password_error","wachtwoord komt niet overeen!");
        }


        if(succes) {
            users.add(new Customer(email, password, realName, dateOfBirth, postal, address, phoneNumber));
        }
        else throw new RegisterException(errorMap);


    }

    /**
     * remove customer by email
     *
     * @param email from the customer to be removed
     */
    public void removeUser(String email) {
        users.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .forEach(users::remove);
    }

    /**
     * remove customer by object
     *
     * @param customer to be removed
     */
    public void removeCustomer(Customer customer) {
        users.remove(customer);
    }
}
