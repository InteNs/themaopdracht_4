package domain;

import domain.users.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by TAOUFIK & OUSSAMA on 16.jun.2015.
 */
public class CarTest {
    final static String type = "sportwagen" ;
    final static String typewr = "" ;
    final static String numberPlate = "aa-11-bb";
    private Car car ;

    @Before
    public void setUp(){car = new Car(type, numberPlate);
    }
    @Test
    public void testGetType() throws Exception {
        assertEquals("type komt niet overeen",type, car.getType());
    }

    @Test
    public void testGetNumberPlate() throws Exception {
        assertEquals("nummerplaat komt niet overeen",numberPlate, car.getLicensePlate());
    }

    @Test
    public void testSetType() throws Exception {
        car.setType(type);
        assertEquals("type is niet juist gezet",type, car.getType());

    }

    @Test
    public void testSetNumberPlate() throws Exception {
        car.setLicensePlate(numberPlate);
        assertEquals("nummerplaat is niet juist gezet",numberPlate, car.getLicensePlate());

    }
    @Test(expected = AssertionError.class)
    public void testFoutGetType() throws Exception {
        assertEquals("type komt niet overeen",typewr, car.getType());
    }

}
