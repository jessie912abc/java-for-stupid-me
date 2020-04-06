
package OMS;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class Order {
    private String ID, customerName, address, date;
    
    ArrayList<Product> products = new ArrayList<Product>();

    public Order() {
    }
    
    
    public Order(String ID, String customerName, String address, String date) {
        this.ID = ID;
        this.customerName = customerName;
        this.address = address;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    
    
    //Create a new Order
    public void create(String customerName, String address, String date){
        generateOrderID();
        System.out.println("Order ID = "+ ID);
        Order O = new Order(ID, customerName, address, date);
    }
    
    //Show Order
    public void print(){
        System.out.println(ID +" "+ customerName+ " "+ address+ " "+ date);
        System.out.println("Products List");
        for (Product p : products) {
            System.out.println(p);
        }
    }
    
    //Add a Product
    public void addProduct( Product p){
        products.add(p);
    }
    
    //generate an order id
    public void generateOrderID() {
        String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
        Random r = new Random();
        ID = "";
        for (int i = 0; i < 3; i++) {
            int k = r.nextInt(s.length());
            ID += s.charAt(k);
        }
    }

    
}
