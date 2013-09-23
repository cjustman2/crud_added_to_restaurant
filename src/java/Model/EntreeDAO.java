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
public class EntreeDAO implements IEntreeDAO{
    private  String GET_ENTREES_BY_NAME = "SELECT * FROM entrees WHERE entree_name = ";
    private static String GET_ALL_ENTREES = "SELECT entree_name FROM entrees";
    private  String GET_ENTREES_BY_MEAL_ID = "SELECT entree_name FROM entrees WHERE meal_id = ";
    private DatabaseAccessor db;

    
    
   

    public EntreeDAO(DatabaseAccessor db) {
        this.db = db;
    }
    
    
    

    @Override
    public List getEntreesByOrder(String[] names) throws Exception{
        String[] items = names;
        List list = new ArrayList();
        
        for(int i=0; i<items.length; i++){
            if(i == (items.length - 1)){
                 GET_ENTREES_BY_NAME +=  items[i];
                 
            }else{
               GET_ENTREES_BY_NAME +=  items[i] + " OR entree_name = ";
            }
        }
        
            db.openConnection();
            list = db.findRecords(GET_ENTREES_BY_NAME, true);
      
        
        
        
        return list;
    }

    
    
    
    
    
    
    @Override
    public List<HashMap<String,Object>> getEntreesByMealId(String id) throws Exception{
        List list;
        
        GET_ENTREES_BY_MEAL_ID += id;
        db.openConnection();
        
        list = db.findRecords(GET_ENTREES_BY_MEAL_ID, true);
        
        return list;
    }
    
    
    
    

    @Override
    public List<HashMap<String,Object>> getAllEntreeItems() throws Exception{
        List list = new ArrayList();
        db.openConnection();
        list = db.findRecords(GET_ALL_ENTREES, true);
        
        return list;
    }
    
   
}