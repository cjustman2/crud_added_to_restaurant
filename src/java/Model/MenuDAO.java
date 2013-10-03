/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class MenuDAO implements IMenuDAO{
  
    private  String GET_BY_ID = "SELECT entrees.entree_id, entrees.entree_name, meal.meal_name, meal.meal_id, entrees.price_amount FROM entrees JOIN"
            + " meal ON entrees.meal_id = meal.meal_id WHERE entrees.entree_id = ";
    
    private static String GET_ALL_ENTREES = "SELECT entrees.entree_id, entrees.entree_name, meal.meal_name, entrees.price_amount FROM entrees JOIN"
            + " meal ON entrees.meal_id = meal.meal_id";
    
    private  String GET_ENTREES_BY_MEAL_ID = "SELECT entrees.entree_id, entrees.entree_name, meal.meal_name, entrees.price_amount FROM entrees JOIN"
            + " meal ON entrees.meal_id = meal.meal_id WHERE entrees.meal_id = ";
    
    
    private String DELETE_RECORD = "DELETE FROM entrees WHERE entree_id = ";
    
    
    private DatabaseAccessor db;
    
    
    
   

    public MenuDAO(DatabaseAccessor db) {
        this.db = db;
    }
    
    
    

    @Override
    public Receipt calculateBill(List names) throws Exception{
        List<MenuItem> item = new ArrayList();
        List<Map> list;
        Receipt receipt = new Receipt();;
        MenuItem entree = null;
        double total = 0;
        double tip = 0;
        
            
           
            
            for(int i = 0; i < names.size(); i++){
                
                 db.openConnection();
                 list = db.findRecords(GET_BY_ID + "'"+names.get(i)+"'", true);
                    
                    for(Map m : list){
                        
                        entree = new MenuItem();
                        
                        String name = m.get("entree_name").toString();
                        entree.setEntree_name(name);
                        String id = m.get("entree_id").toString();
                        entree.setEntree_id(id);
                        String price = m.get("price_amount").toString();
                        entree.setEntree_price(price);
                        String meal = m.get("meal_name").toString();
                        entree.setMeal(meal);
                        
                        
                             
                        item.add(entree);
                        receipt.setItems(item);
                        receipt.setTotal(Double.parseDouble(price));
                    }
            }
            
            
           
           
           receipt.setTotal(total);
           
        
        return receipt;
    }

    
    
    
    
    
    
    @Override
    public List<MenuItem> getEntreesByMealId(String id) throws Exception{
      List<Map> list;
        List<MenuItem> items = new ArrayList<MenuItem>();
        
         db.openConnection();
         
         
        list = db.findRecords(GET_ENTREES_BY_MEAL_ID + id, true);
        
      
       MenuItem entree = null;
       
       
        // Translate List<Map> into List<Employee>
        for (Map m : list) {
           entree = new MenuItem();

            String name = m.get("entree_name").toString();
            entree.setEntree_name(name);
            String meal = m.get("meal_name").toString();
            entree.setMeal(meal);
            String price = m.get("price_amount").toString();
            entree.setEntree_price(price);
            String entree_id = m.get("entree_id").toString();
            entree.setEntree_id(entree_id);

            items.add(entree);
        }

        return items;
    }
    
    
    
    

    @Override
    public List<MenuItem> getAllEntreeItems() throws Exception{
        List<Map> list = new ArrayList<Map>();
        List<MenuItem> items = new ArrayList<MenuItem>();
        
         db.openConnection();
         
         
        list = db.findRecords(GET_ALL_ENTREES, true);
        
      
       MenuItem entree = null;
       
       
        
        for (Map m : list) {
           entree = new MenuItem();

            String name = m.get("entree_name").toString();
            entree.setEntree_name(name);
            String meal = m.get("meal_name").toString();
            entree.setMeal(meal);
            String price = m.get("price_amount").toString();
            entree.setEntree_price(price);
            String entree_id = m.get("entree_id").toString();
            entree.setEntree_id(entree_id);
            
            items.add(entree);
        }

        return items;
        
        
    }
    
    
    
    
   @Override
    public MenuItem getEntreeByEntreeId(String Id)throws Exception{
        MenuItem item = null;
        List<Map> list;
        
        
        db.openConnection();
         
         
        list = db.findRecords(GET_BY_ID + Id, true);
        
        
    for (Map m : list) {
           item = new MenuItem();

            String name = m.get("entree_name").toString();
            item.setEntree_name(name);
            String meal = m.get("meal_name").toString();
            item.setMeal(meal);
            String price = m.get("price_amount").toString();
            item.setEntree_price(price);
            String entree_id = m.get("entree_id").toString();
            item.setEntree_id(entree_id);
            String meal_id = m.get("meal_id").toString();
            item.setMeal_id(meal_id);
            
            
        }
        
        return item;
    }
   
   
   
   
   

    @Override
    public int editRecordById(MenuItem item) throws Exception{
        String name = null;
        String price = null;
        String meal = null;
        String id = null;
        int count = 0;
        
        name = item.getEntree_name().toString();
        price = item.getEntree_price().toString();
        meal = item.getMeal().toString();
        id = item.getEntree_id().toString();
        
  String EDIT_RECORD = "UPDATE entrees SET entree_name = '" + name + "', price_amount = '" + price + "',"
          + " meal_id = " + meal + " WHERE entree_id = " + id + ";";
        
        
             db.openConnection();
         
         
       count = db.editRecord(EDIT_RECORD, true);
        
        
        return count;
    }
    
    
    
    
    
    

    @Override
    public int addNewRecord(MenuItem item) throws Exception {
       String name = null;
        String price = null;
        int meal = 0;
       
        int count = 0;
        
        name = item.getEntree_name().toString();
        price = item.getEntree_price().toString();
        meal = Integer.parseInt(item.getMeal().toString());
       
        
  String ADD_RECORD = "INSERT INTO entrees(entree_name, price_amount, meal_id) VALUES ('"+name+"','"+price+
          "',"+meal+");";
         
      
        
        
             db.openConnection();
         
         
       count = db.addRecord(ADD_RECORD, true);
        
        
        return count;    
    }

    
    
    
    
    
    @Override
    public int deleteRecord(List<MenuItem> list) throws Exception {
       
        int count = 0;
        String id = null;
        int total = 0;
        
        
        
        for(MenuItem item : list){
            
           
            
            id = item.getEntree_id().toString();
            
             db.openConnection();
         
         
       count = db.deleteRecord(DELETE_RECORD + id, true);
       
       
       
                 
        total += 1;
                    
       
        }
        
        
        return total;
    }
    
   
}