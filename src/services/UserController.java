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
import java.time.format.DateTimeParseException;
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
     *  creates a new owner
     * @param email               email
     * @param emailRepeat         emailrepeat
     * @param password            password
     * @param passwordRepeat      password repeat
     * @param dateOfBirth         date of birth
     * @param realName            realname
     * @param address             address
     * @param postal              postal
     * @param phoneNumber         phonenumber
     * @throws ValidateException
     */
    public void newOwner(String email,String emailRepeat, String password,String passwordRepeat, String realName,String dateOfBirth, String address, String postal, String phoneNumber ) throws ValidateException {
        if(validateUser(email,emailRepeat,password,passwordRepeat,realName,dateOfBirth,address,postal,phoneNumber))
            users.add(new Owner(email, password, realName, LocalDate.parse(dateOfBirth), postal, address, phoneNumber));
    }

    /**
     *
     * @param email               email
     * @param emailRepeat         emailrepeat
     * @param password            password
     * @param passwordRepeat      password repeat
     * @param dateOfBirth         date of birth
     * @param realName            realname
     * @param address             address
     * @param postal              postal
     * @param phoneNumber         phonenumber
     * @throws ValidateException
     */
    public void newCustomer(String email, String emailRepeat, String password, String passwordRepeat, String realName, String dateOfBirth, String address, String postal, String phoneNumber) throws ValidateException {
        if (validateUser(email, emailRepeat, password, passwordRepeat, realName, dateOfBirth, address, postal, phoneNumber))
            users.add(new Customer(email, password, realName, LocalDate.parse(dateOfBirth), postal, address, phoneNumber));
    }

    /**
     * creates a new mechanic
     * @param email               email
     * @param emailRepeat         emailrepeat
     * @param password            password
     * @param passwordRepeat      password repeat
     * @param dateOfBirth         date of birth
     * @param realName            realname
     * @param address             address
     * @param postal              postal
     * @param phoneNumber         phonenumber
     * @throws ValidateException
     */
    public void newMechanic(String email,String emailRepeat, String password,String passwordRepeat, String realName,String dateOfBirth, String address, String postal, String phoneNumber ) throws ValidateException {
        if(validateUser(email,emailRepeat,password,passwordRepeat,realName,dateOfBirth,address,postal,phoneNumber))
            users.add(new Mechanic(email, password, realName, LocalDate.parse(dateOfBirth), postal, address, phoneNumber));
    }

    /**
     * validates if the fields are correct
     * @param email               email
     * @param emailRepeat         emailrepeat
     * @param password            password
     * @param passwordRepeat      password repeat
     * @param stringDateOfBirth   date of birth
     * @param realName            realname
     * @param address             address
     * @param postal              postal
     * @param phoneNumber         phonenumber
     * @return true if the fields are correct
     * @throws ValidateException
     */
    private boolean validateUser(String email,String emailRepeat, String password,String passwordRepeat, String realName,String stringDateOfBirth, String address, String postal, String phoneNumber ) throws ValidateException {
        boolean succes = true;
        String ERROR_NULL = "Dit veld mag niet leeg zijn!";
        HashMap<String,String> errorMap = new HashMap<>();
        LocalDate dateofBirth = null;
        System.out.println("validating");
        if(findUser(email)!=null) {
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
        if(Objects.equals(stringDateOfBirth,"")) {
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
        if(password.length() < 5) {
            succes = false;
            errorMap.put("password_error","minimaal 5 tekens");
        }
        if(!phoneNumber.matches("(^\\+[0-9]{2}|^\\+[0-9]{2}\\(0\\)|^\\(\\+[0-9]{2}\\)\\(0\\)|^00[0-9]{2}|^0)([0-9]{9}$|[0-9\\-\\s]{10}$)")) {
            succes = false;
            errorMap.put("phonenumber_error","geen geldig telefoonnummer");
        }
        if(!postal.matches("^[1-9][0-9]{3}\\s?[a-zA-Z]{2}$")) {
            succes = false;
            errorMap.put("postal_error","geen geldige postcode");
        }
        try {
            dateofBirth = LocalDate.parse(stringDateOfBirth);
        } catch (DateTimeParseException e) {
            succes = false;
            errorMap.put("dateofbirth_error","geen geldige datum");
        }
        assert dateofBirth != null;
        if (dateofBirth.isAfter(LocalDate.now())){
            succes = false;
            errorMap.put("dateofbirth_error","te jong");
        }
        if (!succes){
            System.out.println("incorrect");
            throw new ValidateException(errorMap);
        }
        return succes;
    }

    /**
     * change an existing user
     * @param originalEmail       the original email adress(to find the corresponding user)
     * @param email               email
     * @param emailRepeat         emailrepeat
     * @param password            password
     * @param passwordRepeat      password repeat
     * @param dateOfBirth         date of birth
     * @param realName            realname
     * @param address             address
     * @param postal              postal
     * @param phoneNumber         phonenumber
     * @throws ValidateException
     */
    public void ammendUser(String originalEmail, String email, String emailRepeat, String password, String passwordRepeat, String dateOfBirth, String realName, String address, String postal, String phoneNumber) throws ValidateException {
        if(validateUser(email,emailRepeat,password,passwordRepeat,realName,dateOfBirth,address,postal,phoneNumber)) {
            User user = findUser(originalEmail);
            user.setEmail(email);
            user.setPostal(postal);
            user.setPhoneNumber(phoneNumber);
            user.setDateOfBirth(LocalDate.parse(dateOfBirth));
            user.setAddress(address);
            user.setPassword(password);
            user.setRealName(realName);

        }

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
    public void newCar(String email,String type,String numberPlate) throws ValidateException {
        boolean succes = true;
        String ERROR_NULL = "Dit veld mag niet leeg zijn!";
        HashMap<String,String> errorMap = new HashMap<>();
        if(Objects.equals(type,"")){
            succes = false;
            errorMap.put("type_error",ERROR_NULL);
        }
        if(Objects.equals(numberPlate,"")){
            succes = false;
            errorMap.put("numberplate_error",ERROR_NULL);
        }
        if(findCar(numberPlate) != null) {
            succes = false;
            errorMap.put("numberplate_error","dit kenteken bestaat al");
        }
        if(!numberPlate.matches(".*[a-zA-Z]{4,}+[0-9]{2,}.*")) {
            errorMap.put("numberplate_error","geen geldig kenteken");
            succes = false;
        }
        if (succes){
            if (findUser(email) instanceof Customer)
                ((Customer)findUser(email)).addCar(new Car(type,numberPlate));
        }
        else throw new ValidateException(errorMap);
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
        if (findUser(email) instanceof Customer) {
            ((Customer)findUser(email)).removeCar(numberPlate);
            System.out.println("Car "+numberPlate+" removed from "+email);

        }
    }
}
