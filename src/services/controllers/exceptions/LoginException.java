package services.controllers.exceptions;

/**
 * Created by InteNs on 04.jun.2015.
 */
public class LoginException extends Exception {
    private String message = "inloggen mislukt";

    public LoginException(){}

    @Override
    public String getMessage() {
        return message;
    }
}
