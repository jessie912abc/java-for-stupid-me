
package coursemanagementsystem;

import java.io.*;
import java.util.ArrayList;


public class CourseList {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Course> a = new ArrayList<>();

    public CourseList() {
    }
    
    public void add() throws IOException{
        Course O = new Course();
        while (true) {            
            String name = Ultilities.checkNull("Enter name of Course: ");
            String id = Ultilities.checkNull("Enter ID of course: ");
            int credit = Ultilities.checkInt("Enter credit of course: ");
            O = new Course(name, id, credit);
            int check = 0;
            for (Course course : a) {
                if(course.compareTo(O) == 1) check++;
            }
            if(check == 0) break;
            else System.out.println("Duplicate information. Please reenter");
        }
        
        a.add(O);
        System.out.println("Information of course has been added");
    }
    
    public Course getCourseById(String id){
        int i= 0;
        for ( i = 0; i < a.size(); i++) {
            if(a.get(i).getId().equalsIgnoreCase(id)){
                break;
            }
        }
        return a.get(i);
    }
    
    public void listAll(){
        System.out.printf("%-10s%-30s%-10s\n", "Course ID", "Course Name", "Credit" );
        for (Course course : a) {
            printCourse(course);
        }
    }
    
    public void printCourse(Course C){
        System.out.printf("%-10s%-30s%-10d\n",C.getId(), C.getName(),C.getCredit());
    }
    
    public void search() throws IOException{
        String id = Ultilities.checkNull("Enter course id: ");
        System.out.println("Information of course: ");
        printCourse(getCourseById(id));
    }   
    
    public void sort(){
        for (int i = 0; i < a.size() -1; i++) {
            if(a.get(i).getCredit() > a.get(i+1).getCredit()){
                Course Swap = a.get(i);
                a.set(i, a.get(i+1));
                a.set(i+1, Swap);
            }
        }
    }
    
    public void update() throws IOException{
        String id = Ultilities.checkNull("Enter course id: ");
        System.out.println("Information of course: ");
        printCourse(getCourseById(id));
        int newCredit = Ultilities.checkInt("Enter new credit: ");
        getCourseById(id).setCredit(newCredit);
        System.out.println("Information of course has been updated");
    }
}

