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
public interface IMenuDAO {
    
    
    public abstract Receipt calculateBill(List names) throws Exception;
    
    
    public abstract List<MenuItem> getEntreesByMealId(String id) throws Exception;
    
    public abstract List<MenuItem> getAllEntreeItems() throws Exception;
    
    public abstract MenuItem getEntreeByEntreeId(String id) throws Exception;
    
    public abstract int editRecordById(MenuItem item) throws Exception;
    
    
    public abstract int addNewRecord(MenuItem item) throws Exception;
    
    public abstract int deleteRecord(List<MenuItem> list) throws Exception;
    
}
