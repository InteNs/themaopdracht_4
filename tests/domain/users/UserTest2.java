import domain.users.User;
import org.junit.Before;
import org.junit.Test;
import services.ProductController;
import services.UserController;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by InteNs on 16.jun.2015.
 */
public class UserTest2 {
    //goede gegevens
    private final static User.userType TYPE = User.userType.OWNER;
    private final static String EMAIL = "klaas@admin.com";
    private final static String PASSWORD = "12kla";
    private final static String REAL_NAME = "Klaas";
    private final static String PHONE_NUMBER = "0612345678";
    private final static String POSTAL = "3522AA";
    private final static LocalDate DATE_OF_BIRTH = LocalDate.of(2015, 5, 18);
    private final static String ADDRESS = "Driel 34";

    //foute gegevens
    private final static User.userType TYPEWR = User.userType.MECHANIC;
    private final static String EMAILWR = "";
    private final static String PASSWORDWR = "";
    private final static String REAL_NAMEWR = "";
    private final static String PHONE_NUMBERWR = "";
    private final static String POSTALWR = "";
    private final static LocalDate DATE_OF_BIRTHWR = LocalDate.of(2019, 5, 18);
    private final static String ADDRESSWR = "";

    private User user;
    private User userwr;
    private UserController testController;

    @Before
    public void setUp() {
        user = new User(TYPE, EMAIL, PASSWORD, REAL_NAME, DATE_OF_BIRTH, ADDRESS, POSTAL, PHONE_NUMBER);
        user = new User(TYPEWR, EMAILWR, PASSWORDWR, REAL_NAMEWR, DATE_OF_BIRTHWR, ADDRESS, POSTAL, PHONE_NUMBER);
        testController = new UserController();
    }

    @Test
    public void testuserExits() throws Exception {
        testController.userExists(EMAIL);
        assertEquals(true, testController.getUsers().contains(EMAIL));
    }
    @Test
    public void testfindProduct() throws Exception {
        ProductController.findProduct(NAMEWRONG);
        assertEquals(false, ProductController.getAllProducts().contains(product));
    }
//    @Test
//    public void testgetAllProduct() throws Exception {
//        ProductController.getAllProducts();
//        assertEquals(true, ProductController.getAllProducts().contains(product));
//    }

//    @Test
//    public void testAmmendProduct() throws Exception {
//    // String originalProductName, String productName, int productAmount, double productPrice
//        productController.ammendProduct(NAMEWRONG, AMOUNTWRONG, PRICEWRONG);
//        assertEquals(true, ProductController.getAllProducts().contains(product));
//}

    @Test(expected = AssertionError.class)
    public void testRemoveProduct() throws Exception {
        productController.removeProduct("Spijker");
        assertTrue(ProductController.getAllProducts().contains(product));
    }



}
