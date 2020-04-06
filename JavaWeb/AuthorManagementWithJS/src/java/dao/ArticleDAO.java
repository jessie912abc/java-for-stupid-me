/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Article;
import model.Author;

/**
 *
 * @author Jessie
 */
public class ArticleDAO extends BaseDAO{
    //insert new Article
    public void insertArticle(Article a){
        try {
            String sql = "insert into Article(id,title, publishedDate) values (?,?,?)";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getTitle());
            ps.setDate(3, a.getPublishedDate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //get list article
    public ArrayList<Article> listArticle(){
        ArrayList<Article> list = new ArrayList<>();
        try {
            String sql = "select * from Article";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date publishedDate = rs.getDate("publishedDate");
                ArrayList<Author> author = new AuthorDAO().listAuthorByArticle(id);
                
                list.add(new Article(id, title, publishedDate, author));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //get Article by id
    public Article getArticleById(int id){
        ArrayList<Article> list = listArticle();
        for (Article article : list) {
            if(article.getId() == id){
                return article;
            }
        }
        return null;
    }
    
    //edit article
    public void editArticle(Article article){
        try {
            String sql = "update Article "
                    + "set title = ?, publishedDate = ? "
                    + "where id = ?";
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setDate(2, article.getPublishedDate());
            ps.setInt(3, article.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //delete article
    public void deleteArticle(int id){
        try {
            new AuthorDAO().deleteAuthor(id);
            String sql = "delete from Article "
                    + "where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
