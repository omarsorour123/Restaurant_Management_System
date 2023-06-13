/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Product;

import Category.Category;

/**
 *
 * @author omars
 */
public class Product {
    private String name;
    private int id;
    private Category category;
    private int price;

    public Product() {
    }

    public Product(String name, int id, Category category, int price) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.price = price;
    }
public Product(String name, Category category, int price) {
        this.name = name;
 
        this.category = category;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
