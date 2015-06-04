package listeners;

import controllers.UserController;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by InteNs on 04.jun.2015.
 */
public class Data implements Serializable {
    private UserController userController = new UserController();
    public Data (){}

    public UserController getUserController(){
        return userController;
    }
    public static String convert(double price) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("nl", "NL"));
        return nf.format(price);
    }

}
