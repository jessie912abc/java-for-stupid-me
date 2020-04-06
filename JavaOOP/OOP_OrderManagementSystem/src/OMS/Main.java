
package OMS;

import java.io.*;


public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        Product P = new Product();
        Store S = new Store();
        Order O = new Order();
        OrderList L = new OrderList();
        
        do {            
            System.out.println("Menu");
            System.out.println("1. Add a new product to the Store");
            System.out.println("2. Update price for a particular product");
            System.out.println("3. A list of all available products in the Store");
            System.out.println("4. Create a new Order");
            System.out.println("5. Print information of an Order by Order ID");
            System.out.println("6. Sort all products by product price as ascending ");
            System.out.println("7. Print information of all Orders by a specific customer name");
            System.out.println("8. Exit");
            int choice = Integer.parseInt(in.readLine());
            if (choice == 8) break;
            switch(choice) {
                case 1: 
                    System.out.println("Enter information for product");
                    P = P.inputProduct();
                    S.addProduct(P);
                    break;
                case 2: 
                    String id = Ultilities.checkNull("Enter Product ID = ");
                    double newPrice = Ultilities.checkDouble("Enter new price = ");
                    S.updatePrice(id, newPrice);
                    break;
                case 3: 
                    System.out.println("List of available product:");
                    S.list();
                    break;
                case 4: 
                    System.out.println("Enter information for order:");
                    String customerName = Ultilities.checkNull("Customer Name = ");
                    String address = Ultilities.checkNull("Address = ");
                    String date = Ultilities.checkDate("Order Date = ");
                    O.create(customerName, address, date);
                    System.out.println("Add product to order by select a product from below list");
                    S.list();
                    while (true) {                        
                        id = Ultilities.checkNull("Enter Product ID: ");
                        for (Product product : S.products) {
                            if(product.getID().equalsIgnoreCase(id)) {
                                O.addProduct(product);
                                break;
                            }
                        }
                        int Quantity = Ultilities.checkInt("Enter Quantity: ");
                        System.out.print("Add more product (y/n): ");
                        String opt = in.readLine();
                        if(opt.charAt(0) == 'n') break;
                    }
                    break;
                case 5: 
                    id = Ultilities.checkNull("Enter Order ID: ");
                    L.printByOrder(id);
                    break;
                case 6:
                    System.out.println("Product prics as ascending");
                    S.sort();
                    break;
                case 7:
                    String name = Ultilities.checkNull("Enter Customer Name: ");
                    L.printByCustomer(name);
                    break;
            }
        } while (true);
    }
    
}
