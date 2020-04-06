/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemanagementsystem;

import java.io.*;

/**
 *
 * @author ASUS
 */
public class Ultilities {
    static  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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

    

}
