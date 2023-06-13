/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patterns;

import java.util.regex.Pattern;

/**
 *
 * @author omars
 */
public class Validate {
    public  boolean validateEmail (String EMail)
    {
return  ( Pattern.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$",EMail ));
    }
    public  boolean validatePhoneNumber(String phoneNumber)
   {
            return  ( Pattern.matches("\\d{11}",phoneNumber ));  
   }
}
