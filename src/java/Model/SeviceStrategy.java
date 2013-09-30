/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public interface SeviceStrategy {
    
    //getting menu items upon page load
    public abstract Receipt calculateBill(List order)throws Exception;
    
     public abstract List<MenuItem> getAllEntreeItems() throws Exception;
     
     public abstract List<MenuItem> getEntreesByMealId(String id) throws Exception;
     
     public abstract MenuItem getEntreeByEntreeId(String id) throws Exception;
     
     public abstract int editEntreeItemById(String id, String price, String meal, String name) throws Exception;
     
     public abstract int addNewMenuItem(String price, String meal, String name) throws Exception;
     
     public abstract int deleteMenuItem(String[] item) throws Exception;
     
}
