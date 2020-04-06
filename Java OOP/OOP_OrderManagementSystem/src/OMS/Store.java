
package OMS;

import java.util.ArrayList;


public class Store {
    ArrayList<Product> products = new ArrayList<Product>();

    public Store() {
    }
    //Add a Product to the Store
    public void addProduct(Product P){
        products.add(P);
    }
    
    //Update Price for product
    public void updatePrice (String ID, double newPrice){
        for (Product p : products) {
            if(p.getID().equalsIgnoreCase(ID)) p.setPrice(newPrice);
        }
    }
    
    //Show available products in the Store
    public void list(){
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }
    
    //Sort all products by product price as ascending 
    public void sort(){
        for (int i = 0; i < products.size()-1; i++) {
            if(products.get(i).getPrice() > products.get(i+1).getPrice()){
                Product Swap = products.get(i);
                products.set(i, products.get(i+1));
                products.set(i+1, Swap);
            }
        }
    }
}
