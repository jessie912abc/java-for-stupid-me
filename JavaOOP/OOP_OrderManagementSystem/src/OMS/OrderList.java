
package OMS;

import java.util.ArrayList;


public class OrderList {
    ArrayList<Order> orders = new ArrayList<Order>();

    public OrderList() {
    }
    
    public void printByOrder(String ID){
        for (Order order : orders) {
            if(order.getID().equalsIgnoreCase(ID)){
                order.print();
            }
        }
    }
    
    public void printByCustomer(String customerName){
        for (Order order : orders) {
            if(order.getCustomerName().equalsIgnoreCase(customerName)){
                order.print();
            }
        }
    }
}
