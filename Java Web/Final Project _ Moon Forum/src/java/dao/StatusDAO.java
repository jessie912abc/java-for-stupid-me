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
public class StatusDAO {

    //get all Status 
    public ArrayList<Status> select(int userid) {
        ArrayList<Status> list = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "select * from Status order by publish desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                Date publish = rs.getTimestamp("publish");
                User owner = new UserDAO().getUserByUserid(rs.getInt("ownerid"));

                Status status = new Status(id, content, publish, owner);
                ArrayList<Comment> comment = new CommentDAO().getCommentByStatusid(status, userid);
                status.setComment(comment);

                ArrayList<User> like = new UserDAO().getLikeUsersByStatusId(id);
                status.setLike(like);

                list.add(status);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get user's status
    public ArrayList<Status> getUserStatus(User u) {
        ArrayList<Status> list = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "select Status.* \n"
                    + "from Status join Users on Status.ownerid = Users.id\n"
                    + "where Users.id = ? \n"
                    + "order by publish desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                Date publish = rs.getTimestamp("publish");
                User owner = u;

                Status status = new Status(id, content, publish, owner);
                ArrayList<Comment> comment = new CommentDAO().getCommentByStatusid(status, u.getId());
                status.setComment(comment);

                ArrayList<User> like = new UserDAO().getLikeUsersByStatusId(id);
                status.setLike(like);

                list.add(status);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get home status for users
    public ArrayList<Status> getHomeStatusByUserid(User u) {
        ArrayList<Status> list = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "select Status.* \n"
                    + "from Status join Users on Status.ownerid = Users.id\n"
                    + "where Users.id = ? or Users.id in (\n"
                    + "select followee\n"
                    + "from Follow where follower = ? \n"
                    + "except\n"
                    + "select blockid\n"
                    + "from Block\n"
                    + ") \n"
                    + "order by publish desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.setInt(2, u.getId());
            ResultSet rs = ps.executeQuery();
            UserDAO udao = new UserDAO();

            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                Date publish = rs.getTimestamp("publish");
                User owner = udao.getUserByUserid(rs.getInt("ownerid"));

                Status status = new Status(id, content, publish, owner);
                ArrayList<Comment> comment = new CommentDAO().getCommentByStatusid(status, u.getId());
                status.setComment(comment);

                ArrayList<User> like = new UserDAO().getLikeUsersByStatusId(id);
                status.setLike(like);

                list.add(status);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //create Status
    public void createNewStatus(String content, User u) {
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "insert into Status (content, publish, ownerid) "
                    + "values (?,GETDATE(),?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, content);
            ps.setInt(2, u.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update like
    public void updateLike(int statusid, int userid) {
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "insert into LikePost(statusid, userid) "
                    + "values (?,?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, statusid);
            ps.setInt(2, userid);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //get status
    public Status getStatusById(int statusid, int userid) {
        ArrayList<Status> list = select(userid);
        for (Status status : list) {
            if (status.getId() == statusid) {
                return status;
            }
        }
        return null;
    }

    //get saved status
    public ArrayList<Status> getSavedStatus(User u) {
        ArrayList<Status> list = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "select Status.* \n"
                    + "from Status \n"
                    + "where id in(\n"
                    + "select statusid\n"
                    + "from SavePost join Users on SavePost.userid = Users.id\n"
                    + "where userid = ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                Date publish = rs.getTimestamp("publish");
                UserDAO udao = new UserDAO();
                User owner = udao.getUserByUserid(rs.getInt("ownerid"));

                Status status = new Status(id, content, publish, owner);
                ArrayList<Comment> comment = new CommentDAO().getCommentByStatusid(status, u.getId());
                status.setComment(comment);

                ArrayList<User> like = new UserDAO().getLikeUsersByStatusId(id);
                status.setLike(like);

                list.add(status);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //save new status
    public void saveStatus(int statusid, int userid) {
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "insert into SavePost(statusid, userid) "
                    + "values (?,?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, statusid);
            ps.setInt(2, userid);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //unsave status
    public void unsaveStatus(int statusid, int userid) {
        try {
            Connection conn = new DBContext().getConnection();
            String sql = "delete from SavePost "
                    + "where  statusid= ? and userid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, statusid);
            ps.setInt(2, userid);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
