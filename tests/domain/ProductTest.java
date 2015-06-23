package domain;




import domain.Product;
import org.junit.Before;
import org.junit.Test;
import services.UserController;
import services.ProductController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by oussama on 23-6-2015.
 */
public class ProductTest {
    // de goeie gegevens
    private final static String NAME = "Spijker";
    private final static int AMOUNT = 5;
    private final static double PRICE = 13.00;
    // de foute gegevens
    private final static String NAMEWRONG = "";
    private final static int AMOUNTWRONG = -1;
    private final static double PRICEWRONG = 13;
    Product product, productfout;
    private ProductController productController;

    @Before
    public void setUp() {
        product = new Product(NAME, AMOUNT, PRICE);
        productfout = new Product(NAMEWRONG, AMOUNTWRONG, PRICEWRONG);
        productController = new ProductController();
    }

    @Test
    public void testAddProduct() throws Exception {
        productController.addProduct("Spijker", "5", "13.00");
        assertTrue(ProductController.getAllProducts().contains(product));
    }
    @Test
    public void testproductExits() throws Exception {
        ProductController.productExists(NAMEWRONG);
        assertEquals(false, ProductController.getAllProducts().contains(product));
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