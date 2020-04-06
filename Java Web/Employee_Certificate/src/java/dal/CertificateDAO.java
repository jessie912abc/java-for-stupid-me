/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Certificate;

/**
 *
 * @author Jessie
 */
public class CertificateDAO {
    
    //get all Certificate
    public ArrayList<Certificate> selectCertificatesByEmployee(int e_id) throws Exception{
        //open DB connection
        Connection conn = new DBContext().getConnection();
        //run SQL statement
        String sql = "select Certificate.id, title, issueDate, DATEADD(day,expiredDays, issueDate) as expireDate " +
                    "from Certificate, Employee_Certificate " +
                    "where Certificate.id = Employee_Certificate.c_id " +
                    "and e_id = "+ e_id;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        //create an empty list
        ArrayList<Certificate> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            Date issueDate = rs.getDate("issueDate");
            Date expireDate = rs.getDate("expireDate");
            list.add(new Certificate(id, title,issueDate,expireDate));
        }
        rs.close();
        conn.close();
        return list;
    }
}
