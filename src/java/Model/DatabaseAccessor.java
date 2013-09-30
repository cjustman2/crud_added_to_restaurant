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
    
    
    public abstract List findRecords(String sql, boolean closeConnection)throws SQLException, Exception;
    
    public abstract void openConnection() 
	throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    public abstract int editRecord(String sql, boolean closeDatabaseConnection) throws Exception;
    
    public abstract int addRecord(String sql, boolean closeDatabaseConnection)throws Exception;
    
    public abstract int deleteRecord(String sql, boolean closeDatabaseConnection)throws Exception;
    
}
