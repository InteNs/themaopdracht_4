package services.controllers;

/**
 * Created by oussama on 4-6-2015.
 */


import static org.junit.Assert.assertEquals;

import domain.Customer;
import org.junit.Test;

import java.time.LocalDate;


public class UserControllerTest {
@Test
public void testAdres(){
    Customer customer = new Customer();
    customer.setAddress( Nijmegen );
    customer.getAddress();
}
    @Test
        public void testDateOfBirth(){
            Customer customer = new Customer();
            customer.setDateOfBirth(LocalDate.of(year));
            customer.getDateOfBirth();
    }


    @Test
    public void testEmail(){
        Customer customer = new Customer();
        customer.setEmail( a@hotmail.com );
        customer.getEmail();
    }

    @Test
    public void testPassword(){
        Customer customer = new Customer();
        customer.setPassword( 1234 );
        customer.getPassword();
    }

    @Test
    public void testPhonenumber(){
        Customer customer = new Customer();
        customer.setPhoneNumber( 0612345678 );
        customer.getPhoneNumber();
    }

    @Test
    public void testPostal(){
        Customer customer = new Customer();
        customer.setPostal( Utrecht );
        customer.getPostal();
    }


    @Test
    public void testRealname(){
        Customer customer = new Customer();
        customer.setRealName("Jan");
        customer.getRealName();
    }




}
