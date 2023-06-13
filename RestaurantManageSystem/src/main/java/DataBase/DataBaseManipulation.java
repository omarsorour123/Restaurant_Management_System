/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataBase;

import java.util.ArrayList;

/**
 *
 * @author omars
 */
public interface DataBaseManipulation {
 public void add(Object obj);
 public void delete (int id);
 public ArrayList<Object> retrive();
 public Object search (int id);
 public void update (Object obj);
}
