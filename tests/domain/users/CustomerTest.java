package domain.users;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by InteNs on 16.jun.2015.
 */
public class CustomerTest {
         private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("a.a@live.nl","password","joop", LocalDate.of(1994,3,31),"adres","3525RR","0612345678");
    }

    @Test
    public void testSetLastMaintenance() throws Exception {
        customer.setLastMaintenance(LocalDate.now());
        assertEquals("datum komt niet overeen",LocalDate.now(), customer.getLastMaintenance());
    }

    @Test
    public void testGetLastVisit() throws Exception {
        assertEquals("datum is niet juist ingesteld", customer.getLastVisit());
    }

    @Test
    public void testIsOnBlackList() throws Exception {
        assertEquals("Blacklist is niet juist ingesteld", customer.isOnBlackList());
    }

    @Test
    public void testGetLastMaintenance() throws Exception {
        assertEquals("datum komt niet overeen", customer.getLastMaintenance());
    }

    @Test
    public void testGetCars() throws Exception {
        Car auto = new Car("sportwagen","aa-22-bb");
        customer.getCars();
        assertEquals("Auto-object is niet juist", customer.getCars());
    }

    @Test
    public void testAddCar() throws Exception {
        Car auto = new Car("sportwagen","aa-22-bb");
        customer.addCar(auto);
        assertEquals("Auto-object is toegevoegd", customer.getCars());
    }

    @Test
    public void testRemoveCar() throws Exception {
        assertEquals("Auto-object is niet verwijderd", customer.getCars());
    }

    @Test
    public void testSetLastVisit() throws Exception {
        customer.setLastVisit(LocalDate.now());
        assertEquals("Laatste bezoek is niet juist ingesteld", customer.getLastVisit());
    }

    @Test
    public void testSetIsOnBlackList() throws Exception {
        customer.setIsOnBlackList(true);
        assertEquals("Blacklist is niet juist ingesteld", customer.isOnBlackList());
    }
}

