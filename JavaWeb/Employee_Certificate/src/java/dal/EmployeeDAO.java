/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Employee;
import model.Certificate;

/**
 *
 * @author Jessie
 */
public class EmployeeDAO {
    
    //get all Certificate
    public ArrayList<Employee> select() throws Exception {
        //open DB connection
        Connection conn = new DBContext().getConnection();
        //run SQL statement
        String sql = "select * from Employee";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        //create an empty list
        ArrayList<Employee> list = new ArrayList<>();
        CertificateDAO certDAO = new CertificateDAO();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            ArrayList<Certificate> cert = certDAO.selectCertificatesByEmployee(id);
            list.add(new Employee(id, name, cert));
        }
        rs.close();
        conn.close();
        return list;
    }
}
