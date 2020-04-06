
package OMS;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ultilities {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /*
    Check Null khi nhap cac thuoc tinh la String
     */
    static public String checkNull(String str) throws IOException {
        String input = new String();
        do {
            System.out.print(str);
            input = in.readLine().trim();
            if (input.isEmpty()) {
                System.out.println("The value can not be null");
            } else {
                break;
            }
        } while (true);

        return input;
    }

    /*
    Check nhap so nguyen
     */
    static public int checkInt(String str) {
        int n = 0;
        do {
            try {
                System.out.print(str);
                n = Integer.parseInt(in.readLine().trim());//neu khong nhap integer, nhay xuong catch
                break;
            } catch (Exception e) {
                System.out.print("You must enter an integer.");
            }
        } while (true);
        return n;
    }

    /*
    Check Double
     */
    static public double checkDouble(String str) {
        double n;
        do {
            try {
                System.out.print(str);
                n = Double.parseDouble(in.readLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("You must enter a double.");
            }

        } while (true);
        return n;
    }

    /*
    Chek date
     */
    static public String checkDate(String str) {
        String s;
        do {
            try {
                System.out.print(str);
                s = in.readLine().trim();
                int day = Integer.parseInt(s.substring(0, s.indexOf('/')));
                int month = Integer.parseInt(s.substring(s.indexOf('/')+1, s.lastIndexOf('/')));
                int year = Integer.parseInt(s.substring(1 + s.lastIndexOf('/')));
                break;
            } catch (Exception e) {
                System.out.println("The date format is dd/mm/yyyy");
            }
        } while (true);
        return s;
    }
    
    
}
