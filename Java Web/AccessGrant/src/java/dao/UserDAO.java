/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Jessie
 */
public class UserDAO extends BaseDAO {

    //get all username and password
    public ArrayList<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "select * from Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                list.add(new User(username, password));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get al User
    public ArrayList<User> select() {
        ArrayList<User> list = getAllUsers();
        for (User u : list) {
            ArrayList<String> url= new ArrayList<>();
            try {
                String sql = "select Features.url \n"
                        + "from Users, User_Group, Groups, Features, Group_Feature \n"
                        + "where Users.username = User_Group.username \n"
                        + "and User_Group.gid = Groups.gid \n"
                        + "and Groups.gid = Group_Feature.gid \n"
                        + "and Group_Feature.fid = Features.fid \n"
                        + "and Users.username = ? \n"
                        + "\n"
                        + "UNION\n"
                        + "\n"
                        + "select url from Features \n"
                        + "where isRequired = 0";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, u.getUsername());
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {                    
                    url.add(rs.getString("url"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            u.setUrl(url);
        }

        return list;
    }
    
    public User getUserByUsername(String username, String Password){
        ArrayList<User> list = select();
        for (User user : list) {
            if(user.getUsername().equals(username) && user.getPassword().equals(Password)){
                return user;
            }
        }
        return null;
    }
}
