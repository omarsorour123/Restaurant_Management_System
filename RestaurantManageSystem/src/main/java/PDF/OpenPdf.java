/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDF;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author omars
 */
public class OpenPdf {
 public static void openById (String id)
 {  try {
        Desktop desktop = Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.open(new File( "F:\\RestaurantSystem\\Orders\\"+id+".pdf"));
        } else {
            System.out.println("Open is not supported");
        }
    } catch (IOException exp) {
        exp.printStackTrace();
    }
 
 }
}
