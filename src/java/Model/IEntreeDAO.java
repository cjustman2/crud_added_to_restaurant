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
public interface IEntreeDAO {
    
    
    public abstract List getEntreesByOrder(String[] names) throws Exception;
    
    
    public abstract List<HashMap<String,Object>> getEntreesByMealId(String id) throws Exception;
    
    public abstract List<HashMap<String,Object>> getAllEntreeItems() throws Exception;
    
}
