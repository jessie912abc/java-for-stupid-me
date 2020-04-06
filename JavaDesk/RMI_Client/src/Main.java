
import java.rmi.Naming;
import java.util.Date;
import service.Exchange;


public class Main {
    public static void main(String[] args) throws Exception{
        
        String url = "rmi://localhost:1099/fptu/ia1401/napasexchange";
        Exchange ex  = (Exchange) Naming.lookup(url);
        System.out.println(ex.getStock(new Date()));
//        System.out.println(ex.toVND(120));
    }
}
