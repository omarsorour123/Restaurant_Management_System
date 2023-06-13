/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import Account.Account;
import DataBase.*;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author omars
 */
public class ManipulateEmployee implements DataBaseManipulation {

    @Override
    public void add(Object obj) {
       Employee emp = (Employee) obj;
        DataBaseConnection d = new DataBaseConnection ();
        Connection c ;
        c=d.connect() ;
       PreparedStatement ss;
       String query = "insert into employee (username,password,name) values (?,?,?)";
       try {
       ss=c.prepareStatement(query);
       ss.setString(1, emp.getAccount().getUsername());
       ss.setString(2, emp.getAccount().getPassword());
       ss.setString(3, emp.getName());
      ss.execute();
        JOptionPane.showMessageDialog(null, "employee has been inserted");
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
     String query = "delete from employee where id = ?";
    try {
        ss=c.prepareStatement(query);
        ss.setInt (1,id);
        ss.execute();
           JOptionPane.showMessageDialog(null, "employee has been deleted");
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
       String query = "select * from employee";
       try {
          c=d.connect();
           ss=c.prepareStatement(query);
          rs=ss.executeQuery();
          while(rs.next())
          {  Account account= new Account (rs.getString("username"),rs.getString("password")) ;
            
              list.add(new Employee (rs.getInt ("id"),account,rs.getString("name")));
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
      Employee emp = null;
      String query = "select *from employee where id = ?";
      try 
      {
          c=d.connect();
           ss=c.prepareStatement(query);
           ss.setInt(1, id);
          rs=ss.executeQuery();
          rs.next();
          Account account= new Account (rs.getString("username"),rs.getString("password")) ;
          emp= new Employee (rs.getInt ("id"),account,rs.getString("name"));
          
          
      }
      catch (Exception e)
      {
            JOptionPane.showMessageDialog(null, e.getMessage());   
      }
      return (Object) emp;
    }

    @Override
    public void update(Object obj) {
        String query = "UPDATE employee SET username=?,password=?,name=? WHERE id= ?";
         Employee emp = (Employee) obj;
        DataBaseConnection d = new DataBaseConnection ();
        Connection c ;
        c=d.connect() ;
       PreparedStatement ss;
   
       try {
       ss=c.prepareStatement(query);
       ss.setString(1, emp.getAccount().getUsername());
       ss.setString(2, emp.getAccount().getPassword());
       ss.setString(3, emp.getName());
       ss.setInt (4,emp.getId());
      ss.execute();
        JOptionPane.showMessageDialog(null, "employee has been updated");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
}
