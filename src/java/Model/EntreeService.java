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
public class EntreeService implements DataAccessStrategy{
    private IEntreeDAO edao;
    

    public EntreeService() {
        
        DatabaseAccessor db = new DB_Generic();
        edao = new EntreeDAO(db);
    }

  

    @Override
    public List getEntreesByOrder(String[] order) throws Exception{
        String[] items = order;
        List list;
        
       list = edao.getEntreesByOrder(items);
        
        return list;
    }
    
    

    
    

    @Override
    public List<HashMap<String,Object>> getAllEntreeItems() throws Exception{
        List list;
        
        list = edao.getAllEntreeItems();
        
        return list;
    }
    
    
    
    

    @Override
    public List<HashMap<String, Object>> getEntreesByMealId(String id) throws Exception {
        List list;
        
        list = edao.getEntreesByMealId(id);
        
        return list;    
    }
    
    
    

    
    
}
