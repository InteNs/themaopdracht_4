package services.exceptions;

/**
 * Created by InteNs on 04.jun.2015.
 */
public class LoginException extends Exception {
    private final String message = "inloggen mislukt";

    public LoginException(){}

    @Override
    public String getMessage() {
        return message;
    }
}
