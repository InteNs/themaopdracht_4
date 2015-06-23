package services;

import domain.Car;
import domain.users.Customer;
import domain.users.Mechanic;
import domain.users.Owner;
import domain.users.User;
import services.exceptions.LoginException;
import services.exceptions.ValidateException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public List<User> getUsers() {
        return users;
    }

    /**
     * finds a user by email
     * @param email of the user to find
     * @return the user with the given email
     */
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
        if(!users.stream().anyMatch(user -> user.getEmail().equals(email) && user.getPassword().equals(password)))
            throw new LoginException();
    }

    /**
     * checks if the user exists
     * @param email email to check
     * @return true if the user exists
     */
    public boolean userExists(String email){
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    /**
     * change a user's info
     * @param user      the customer that needs to be changed
     * @param email         @nullable
     * @param password      @nullable
     * @param realName      @nullable
     * @param dateOfBirth   @nullable
     * @param postal        @nullable
     * @param address       @nullable
     * @param phoneNumber   @nullable
     */
    public void changeUserInfo(User user,String email, String password, String realName,LocalDate dateOfBirth, String address,String postal,String phoneNumber) {
        if (email !=null)       user.setEmail(email);
        if (password !=null)    user.setPassword(password);
        if (realName !=null)   user.setRealName(realName);
        if (dateOfBirth !=user.getDateOfBirth()) user.setDateOfBirth(dateOfBirth);
        if (postal != null)     user.setPostal(postal);
        if (address !=null)     user.setAddress(address);
        if (phoneNumber != null)user.setPhoneNumber(phoneNumber);
    }

    /**
     * creates a new admin(hardcoded)
     */
    public static void newAdmin(){
        users.add(new Owner("admin@admin.nl","admin","admin",LocalDate.now(),"admin","admin","admin"));
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
    public static void newCustomer(String email,String emailRepeat, String password,String passwordRepeat, String realName,LocalDate dateOfBirth, String address, String postal, String phoneNumber ) throws ValidateException {
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
            errorMap.put("email_repeat_error","Email adres komt niet overeen!");
        }
        if(!password.equals(passwordRepeat)) {
            succes = false;
            errorMap.put("password_repeat_error","wachtwoord komt niet overeen!");
        }
        if(!email.contains("@")) {
            succes = false;
            errorMap.put("email_error","De email moet een @ bevatten");
        }
        if(password.length() < 5) {
            succes = false;
            errorMap.put("password_error","het wachtwoord moet minimaal 5 karakters bevatten");
        }
        if(phoneNumber.length() < 10 ){
            succes = false;
            errorMap.put("phonenumber_error","De telefoonnummer bevat geen 10 cijfers");
        }
        if(phoneNumber.matches(".*[a-zA-Z].*")) {
            succes = false;
            errorMap.put("phonenumber_error","Een telefoonnummer bevat geen letters");
        }
        if(!postal.matches(".*[0-9]{4,}+[a-zA-Z]{2,}.*")) {
            succes = false;
            errorMap.put("postal_error","geen geldige postcode");
        }


        if(succes) {
            users.add(new Customer(email, password, realName, dateOfBirth, postal, address, phoneNumber));
        }
        else throw new ValidateException(errorMap);


    }

    /**
     * create a new Mechanic
     *
     * @param email email
     * @param password password
     * @param realName realname
     * @param dateOfBirth dateofbirth
     * @param address address
     * @param postal postal
     * @param phoneNumber phonenumber
     */
    public void newMechanic(String email,String password,String realName,LocalDate dateOfBirth,String address,String postal,String phoneNumber) throws ValidateException {
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
        if(succes) {
            users.add(new Mechanic(email,password,realName,dateOfBirth,address,postal,phoneNumber));
        }
        else throw new ValidateException(errorMap);


    }

    /**
     * remove customer by email
     *
     * @param email from the customer to be removed
     */
    public void removeUser(String email) {
        for (User user : users)
            if(user.getEmail().equals(email)) {
                users.remove(user);
                return;
            }
    }

    /**
     * adds a new car
     * @param email email of the car owner
     * @param type  car type
     * @param numberPlate numberplate of car
     */
    public void newCar(String email,String type,String numberPlate){
        boolean succes = true;
        String ERROR_NULL = "Dit veld mag niet leeg zijn!";
        HashMap<String,String> errorMap = new HashMap<>();
        if(userExists(numberPlate)) {
            succes = false;

            errorMap.put("numberplate_error","Deze kentekenen bestaat al in ons systeem!");
        }
        if(!numberPlate.matches(".*[a-zA-Z]{4,}+[0-9]{2,}.*")) {
            errorMap.put("numberplate_error","Kenteken heeft 4 letters 2 cijfers ");
            succes = false;
        }
        if (findUser(email) instanceof Customer)
            ((Customer)findUser(email)).addCar(new Car(type,numberPlate));
    }

    /**
     * find all cars with the corresponding numberplate
     * @param numberPlate searchword
     * @return null if car doesn't exist, the car otherwise
     */
    public Car findCar(String numberPlate){
        ArrayList<Car>cars = new ArrayList<>();
        users.stream().filter(user -> user instanceof Customer).forEach(user -> cars.addAll(((Customer) user).getCars()));
        for(Car car:cars)
            if (car.getNumberPlate().equals(numberPlate))
                return car;
        return null;
    }

    /**
     * removes a car
     * @param email email of car owner
     * @param numberPlate numberplate of car
     */
    public void removeCar(String email,String numberPlate){
        if (findUser(email) instanceof Customer){
            ((Customer)findUser(email)).removeCar(numberPlate);
            System.out.println("Car "+numberPlate+" removed from "+email);

        }
    }


}
