/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.restaurantmanagesystem;
import Account.Account;
import Account.Login;
import Bill.Bill;
import Bill.ManipulateBill;
import Category.*;
import DataBase.DataBaseConnection;
import Employee.*;
import Patterns.Validate;
import Product.ManipulateProduct;
import Product.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 

public class RestaurantManageSystem {
 
    public static void main(String[] args) throws SQLException  {
        
   Validate validate = new Validate();
   String email="011403700380";
   if(validate.validatePhoneNumber(email))
            System.out.println("right");
   else
            System.out.println("wrong");
  
}
}
