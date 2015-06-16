package domain.users;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by InteNs on 16.jun.2015.
 */
public class CustomerTest {
         Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("","","", LocalDate.of(1994,3,31),"","","");
    }

    @Test
    public void testSetLastMaintenance() throws Exception {

    }

    @Test
    public void testGetLastVisit() throws Exception {

    }

    @Test
    public void testIsOnBlackList() throws Exception {

    }

    @Test
    public void testGetLastMaintenance() throws Exception {

    }

    @Test
    public void testGetCars() throws Exception {

    }

    @Test
    public void testAddCar() throws Exception {

    }

    @Test
    public void testRemoveCar() throws Exception {

    }

    @Test
    public void testSetLastVisit() throws Exception {

    }

    @Test
    public void testSetIsOnBlackList() throws Exception {

    }
}

