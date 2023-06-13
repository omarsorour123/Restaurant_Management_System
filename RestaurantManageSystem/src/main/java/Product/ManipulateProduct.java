/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Product;

import Category.Category;
import Category.ManipulateCategory;
import DataBase.DataBaseConnection;
import DataBase.DataBaseManipulation;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author omars
 */
public class ManipulateProduct implements DataBaseManipulation {

    @Override
    public void add(Object obj) {
         Product pro = (Product) obj;
        DataBaseConnection d = new DataBaseConnection ();
        Connection c ;
        c=d.connect() ;
       PreparedStatement ss;
       ManipulateCategory mani= new ManipulateCategory (); 
       String query = "insert into product (name,Category,price) values (?,?,?)";
       try {
       ss=c.prepareStatement(query);
       ss.setString(1, pro.getName());
       Category category =(Category) mani.search(pro.getCategory().getId());
       ss.setInt(2,category.getId() );
       ss.setInt(3,pro.getPrice());
      ss.execute();
        JOptionPane.showMessageDialog(null, "Product has been inserted");
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
     String query = "delete from product where id = ?";
    try {
        ss=c.prepareStatement(query);
        ss.setInt (1,id);
        ss.execute();
           JOptionPane.showMessageDialog(null, "Product has been deleted");
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
       ManipulateCategory mani = new ManipulateCategory(); 
       ArrayList <Object> list = new ArrayList <Object>();
       String query = "select * from product order by category";
       try {
          c=d.connect();
           ss=c.prepareStatement(query);
          rs=ss.executeQuery();
          while(rs.next())
          {  Category category =(Category) mani.search(rs.getInt("category"));
            
              list.add(new Product (rs.getString("name"),rs.getInt ("id"),category,rs.getInt("price")));
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
      Product product= null;
      ManipulateCategory mani = new ManipulateCategory();
      Category category;
      String query = "select *from product where id = ?";
      try 
      {
          c=d.connect();
           ss=c.prepareStatement(query);
           ss.setInt(1, id);
          rs=ss.executeQuery();
          rs.next();
         category =(Category) mani.search(rs.getInt("category"));
          product= new Product (rs.getString("name"),rs.getInt ("id"),category,rs.getInt("price"));
          
          
      }
      catch (Exception e)
      {
            JOptionPane.showMessageDialog(null, e.getMessage());   
      }
      return (Object) product;
    }

    @Override
    public void update(Object obj) {
        String query = "UPDATE product SET name=?,category=?,price=? WHERE id=?";
         Product product = (Product) obj;
         ManipulateCategory mani = new ManipulateCategory ();
         Category category;
        DataBaseConnection d = new DataBaseConnection ();
        Connection c ;
        c=d.connect() ;
       PreparedStatement ss;
     category =(Category) mani.search(product.getCategory().getId());
       try {
       ss=c.prepareStatement(query);
       ss.setString(1, product.getName());

       ss.setInt (2,category.getId());
       ss.setInt(3, product.getPrice());
       ss.setInt(4,product.getId());
      ss.execute();
        JOptionPane.showMessageDialog(null, "Product record has been updated");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }

  public ArrayList<Object> retrive(int cat) {
         DataBaseConnection d = new DataBaseConnection ();
       Connection c;
       ResultSet rs;
       PreparedStatement ss;
       ManipulateCategory mani = new ManipulateCategory(); 
       ArrayList <Object> list = new ArrayList <Object>();
       String query = "select * from product where category = ? order by category";
       try {
          c=d.connect();
           ss=c.prepareStatement(query);
           ss.setInt(1,cat);
          rs=ss.executeQuery();
          while(rs.next())
          {  Category category =(Category) mani.search(rs.getInt("category"));
            
              list.add(new Product (rs.getString("name"),rs.getInt ("id"),category,rs.getInt("price")));
          }
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return list;
    }
   public ArrayList<Object> retrive(String name,int cat) {
         DataBaseConnection d = new DataBaseConnection ();
       Connection c;
       ResultSet rs;
       PreparedStatement ss;
       ManipulateCategory mani = new ManipulateCategory(); 
       ArrayList <Object> list = new ArrayList <Object>();
       String query = "select * from product where name like ? and category = ? order by category";
       try {
          c=d.connect();
           ss=c.prepareStatement(query);
           ss.setString(1,"%" + name+ "%");
           ss.setInt (2,cat);
          rs=ss.executeQuery();
          while(rs.next())
          {  Category category =(Category) mani.search(rs.getInt("category"));
            
              list.add(new Product (rs.getString("name"),rs.getInt ("id"),category,rs.getInt("price")));
          }
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return list;
    }
   public Product retriveByName(String name) {
         DataBaseConnection d = new DataBaseConnection ();
       Connection c;
       ResultSet rs;
       PreparedStatement ss;
       Product  product=null;
       ManipulateCategory mani = new ManipulateCategory(); 
       ArrayList <Object> list = new ArrayList <Object>();
       String query = "select * from product where name = ? order by category";
       try {
          c=d.connect();
           ss=c.prepareStatement(query);
           ss.setString(1,  name);
           
          rs=ss.executeQuery();
          while(rs.next())
          {  Category category =(Category) mani.search(rs.getInt("category"));
            
            product = new Product (rs.getString("name"),rs.getInt ("id"),category,rs.getInt("price"));
          }
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return product;
    }
    }

    

