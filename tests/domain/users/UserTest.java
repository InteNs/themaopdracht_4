package domain.users;

import domain.users.User.userType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by InteNs on 16.jun.2015.
 */
public class UserTest {
    private final static userType TYPE = userType.OWNER ;
    private final static String EMAIL = "test@test.com";
    private final static String PASSWORD = "test";
    private final static String REAL_NAME = "test";
    private final static String ADDRESS = "test";
    private final static String PHONE_NUMBER = "test";
    private final static String POSTAL = "test";
    private final static LocalDate DATE_OF_BIRTH = LocalDate.of(2015,5,18);
    private final static String EMAIL_1 = "test1@test1.com";
    private final static String PASSWORD_1 = "test1";
    private final static String REAL_NAME_1 = "test1";
    private final static String ADDRESS_1 = "test1";
    private final static String PHONE_NUMBER_1 = "test1";
    private final static String POSTAL_1 = "test1";
    private final static LocalDate DATE_OF_BIRTH_1 = LocalDate.of(2013,2,15);
    User user;
    @Before
    public void setUp(){
        user = new User(TYPE,EMAIL,PASSWORD,REAL_NAME, DATE_OF_BIRTH,ADDRESS,POSTAL,PHONE_NUMBER);
    }
    @Test
    public void testGetUserType() throws Exception {
        assertEquals("gebruikerstype komt niet overeen",TYPE, user.getUserType());

    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("emailadres komt niet overeen",EMAIL, user.getEmail());
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals("wachtwoord komt niet overeen",PASSWORD, user.getPassword());
    }

    @Test
    public void testGetRealName() throws Exception {
        assertEquals("echte naam komt niet overeen",REAL_NAME, user.getRealName());
    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals("adres komt niet overeen",ADDRESS, user.getAddress());
    }

    @Test
    public void testGetDateOfBirth() throws Exception {
        assertEquals("geboortedatum komt niet overeen",DATE_OF_BIRTH, user.getDateOfBirth());
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        assertEquals("telefoonnummer komt niet overeen",PHONE_NUMBER, user.getPhoneNumber());
    }

    @Test
    public void testGetPostal() throws Exception {
        assertEquals("postcode komt niet overeen",POSTAL, user.getPostal());
    }

    @Test
    public void testSetEmail() throws Exception {
        user.setEmail(EMAIL_1);
        assertEquals("email is niet juist gezet",EMAIL_1, user.getEmail());

    }

    @Test
    public void testSetPassword() throws Exception {
        user.setPassword(PASSWORD_1);
        assertEquals("wachtwoord is niet juist gezet",PASSWORD_1, user.getPassword());
    }

    @Test
    public void testSetRealName() throws Exception {
        user.setRealName(REAL_NAME_1);
        assertEquals("echte naam is niet juist gezet",REAL_NAME_1, user.getRealName());
    }

    @Test
    public void testSetAddress() throws Exception {
        user.setAddress(ADDRESS_1);
        assertEquals("adres is niet juist gezet",ADDRESS_1, user.getAddress());
    }

    @Test
    public void testSetDateOfBirth() throws Exception {
        user.setDateOfBirth(DATE_OF_BIRTH_1);
        assertEquals("geboortedatum is niet juist gezet",DATE_OF_BIRTH_1, user.getDateOfBirth());
    }

    @Test
    public void testSetPhoneNumber() throws Exception {
        user.setPhoneNumber(PHONE_NUMBER_1);
        assertEquals("telefoonnummer is niet juist gezet",PHONE_NUMBER_1, user.getPhoneNumber());
    }

    @Test
    public void testSetPostal() throws Exception {
        user.setPostal(POSTAL_1);
        assertEquals("postcode is niet juist gezet",POSTAL_1, user.getPostal());
    }
}
