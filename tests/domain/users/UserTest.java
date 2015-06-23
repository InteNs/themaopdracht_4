package domain.users;

import domain.users.User.userType;
import org.junit.Before;
import org.junit.Test;
import services.UserController;
import services.exceptions.ValidateException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by InteNs on 16.jun.2015.
 */
public class UserTest {
    private final static userType TYPE = userType.OWNER; //goed
    private final static userType TYPE2 = userType.MECHANIC; //fout
    private final static String EMAIL = "klaas@admin.com"; //goed
    private final static String EMAIL2 = "klaasje@admin.com"; //fout
    private final static String PASSWORD = "12kla"; //goed
    private final static String PASSWORD2 = "12klaas"; //fout
    private final static String REAL_NAME = "Klaas";
    private final static String ADDRESS = "Driel 34";
    private final static String PHONE_NUMBER = "0612345678";
    private final static String POSTAL = "3522AA";
    private final static LocalDate DATE_OF_BIRTH = LocalDate.of(2015, 5, 18);
    private final static String EMAIL_1 = "klaas@admin.com";
    private final static String PASSWORD_1 = "12kla";
    private final static String REAL_NAME_1 = "Klaas";
    private final static String ADDRESS_1 = "Driel 34";
    private final static String PHONE_NUMBER_1 = "0612345678";
    private final static String POSTAL_1 = "3522AA";
    private final static LocalDate DATE_OF_BIRTH_1 = LocalDate.of(2013, 2, 15);
    private User user;
    private UserController testController;

    @Before
    public void setUp() {
        user = new User(TYPE, EMAIL, PASSWORD, REAL_NAME, DATE_OF_BIRTH, ADDRESS, POSTAL, PHONE_NUMBER);
        testController = new UserController();
    }

    @Test
    public void testGetUserType() throws Exception {
        assertEquals("gebruikerstype komt niet overeen", TYPE, user.getUserType());

    }

    @Test(expected = AssertionError.class)
    public void testFoutUserType() {
        assertEquals("gebruikerstype komt wel overeen", TYPE2, user.getUserType());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("emailadres komt niet overeen", EMAIL, user.getEmail());
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals("wachtwoord komt niet overeen", PASSWORD, user.getPassword());
    }

    @Test
    public void testGetRealName() throws Exception {
        assertEquals("echte naam komt niet overeen", REAL_NAME, user.getRealName());
    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals("adres komt niet overeen", ADDRESS, user.getAddress());
    }

    @Test
    public void testGetDateOfBirth() throws Exception {
        assertEquals("geboortedatum komt niet overeen", DATE_OF_BIRTH, user.getDateOfBirth());
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        assertEquals("telefoonnummer komt niet overeen", PHONE_NUMBER, user.getPhoneNumber());
    }

    @Test
    public void testGetPostal() throws Exception {
        assertEquals("postcode komt niet overeen", POSTAL, user.getPostal());
    }

    @Test
    public void testSetEmail() throws Exception {
        user.setEmail(EMAIL_1);
        assertEquals("email is niet juist gezet", EMAIL_1, user.getEmail());

    }

    @Test
    public void testSetPassword() throws Exception {
        user.setPassword(PASSWORD_1);
        assertEquals("wachtwoord is niet juist gezet", PASSWORD, user.getPassword());
    }

    @Test
    public void testSetRealName() throws Exception {
        user.setRealName(REAL_NAME_1);
        assertEquals("echte naam is niet juist gezet", REAL_NAME_1, user.getRealName());
    }

    @Test
    public void testSetAddress() throws Exception {
        user.setAddress(ADDRESS_1);
        assertEquals("adres is niet juist gezet", ADDRESS_1, user.getAddress());
    }

    @Test
    public void testSetDateOfBirth() throws Exception {
        user.setDateOfBirth(DATE_OF_BIRTH_1);
        assertEquals("geboortedatum is niet juist gezet", DATE_OF_BIRTH_1, user.getDateOfBirth());
    }

    @Test
    public void testSetPhoneNumber() throws Exception {
        user.setPhoneNumber(PHONE_NUMBER_1);
        assertEquals("telefoonnummer is niet juist gezet", PHONE_NUMBER_1, user.getPhoneNumber());
    }

    @Test
    public void testSetPostal() throws Exception {
        user.setPostal(POSTAL_1);
        assertEquals("postcode is niet juist gezet", POSTAL_1, user.getPostal());
    }
}

//   @Test
//   public void testValidUserGoed() throws Exception{
//      String email,String emailRepeat, String password,String passwordRepeat, String realName,String stringDateOfBirth, String address, String postal, String phoneNumber
//       assertTrue("gebruiker is invalide", testController.validateUser(EMAIL, EMAIL, PASSWORD, PASSWORD, REAL_NAME, DATE_OF_BIRTH.toString(), ADDRESS, POSTAL, PHONE_NUMBER));
////    }
//    @Test(expected = ValidateException.class)
//    public void testInValidUserByEmail() throws Exception{
//        //String email,String emailRepeat, String password,String passwordRepeat, String realName,String stringDateOfBirth, String address, String postal, String phoneNumber
//        assertTrue("gebruiker is invalide", testController.validateUser(EMAIL, EMAIL2, PASSWORD, PASSWORD, REAL_NAME, DATE_OF_BIRTH.toString(), ADDRESS, POSTAL, PHONE_NUMBER));
//    }
//    @Test(expected = ValidateException.class)
//    public void testInValidUserByPassword() throws Exception{
//        //String email,String emailRepeat, String password,String passwordRepeat, String realName,String stringDateOfBirth, String address, String postal, String phoneNumber
//        assertTrue("gebruiker is invalide", testController.validateUser(EMAIL, EMAIL, PASSWORD, PASSWORDWRONG, REAL_NAME, DATE_OF_BIRTH.toString(), ADDRESS, POSTAL, PHONE_NUMBER));
//    }
//    @Test(expected = ValidateException.class)
//    public void testInValidUserByEmptyRealName() throws Exception{
//        //String email,String emailRepeat, String password,String passwordRepeat, String realName,String stringDateOfBirth, String address, String postal, String phoneNumber
//        assertTrue("gebruiker is invalide", testController.validateUser(EMAIL, EMAIL, PASSWORD, PASSWORD, "", DATE_OF_BIRTH.toString(), ADDRESS, POSTAL, PHONE_NUMBER));
//    }
//    @Test(expected = ValidateException.class)
//    public void testInValidUserByEmptySamePassword() throws Exception{
//        //String email,String emailRepeat, String password,String passwordRepeat, String realName,String stringDateOfBirth, String address, String postal, String phoneNumber
//        assertTrue("gebruiker is invalide", testController.validateUser(EMAIL, EMAIL, "", "", REAL_NAME, DATE_OF_BIRTH.toString(), ADDRESS, POSTAL, PHONE_NUMBER));
//    }
//    @Test(expected = ValidateException.class)
//    public void testInValidUserByEmptySameEmail() throws Exception{
//        //String email,String emailRepeat, String password,String passwordRepeat, String realName,String stringDateOfBirth, String address, String postal, String phoneNumber
//        assertTrue("gebruiker is invalide", testController.validateUser("", "", PASSWORD, PASSWORD, REAL_NAME, DATE_OF_BIRTH.toString(), ADDRESS, POSTAL, PHONE_NUMBER));
//    }
//    //TODO: extract year variable for future date - OR introduce global future date like EMAIL2 && PASSWORDWRONG
//    @Test(expected = ValidateException.class)
//    public void testInValidUserByFutureDate() throws Exception{
//        //String email,String emailRepeat, String password,String passwordRepeat, String realName,String stringDateOfBirth, String address, String postal, String phoneNumber
//        assertTrue("gebruiker is invalide", testController.validateUser(EMAIL, EMAIL, PASSWORD, PASSWORD, REAL_NAME, DATE_OF_BIRTH.plusYears(2000).toString(), ADDRESS, POSTAL, PHONE_NUMBER));
//    }
//}
