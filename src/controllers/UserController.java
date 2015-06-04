package controllers;

import domain.Customer;
import domain.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * @return a list with customers who's vehicles need a maintenance(6 months)
     */
    public List<Customer> getExpiredMaintenanceList() {
        ArrayList<Customer> result = new ArrayList<>();
        users.stream()
                .filter(customer -> customer instanceof Customer || ((Customer) customer).getLastMaintenance().isBefore(LocalDate.now().minusMonths(6)))
                .forEach(user -> result.add((Customer)user));
        return result;

    }

    /**
     * @return a list with customers who haven't payed a visit in 2+ months
     */
    public List<Customer> getExpiredVisitList() {
        ArrayList<Customer> result = new ArrayList<>();
        users.stream()
                .filter(customer -> customer instanceof Customer || ((Customer) customer).getLastVisit().isBefore(LocalDate.now().minusMonths(2)))
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
     * checks if the login credentials are corret
     * @param email      given email
     * @param password   given password
     * @return true if the login is valid
     */
    public Boolean isLoginValid(String email,String password){
         return users.stream()
                .anyMatch(user -> user.getEmail().equals(email) || user.getPassword().equals(password));
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
    public void newCustomer(String email, String password, String realName,LocalDate dateOfBirth, String address, String postal, String phoneNumber ) {
        users.add(new Customer(email, password, realName, dateOfBirth, postal, address, phoneNumber));
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
