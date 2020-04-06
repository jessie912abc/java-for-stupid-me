/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.Comment;
import model.Status;
import model.User;

/**
 *
 * @author Jessie
 */
public class CommentDAO {
    //get all comment for a status
    public ArrayList<Comment> getCommentByStatusid(Status status, int userid){
        ArrayList<Comment> list = new ArrayList<>();
        ArrayList<User> block = new UserDAO().getBlockedUserByUserid(userid);
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "select * from CommentPost "
                    + "where statusid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, status.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                Date time = rs.getTimestamp("time");
                Status s = status;
                User u = new UserDAO().getUserByUserid(rs.getInt("userid"));
                //check whether user in the block list
                boolean add = true;
                for (User ub : block) {
                    if(u.getId() == ub.getId()){
                        add = false;
                    }
                }

                if(add){
                    list.add(new Comment(id, content, time, s, u));
                }
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //create new comment
    public void addComment(String content, int statusid, int userid){
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "insert into CommentPost(content, time, statusid, userid)"
                    + " values (?,GETDATE(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, content);
            ps.setInt(2, statusid);
            ps.setInt(3, userid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
