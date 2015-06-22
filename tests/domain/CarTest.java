package JUnit_test.domain;

import domain.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by TAOUFIK & OUSSAMA on 16.jun.2015.
 */
public class CarTest {
    private final static String type = "sportwagen" ;
    private final static String numberPlate = "aa-11-bb";
    Car car ;

    @Before
    public void setUp(){car = new Car(type, numberPlate);
    }
    @Test
    public void testGetType() throws Exception {
        assertEquals("type komt niet overeen",type, car.getType());
    }

    @Test
    public void testGetNumberPlate() throws Exception {
        assertEquals("nummerplaat komt niet overeen",numberPlate, car.getNumberPlate());
    }

    @Test
    public void testSetType() throws Exception {
        car.setType(type);
        assertEquals("type is niet juist gezet",type, car.getType());

    }
    @Test
    public void testSetTypeNull() throws Exception {
        car.setType(type);
        car.setType(null);
        assertEquals("type is niet juist gezet",type, car.getType());
    }
    @Test
    public void testSetNumberPlate() throws Exception {
        car.setNumberPlate(numberPlate);
        assertEquals("nummerplaat is niet juist gezet",numberPlate, car.getNumberPlate());

    }

}
