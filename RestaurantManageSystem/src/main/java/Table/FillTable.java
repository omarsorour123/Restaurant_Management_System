/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

import Category.*;
import Product.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author omars
 */
public class FillTable {
    public void filltableCategory(JTable table) throws SQLException
  {
     ArrayList <Object>  arr = new ArrayList ();
     ManipulateCategory mani = new ManipulateCategory(); 
     arr=mani.retrive();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
     for(int i=0;i<arr.size();i++)
     {     
      
         Category category = (Category)arr.get(i);
        
   
    dtm.addRow(new Object[]{category.getId(),category.getName()});
     
     }
  }
    public void fillTableProduct(JTable table) throws SQLException
  {
     ArrayList <Object>  arr = new ArrayList ();
   ManipulateProduct mani = new ManipulateProduct ();
     arr=mani.retrive();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
     for(int i=0;i<arr.size();i++)
     {     
      
         Product product = (Product)arr.get(i);
        
   
    dtm.addRow(new Object[]{product.getId(),product.getName(),product.getCategory().getName(),product.getPrice()});
     
     }
  }
     public void fillTableProductByCategory(JTable table,int category) throws SQLException
  {
     ArrayList <Object>  arr = new ArrayList ();
   ManipulateProduct mani = new ManipulateProduct ();
     arr=mani.retrive(category);
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
     for(int i=0;i<arr.size();i++)
     {     
      
         Product product = (Product)arr.get(i);
        
   
    dtm.addRow(new Object[]{product.getName(),product.getId(),product.getCategory().getName(),product.getPrice()});
     
     }
  }
}
