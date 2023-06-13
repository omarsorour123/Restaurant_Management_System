/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Category;

import DataBase.DataBaseConnection;
import DataBase.DataBaseManipulation;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author omars
 */
public class ManipulateCategory implements DataBaseManipulation{

    @Override
    public void add(Object obj) {
      Category cat = (Category) obj;
        DataBaseConnection d = new DataBaseConnection ();
        Connection c ;
        c=d.connect() ;
       PreparedStatement ss;
       String query = "insert into category (name) values (?)";
       try {
       ss=c.prepareStatement(query);
       ss.setString(1, cat.getName());
      ss.execute();
        JOptionPane.showMessageDialog(null, "Category has been inserted");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }

    @Override
    public void delete(int id) {
       DataBaseConnection d = new DataBaseConnection ();
      Connection c ; 
      c= d.connect();
     PreparedStatement ss ;
     String query = "delete from category where id = ?";
    try {
        ss=c.prepareStatement(query);
        ss.setInt (1,id);
        ss.execute();
           JOptionPane.showMessageDialog(null, "Category record has been deleted");
    }
    catch (Exception e)
    {
         JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }

    @Override
    public ArrayList<Object> retrive() {
      DataBaseConnection d = new DataBaseConnection ();
       Connection c;
       ResultSet rs;
       PreparedStatement ss;
       ArrayList <Object> list = new ArrayList <Object>();
       String query = "select * from category";
       try {
          c=d.connect();
           ss=c.prepareStatement(query);
          rs=ss.executeQuery();
          while(rs.next())
          { 
            
              list.add(new Category (rs.getInt ("id"),rs.getString("name")));
          }
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return list;
    }

    @Override
    public Object search(int id) {
    DataBaseConnection d = new DataBaseConnection ();
      Connection c;
      ResultSet rs;
      PreparedStatement ss;
      Category cat = null;
      String query = "select *from Category where id = ?";
      try 
      {
          c=d.connect();
           ss=c.prepareStatement(query);
           ss.setInt(1, id);
          rs=ss.executeQuery();
          rs.next();
          
          cat= new Category (rs.getInt ("id"),rs.getString("name"));
          
          
      }
      catch (Exception e)
      {
            JOptionPane.showMessageDialog(null, e.getMessage());   
      }
      return (Object) cat;
    }

    
    
     public Object search (String name) {
    DataBaseConnection d = new DataBaseConnection ();
      Connection c;
      ResultSet rs;
      PreparedStatement ss;
      Category cat = null;
      String query = "select *from Category where name= ?";
      try 
      {
          c=d.connect();
           ss=c.prepareStatement(query);
           ss.setString(1, name);
          rs=ss.executeQuery();
          rs.next();
          
          cat= new Category (rs.getInt ("id"),rs.getString("name"));
          
          
      }
      catch (Exception e)
      {
            JOptionPane.showMessageDialog(null, e.getMessage());   
      }
      return (Object) cat;
    }
    
    @Override
    public void update(Object obj) {
       String query = "UPDATE category SET name=? WHERE id=?";
         Category cat = (Category) obj;
        DataBaseConnection d = new DataBaseConnection ();
        Connection c ;
        c=d.connect() ;
       PreparedStatement ss;
   
       try {
       ss=c.prepareStatement(query);
       ss.setString(1, cat.getName());

       ss.setInt (2,cat.getId());
      ss.execute();
        JOptionPane.showMessageDialog(null, "Category record has been updated");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    
}
