package domain.users;

import domain.Car;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals("datum komt niet overeen", customer.getLastMaintenance());
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
        assertEquals("Auto-object is niet juist", customer.getCars());
    }

    @Test
    public void testAddCar() throws Exception {
        assertEquals("Auto-object is toegevoegd", customer.getCars());
    }

    @Test
    public void testRemoveCar() throws Exception {

        boolean autoBestaatnietmeer ;
        Car auto = new Car("ferrari","XXX666");
        customer.addCar(auto);
        // er moet eerst eeen auto bestaan om het te kunnen verwijderen dus dan is die alvast true want het moet ook verwijderd worden
        autoBestaatnietmeer = customer.getCars().contains(auto.getNumberPlate());
        customer.removeCar(auto.getNumberPlate());
        // bestond eerst wel dus, en nu niet meer!
        autoBestaatnietmeer = autoBestaatnietmeer && !customer.getCars().contains(auto.getNumberPlate());
        assertTrue(autoBestaatnietmeer);
    }

    @Test
    public void testSetLastVisit() throws Exception {
        customer.setLastVisit(LocalDate.now());
        assertEquals("Laatste bezoek is niet juist ingesteld", customer.getLastVisit());
    }

    @Test
    public void testSetIsOnBlackList() throws Exception {
        customer.setIsOnBlackList(true);
        assertTrue("", customer.isOnBlackList());
    }


}

