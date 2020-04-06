
package napasserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import service.Exchange;
import service.Stock;


public class MyExchange extends UnicastRemoteObject implements Exchange{
    
    public MyExchange() throws  RemoteException {
        
    }
    

    @Override
    public Stock getStock(Date date) throws RemoteException {
        return new Stock();
    }

    @Override
    public boolean isValidUser(String username, String password) throws Exception {
        boolean isValid = false;
        //open file users.txt and do the validation
        try {
            LineNumberReader lnr = new LineNumberReader(new FileReader("users.txt"));
            String s = "";
            while ((s = lnr.readLine()) != null) {            
                if(!s.trim().isEmpty()){
                    String[] st = s.split("/");
                    if(username.equalsIgnoreCase(st[0]) && password.equals(st[1])){
                        return isValid = true;
                    }
                }
            }
            lnr.close();
        } catch (Exception e) {
        }
        return isValid;
    }

    @Override
    public double convertVND(double amount, String type) throws RemoteException {
        double amountChange = 0;
        if(type.contains("USD")){
            amountChange=  amount / 21000;
        }
        else if(type.contains("EUR")){
            amountChange=  amount / 23000;
        }
        else if(type.contains("INR")){
            amountChange=  amount/ 15000;
        }
        return amountChange;
    }
    
}
