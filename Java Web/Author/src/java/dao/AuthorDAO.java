/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Author;

/**
 *
 * @author Jessie
 */
public class AuthorDAO extends BaseDAO{
    //insert new author
    public void insertNewAuthor(String authorName, int aid){
        try {
           String sql = "insert into Author(name, aid) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, authorName);
            ps.setInt(2, aid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //select list author for an article
    public ArrayList<Author> listAuthorByArticle(int aid){
        ArrayList<Author> list = new ArrayList<>();
        try {
            String sql = "select Author.id, Author.name from Author "
                    + "where aid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, aid);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new Author(id, name));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //delete old author
    public void deleteAuthor(int aid){
        try {
            String sql = "delete from Author "
                    + "where aid = ?";
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
