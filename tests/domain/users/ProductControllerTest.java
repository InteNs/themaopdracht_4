package domain.users;

import domain.Product;
import org.junit.Before;
import org.junit.Test;
import services.ProductController;

import static org.junit.Assert.*;

/**
 * Created by oussama on 24-6-2015.
 */
public class ProductControllerTest {
    ProductController productController;
    private Product product;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAddProduct() throws Exception {
        product = new Product("Schroeven",2,20.00);
        productController.addProduct("Schroeven",2,20.00);
        assertEquals("product is niet juist toegevoegd",productController.getAllProducts());
    }

    @Test
    public void testGetAllProducts() throws Exception {
        product = new Product("Schroeven",2,20.00);
        assertEquals("product is niet juist toegevoegd",productController.getAllProducts());
    }

    @Test
    public void testAmmendProduct() throws Exception {
        product = new Product("Schroeven",2,20.00);
        productController.ammendProduct("","",2,20.00);
        assertEquals("product is niet juist aangepast",productController.getAllProducts());
    }

    @Test
    public void testRemoveProduct() throws Exception {
        product = new Product("Schroeven",2,20.00);
        productController.removeProduct("Schroeven");
        assertEquals("product is niet juist verwijderd",productController.getAllProducts());
    }
}