package services.controllers.exceptions;

import java.util.HashMap;

/**
 * Created by InteNs on 04.jun.2015.
 */
public class RegisterException extends Exception {
    private HashMap<String,String> errorMap;

    public RegisterException(HashMap<String, String> errorMap){
        super();
        this.errorMap = errorMap;
    }

    public HashMap<String, String> getErrorMap() {
        return errorMap;
    }
}
