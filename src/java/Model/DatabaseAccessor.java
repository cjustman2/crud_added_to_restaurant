/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public interface DatabaseAccessor {
    
    
    public abstract List<HashMap<String,Object>> findRecords(String sql, boolean closeConnection)throws SQLException, Exception;
    
    public abstract void openConnection() 
	throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
}
