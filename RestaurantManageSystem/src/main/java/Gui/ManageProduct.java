/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Category.Category;
import Category.ManipulateCategory;
import Product.ManipulateProduct;
import Product.Product;
import Table.FillTable;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author omars
 */
public class ManageProduct extends javax.swing.JFrame {
 private  ArrayList <Object>  arr;
    /**
     * Creates new form ManageCategory
     */
    public ManageProduct() {
        initComponents();
        btnUpdate.setEnabled(false);
  btnDelete.setEnabled(false);
  idLabel.setVisible(false);
               FillTable ta = new FillTable ();
       try { 
       ta.fillTableProduct(jTable1);
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
       }
       jTable1.setDefaultEditor(Object.class, null);
       arr = new ArrayList ();
     ManipulateCategory mani = new ManipulateCategory(); 
     arr=mani.retrive();

     for(int i=0;i<arr.size();i++)
     {
         Category category =(Category) arr.get(i);
         jComboBox1.addItem(category.getName());
     }
  jComboBox1.remove(0);
  
    }
    public void validateInput ( )
   {
       String name = nameText.getText();
       String price = priceText.getText();
       if(!name.equals("")&&!price.equals(""))
           btnUpdate.setEnabled(true);
       else
           btnUpdate.setEnabled(false);
   }
 public void reset ()
 {
     nameText.setText("");
       priceText.setText("");
       idLabel.setVisible(false);
       btnDelete.setEnabled(false);
       btnUpdate.setEnabled(false);
        FillTable ta = new FillTable ();
       try { 
       ta.fillTableProduct(jTable1);
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
       }
       jTable1.setDefaultEditor(Object.class, null);
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        priceText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 768, 1366));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(100, 30));
        setMinimumSize(new java.awt.Dimension(1366, 700));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 235, 55, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 294, 55, 23));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Category:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 355, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Price:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 410, 70, -1));

        idLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        idLabel.setText("00");
        getContentPane().add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 235, 28, -1));

        nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextKeyReleased(evt);
            }
        });
        getContentPane().add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 297, 186, -1));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 353, 186, -1));

        priceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextActionPerformed(evt);
            }
        });
        priceText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceTextKeyReleased(evt);
            }
        });
        getContentPane().add(priceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 411, 186, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("F:\\RestaurantSystem\\Icons\\french-fries.png")); // NOI18N
        jLabel6.setText("ManageProduct");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 174, 30));

        btnUpdate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon("F:\\RestaurantSystem\\Icons\\add.png")); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 462, -1, -1));

        btnDelete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon("F:\\RestaurantSystem\\Icons\\delete.png")); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 462, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("F:\\RestaurantSystem\\Icons\\cross.png")); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 19, 34, 23));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Category", "Price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, -1, 437));

        jLabel9.setIcon(new javax.swing.ImageIcon("F:\\RestaurantSystem\\Icons\\full-page-background.PNG")); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel tm = jTable1.getModel();
        String name = tm.getValueAt(index, 1).toString();
        nameText.setText(name);
        String id = tm.getValueAt(index, 0).toString();
        
        idLabel.setText(id);
         idLabel.setVisible(true);
        String category = tm.getValueAt(index, 2).toString();
        String price = tm.getValueAt(index, 3).toString();
        priceText.setText(price);
       jComboBox1.removeAllItems();
       jComboBox1.addItem(category);
       for(int i=0;i<arr.size();i++)
     {
         Category categoryy =(Category) arr.get(i);
         if(!categoryy.getName().equals(category))
         jComboBox1.addItem(categoryy.getName());
         
     }
       btnUpdate.setEnabled(true);
       btnDelete.setEnabled(true);
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyReleased
validateInput ();
// TODO add your handling code here:
    }//GEN-LAST:event_nameTextKeyReleased

    private void priceTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTextKeyReleased
validateInput();        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       int index =JOptionPane.showConfirmDialog(null, "are you sure you want to delete " + nameText.getText(),"delete",JOptionPane.YES_NO_OPTION);
       if(index==0) 
       {  int id = parseInt(idLabel.getText());
       ManipulateProduct mani = new ManipulateProduct ();
       mani.delete(id);
       reset();
       
       }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
 
       int categoryId;
       Category category =null;
       for(int i=0;i<arr.size();i++)
       {
          category = (Category)arr.get(i);
           if(category.getName().equals( jComboBox1.getSelectedItem().toString()))
            break; 
       }
       String name = nameText.getText();
       String price=priceText.getText();
       String id = idLabel.getText();
       Product product = new Product(name,parseInt(id),category,parseInt(price));   
       ManipulateProduct mani = new ManipulateProduct();
       mani.update(product);
       reset();
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel idLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField priceText;
    // End of variables declaration//GEN-END:variables
}