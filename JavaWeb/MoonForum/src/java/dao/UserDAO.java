/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Jessie
 */
public class UserDAO {
    
    //get all user
    public ArrayList<User> selectAllUser(){
        ArrayList<User> list = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "select Users.*, Login.password "
                    + "from Users join Login on Login.username = Users.username";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String displayName = rs.getString("displayName");
                Date dob = rs.getDate("dob");
                boolean gender = rs.getBoolean("gender");
                String bio = rs.getString("bio");
                String password = rs.getString("password");
                
                list.add(new User(username, password, id, displayName, dob, gender,bio));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //authenticate login
    public User authenticateUser(String username, String password){
        ArrayList<User> list = selectAllUser();
        for (User user : list) {
            if(user.getUsername().equals(username)
                    && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    
    //get user by userid
    public User getUserByUserid(int userid){
        ArrayList<User> list = selectAllUser();
        for (User user : list) {
            if (user.getId() == userid) {
                return user;
            }
        }
        return null;
    }
    
    //get user like a post
    public ArrayList<User> getLikeUsersByStatusId(int sid){
        ArrayList<User> list = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "select Users.*, Login.password \n" +
                        "from Users join Login on Login.username = Users.username \n" +
                        "join LikePost on Users.id = LikePost.userid\n" +
                        "where LikePost.statusid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String displayName = rs.getString("displayName");
                Date dob = rs.getDate("dob");
                boolean gender = rs.getBoolean("gender");
                String bio = rs.getString("bio");
                String password = rs.getString("password");

                list.add(new User(username, password, id, displayName, dob, gender,bio));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //create new users
    public void createNewUser(User u) {
        try {
            Connection conn = new DBContext().getConnection();

            String sql1 = "insert into Login(username, password) values (?,?)";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, u.getUsername());
            ps1.setString(2, u.getPassword());
            ps1.executeUpdate();

            String sql2 = "insert into Users(username, displayName, dob, gender, bio) "
                    + "values (?,?,?,?,?)";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, u.getUsername());
            ps2.setString(2, u.getDisplayName());
            ps2.setDate(3, u.getDob());
            ps2.setBoolean(4, u.isGender());
            ps2.setString(5, u.getBio());
            ps2.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //get Follower list
    public ArrayList<User> getFollower(User u) {
        ArrayList<User> follower = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();

            String sql = "select Users.*, Login.password \n"
                    + "from Users join Login on Login.username = Users.username \n"
                    + "join Follow on Users.id = Follow.follower\n"
                    + "and followee = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String displayName = rs.getString("displayName");
                Date dob = rs.getDate("dob");
                boolean gender = rs.getBoolean("gender");
                String bio = rs.getString("bio");
                String password = rs.getString("password");
                follower.add(new User(username, password, id, displayName, dob, gender, bio));
            }

            rs.close();
            conn.close();
        } catch (Exception e) {
        }
        return follower;
    }

    //get Following list
    public ArrayList<User> getFollowing(User u) {
        ArrayList<User> follower = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();

            String sql = "select Users.*, Login.password \n"
                    + "from Users join Login on Login.username = Users.username \n"
                    + "join Follow on Users.id = Follow.followee\n"
                    + "and follower = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String displayName = rs.getString("displayName");
                Date dob = rs.getDate("dob");
                boolean gender = rs.getBoolean("gender");
                String bio = rs.getString("bio");
                String password = rs.getString("password");
                follower.add(new User(username, password, id, displayName, dob, gender,bio));
            }

            rs.close();
            conn.close();
        } catch (Exception e) {
        }
        return follower;
    }
    
    //update user
    public void updateUser(User u){
        try {
            Connection conn = new DBContext().getConnection();

            String sql1 = "update Login "
                    + "set password=? "
                    + "where username =?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, u.getPassword());
            ps1.setString(2, u.getUsername());
            ps1.executeUpdate();

            String sql2 = "update Users "
                    + "set displayName=?, dob=?, gender=?, bio=? "
                    + "where id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, u.getDisplayName());
            ps2.setDate(2, u.getDob());
            ps2.setBoolean(3, u.isGender());
            ps2.setString(4, u.getBio());
            ps2.setInt(5, u.getId());
            ps2.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //search for user
    public ArrayList<User> searchByPattern(String search){
        ArrayList<User> list = new ArrayList<>();
        for (User user : selectAllUser()) {
            if (user.getDisplayName().contains(search)) {
                list.add(user);
            }
        }
        return list;
    }
    
    //get blocked user 
    public ArrayList<User> getBlockedUserByUserid(int userid){
        ArrayList<User> list = new ArrayList();
        try {
            Connection conn = new DBContext().getConnection();
             String sql = "select Users.*, Login.password \n"
                    + "from Users join Login on Login.username = Users.username \n"
                    + "join Block on Users.id = Block.blockid\n"
                    + "and Block.userid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String displayName = rs.getString("displayName");
                Date dob = rs.getDate("dob");
                boolean gender = rs.getBoolean("gender");
                String bio = rs.getString("bio");
                String password = rs.getString("password");
                list.add(new User(username, password, id, displayName, dob, gender,bio));
            }

            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    //block new user
    public void blockUser(int userid, int blockid){
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "insert into Block(userid, blockid) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2, blockid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //unblock new user
    public void unblockUser(int userid, int blockid){
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "delete from Block where userid =? and blockid =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2, blockid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //follow user 
    public void followUser(int follower, int followee){
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "insert into Follow(follower, followee) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, follower);
            ps.setInt(2, followee);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
