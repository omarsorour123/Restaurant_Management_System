/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import DataBase.DataBaseConnection;
import Employee.Employee;
import java.sql.*;



public class Login {

public boolean checkAdminLogIn (Account account)
{ Account holder=getAdminAccount(account) ;
if(holder!=null) 
if(holder.matches(account))
      return true;
  return false;
    
}
private Account getAdminAccount(Account account)
{ Account holder=new Account ();
    DataBaseConnection d = new DataBaseConnection ();
    Connection c;
    c=d.connect();
    PreparedStatement ss;
    ResultSet rs;
    String query= "select * from admin where username =?";
    try{
        ss=c.prepareStatement(query);
        ss.setString(1, account.getUsername());
        rs=ss.executeQuery();
       if (rs.next())
       { holder.setUsername(rs.getString("username"));
        holder.setPassword(rs.getString("password")); 
       }
       else
           holder=null;
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
    return holder;
}
    public Employee checkEmployeeLogIn (Account account)
{ Employee holder=getEmployeeAccount(account) ;
    System.out.println(holder.getName());
    
  if(holder.getAccount().matches(account))
  {  
    
      return holder;
  }
  
  return null;
    
}
private Employee getEmployeeAccount(Account account)
{ Account holder=new Account ();
    DataBaseConnection d = new DataBaseConnection ();
    Connection c;
    c=d.connect();
    PreparedStatement ss;
    ResultSet rs;
    Employee emp=null;
    String query= "select * from employee where username =?";
    try{
        ss=c.prepareStatement(query);
        ss.setString(1, account.getUsername());
        rs=ss.executeQuery();
        rs.next();
   Account acc= new Account (rs.getString("username"),rs.getString("password")) ;
          emp= new Employee (rs.getInt ("id"),acc,rs.getString("name"));
    }
    
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
    return emp;
}
}
