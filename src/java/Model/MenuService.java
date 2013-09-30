/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public class MenuService implements SeviceStrategy{
    private IMenuDAO menudao;
    

    public MenuService() {
        
        DatabaseAccessor db = new DB_Generic();
        menudao = new MenuDAO(db);
    }

  

    @Override
    public Receipt calculateBill(List order) throws Exception{
        
        Receipt receipt;
        
       receipt = menudao.calculateBill(order);
        
        return receipt;
    }
    
    @Override
    public MenuItem getEntreeByEntreeId(String id)throws Exception{
        
        MenuItem item;
        
        item = menudao.getEntreeByEntreeId(id);
        return item;
    }
    
    

    
    

    @Override
    public List<MenuItem> getAllEntreeItems() throws Exception{
        List list;
        
        list = menudao.getAllEntreeItems();
        
        return list;
    }
    
    
    
    

    @Override
    public List<MenuItem> getEntreesByMealId(String id) throws Exception {
        List list;
        
        list = menudao.getEntreesByMealId(id);
        
        return list;    
    }
    
    
    

    @Override
    public int editEntreeItemById(String id, String price, String meal, String name) throws Exception{
        MenuItem item = new MenuItem();
        int count;
        
        item.setEntree_id(id);
        item.setEntree_name(name);
        item.setEntree_price(price);
        item.setMeal(meal);
        
        count = menudao.editRecordById(item);
        
        return count;
    }
    
    

    @Override
    public int addNewMenuItem(String price, String meal, String name) throws Exception {
        MenuItem item = new MenuItem();
        int count = 0;
       
        item.setEntree_name(name);
        item.setEntree_price(price);
        item.setMeal(meal);   
    
        count = menudao.addNewRecord(item);
        
    return count;
    }

    @Override
    public int deleteMenuItem(String[] item) throws Exception {
    List<MenuItem> list = new ArrayList<MenuItem>();
    MenuItem entree;
    int count = 0;
    
    for(String i : item){
         entree = new MenuItem();
         
         entree.setEntree_id(i);
         
         list.add(entree);
    }
    
    count = menudao.deleteRecord(list);
    
    return count;
   }
    
    
    

  
    
}
