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
public interface DataAccessStrategy {
    
    //getting menu items upon page load
    public abstract List getEntreesByOrder(String[] order)throws Exception;
    
     public abstract List<HashMap<String,Object>> getAllEntreeItems() throws Exception;
     
     public abstract List<HashMap<String,Object>> getEntreesByMealId(String id) throws Exception;
}
