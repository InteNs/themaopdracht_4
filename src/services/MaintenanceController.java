package services;

import domain.Product;
import domain.maintenance.MaintenanceSession;
import domain.users.Car;
import domain.users.Customer;
import domain.users.Mechanic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by InteNs on 23.jun.2015.
 */
public class MaintenanceController implements Serializable {
    private ArrayList<MaintenanceSession> maintenanceSessions;
    int count;
    public MaintenanceController(){
        maintenanceSessions = new ArrayList<>();
        count = -1;
    }

    private int getNewID(){
        count++;
        return count;
    }

    public ArrayList<MaintenanceSession> getMaintenanceSessions() {
        return maintenanceSessions;
    }

    /**
     * creates a new session
     * @param customer customer paying for it
     * @param mechanic mechanic working on it
     * @param car the subject of the session
     */
    public void newSession(Customer customer, Mechanic mechanic, Car car){
        maintenanceSessions.add(new MaintenanceSession(getNewID(),customer,mechanic,car));
    }
    public void removeSession(int ID){
        for (MaintenanceSession session: maintenanceSessions)
            if (session.getID() == ID){
                maintenanceSessions.remove(session);
                return;
            }
    }

    /**
     * starts a session
     * @param session session to start
     */
    public void startSession(MaintenanceSession session){
        session.setStatus(MaintenanceSession.sessionStatus.ACTIVE);
    }

    /**
     * finishes the session
     * @param session session to finish
     */
    public void finishSession(MaintenanceSession session){
        session.setStatus(MaintenanceSession.sessionStatus.FINISHED);
    }

    /**
     * adds hours to a session
     * @param session session to add hours to
     * @param hours amount of hours to add
     */
    public void addHours(MaintenanceSession session, int hours){
        session.setHours(session.getHours() + hours);
    }

    /**
     * removes hours from a session
     * @param session session to remove from
     * @param hours amount of hours to remove
     */
    public void removeHours(MaintenanceSession session, int hours){
        session.setHours(session.getHours()-hours);
    }

    /**
     * adds a product to a session
     * @param session the session to add products to
     * @param product the product to add
     * @param amount amount of products to add
     */
    public void addProduct(MaintenanceSession session,Product product,int amount){
        session.addProduct(product, amount);
    }

    /**
     * removes products from a session
     * @param session the session to remove from
     * @param product the product to remove
     * @param amount  amount of products to remove
     */
    public void removeProduct(MaintenanceSession session,Product product,int amount){
        session.removeProduct(product, amount);
    }

}
