/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author chris
 */
public class MenuItem {
    
    private String entree_name;
    private String entree_price;
    private String meal;
    private String entree_id;
    private String meal_id;

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    
    
    
    public String getEntree_id() {
        return entree_id;
    }

    public void setEntree_id(String entree_id) {
        this.entree_id = entree_id;
    }
    
    
    public String getEntree_name() {
        return entree_name;
    }

    public void setEntree_name(String entree_name) {
        this.entree_name = entree_name;
    }

    public String getEntree_price() {
        return entree_price;
    }

    public void setEntree_price(String entree_price) {
        this.entree_price = entree_price;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }
    
    
    
    
}
