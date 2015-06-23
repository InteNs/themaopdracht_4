package services;

import domain.Car;
import domain.Product;
import domain.users.Customer;
import domain.users.Mechanic;
import domain.maintenance.MaintenanceSession;

import java.util.ArrayList;

/**
 * Created by InteNs on 23.jun.2015.
 */
public class MaintenanceController {
    private ArrayList<MaintenanceSession> maintenanceSessions;
    public MaintenanceController(){
        maintenanceSessions = new ArrayList<>();
    }
    public void newMaintenanceSession(Customer customer,Mechanic mechanic, Car car){
        maintenanceSessions.add(new MaintenanceSession(customer,mechanic,car));
    }
    public void startSession(MaintenanceSession session){
        session.setStatus(MaintenanceSession.sessionStatus.ACTIVE);
    }
    public void finishSession(MaintenanceSession session){
        session.setStatus(MaintenanceSession.sessionStatus.FINISHED);
    }
    public void addHours(MaintenanceSession session, int hours){
        session.setHours(session.getHours() + hours);
    }
    public void removeHours(MaintenanceSession session, int hours){
        session.setHours(session.getHours()-hours);
    }
    public void addProduct(MaintenanceSession session,Product product,int amount){
        session.addProduct(product, amount);
    }
    public void removeProduct(MaintenanceSession session,Product product,int amount){
        session.removeProduct(product, amount);
    }
}
