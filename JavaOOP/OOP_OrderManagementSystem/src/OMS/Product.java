
package OMS;

import java.io.IOException;
import java.util.Random;


public class Product {
    private String ID, Name;
    private double price;

    public Product() {
    }

    public Product(String ID, String Name, double price) {
        this.ID = ID;
        this.Name = Name;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return price;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ID + " " + Name + " " + price;
    }
    
    //generate an product id
    public String generateProductID() {
        String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
        Random r = new Random();
        String id = "";
        for (int i = 0; i < 3; i++) {
            int k = r.nextInt(s.length());
            id += s.charAt(k);
        }
        return id;
    }
    
    //Input a Product
    public Product inputProduct() throws IOException{
        Product P = new Product();
        P.setID(generateProductID());
        System.out.println("Product Code = "+P.getID());
        P.setName(Ultilities.checkNull("Name = "));
        P.setPrice(Ultilities.checkDouble("Price = "));
        return P;
    }
}
