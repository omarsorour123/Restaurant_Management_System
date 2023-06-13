/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import Account.Account;

/**
 *
 * @author omars
 */
public class Employee {
   private int id;
    private Account account;
    private String name;

    public Employee(int id, Account account, String name) {
        this.id = id;
        this.account = account;
        this.name = name;
    }

    public Employee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean matches (Employee employee)
    {
        if(this.id==employee.getId())
        if(this.account.matches(employee.getAccount()))
        if(this.name.equals(employee.getName()))
         return true;
        
        return false;
         
    }

    public void clone(Employee holder) {
        this.id = holder.id;
        this.account = holder.account;
        this.name = holder.name;
    }
}
