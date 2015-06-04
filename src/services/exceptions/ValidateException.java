package services.exceptions;

import java.util.HashMap;

/**
 * Created by InteNs on 04.jun.2015.
 */
public class ValidateException extends Exception {
    private HashMap<String,String> errorMap;

    public ValidateException(HashMap<String, String> errorMap){
        super();
        this.errorMap = errorMap;
    }

    public HashMap<String, String> getErrorMap() {
        return errorMap;
    }
}
