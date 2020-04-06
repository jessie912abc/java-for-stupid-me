
package coursemanagementsystem;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    
    public static void main(String[] args) throws IOException {
        CourseList C = new CourseList();
        
        do {            
            System.out.println("COURSE MANAGEMENT SYSTEM");
            System.out.println("1. A list of all available courses in the system");
            System.out.println("2. Search and display information of a course by course id");
            System.out.println("3. Record/Add information off course");
            System.out.println("4. Sort all courses by number of credit as ascending");
            System.out.println("5. Update information of a specific course (by course id)");
            System.out.println("0. Exit");
            int choice = Ultilities.checkInt("Select your choice: ");
            if (choice == 0) break;
            switch(choice){
                case 1: 
                    C.listAll();
                    break;
                case 2:
                    C.search();
                    break;
                case 3: 
                    C.add();
                    break;
                case 4: 
                    C.sort();
                    break;
                case 5: 
                    C.update();
                    break;
            }
            
        } while (true);
    }
    
}
