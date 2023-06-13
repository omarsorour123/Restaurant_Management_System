/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import DataBase.DataBaseConnection;
import DataBase.DataBaseManipulation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author omars
 */
public class ManipulateBill implements DataBaseManipulation {

    @Override
    public void add(Object obj) {
        Bill bill = (Bill) obj;
        DataBaseConnection d = new DataBaseConnection ();
        Connection c ;
        c=d.connect() ;
       PreparedStatement ss;
       String query = "insert into bill  values (?,?,?,?,?,?,?)";
       try {
       ss=c.prepareStatement(query);
      ss.setInt(1, bill.getId());
      ss.setString(2, bill.getName());
      ss.setString(3, bill.getPhoneNumber());
      ss.setString(4, bill.getEmail());
      ss.setString(5, bill.getDate());  
      ss.setInt(6, bill.getTotal());
      ss.setInt(7, bill.getEmployeeId());
      ss.execute();
        JOptionPane.showMessageDialog(null, "bill has been inserted");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }

    @Override
    public void delete(int id) {
       
    }

    @Override
    public ArrayList<Object> retrive() {
        DataBaseConnection d = new DataBaseConnection ();
       Connection c;
       ResultSet rs;
       PreparedStatement ss;
       ArrayList <Object> list = new ArrayList <Object>();
       String query = "select * from bill";
       try {
          c=d.connect();
           ss=c.prepareStatement(query);
          rs=ss.executeQuery();
          while(rs.next())
          { 
            
              list.add(new Bill(rs.getInt("id"),rs.getString("name"),rs.getString("phone"),rs.getString("email"),rs.getString("date"),rs.getInt("total"),rs.getInt("employee")) );
          }
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return list;
    }
public ArrayList<Object> retrive(String date) {
        DataBaseConnection d = new DataBaseConnection ();
       Connection c;
       ResultSet rs;
       PreparedStatement ss;
       ArrayList <Object> list = new ArrayList <Object>();
       String query = "select * from bill where date =?";
       try {
          c=d.connect();
           ss=c.prepareStatement(query);
           ss.setString(1, date);
          rs=ss.executeQuery();
          while(rs.next())
          { 
            
              list.add(new Bill(rs.getInt("id"),rs.getString("name"),rs.getString("phone"),rs.getString("email"),rs.getString("date"),rs.getInt("total"),rs.getInt("employee")) );
          }
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return list;
    }
 public String maxId () throws SQLException
 { int id=1;
     DataBaseConnection d = new DataBaseConnection () ;
  Connection c; 
  PreparedStatement ss;
  ResultSet rs;
  String query = "select max(id)from bill";
   c=d.connect();
   ss=c.prepareStatement(query);
   rs=ss.executeQuery();
  while(rs.next())
    id+=rs.getInt(1);
  return String.valueOf(id);
     
 }
    @Override
    public Object search(int id) {
return null;
    }

    @Override
    public void update(Object obj) {
       
    }
    
}
