/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public class DB_Generic implements DatabaseAccessor{
    private Connection conn;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    
    public void openConnection() 
	throws IllegalArgumentException, ClassNotFoundException, SQLException
	{
		String msg = "Error: url is null or zero length!";
                this.driverClassName = "com.mysql.jdbc.Driver";
                this.url = "jdbc:mysql://localhost:3306/restaurant";
                this.username = "chris";
                this.password = "admin";
		if( url == null || url.length() == 0 ) throw new IllegalArgumentException(msg);
		username = (username == null) ? "" : username;
		password = (password == null) ? "" : password;
                Class.forName (driverClassName);
		conn = DriverManager.getConnection(url, username, password);
	}
	
    
    
    
    

    @Override
 	public List<HashMap<String,Object>> findRecords(String sqlString, boolean closeConnection) 
	throws SQLException, Exception
	{
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData metaData = null;
		final List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		Map record = null;
             

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
                       
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlString);
			metaData = rs.getMetaData();
			final int fields=metaData.getColumnCount();

			while( rs.next() ) {
				record = new HashMap<String,Object>();
				for( int i=1; i <= fields; i++ ) {
					try {
						record.put( metaData.getColumnName(i), rs.getObject(i) );
					} catch(NullPointerException npe) { 
						// no need to do anything... if it fails, just ignore it and continue
					}
				} // end for
				list.add((HashMap<String, Object>) record);
			} // end while

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				stmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return list; // will  be null if none found
	}

    
}
