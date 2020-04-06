
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public interface Exchange extends Remote {
    
    public double convertVND(double amount, String type) throws RemoteException;
    
    public Stock getStock(Date date) throws RemoteException;
    
    public boolean isValidUser(String username, String password) throws Exception;
}
