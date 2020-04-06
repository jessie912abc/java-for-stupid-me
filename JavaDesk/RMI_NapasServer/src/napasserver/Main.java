
package napasserver;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import service.Exchange;


public class Main {
    public static void main(String[] args) throws  Exception{
        String url = "rmi://localhost:1099/fptu/ia1401/napasexchange";
        Exchange ex = new MyExchange();
        LocateRegistry.createRegistry(1099);
        Naming.bind(url, ex);
        System.out.println("Server is ready!");
    }
}
