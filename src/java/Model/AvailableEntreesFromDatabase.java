/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chris
 */
public class AvailableEntreesFromDatabase implements RetrieveAvailableEntreeStrategy{
        HashMap<String,String> map = new HashMap();
    @Override
    public HashMap<String,String> getAvailableEntrees() {
        
        
        map.put("Beef", "19.00");
        map.put("Chicken", "5.00");
        map.put("Beer", "3.00");
        map.put("Wine", "4.00");
        map.put("Salad", "6.00");
        map.put("Prime Rib", "20.00");
        map.put("Soda", "2.00");
    
            
            
        
     return map;   
    }
    
}
