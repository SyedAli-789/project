package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtility {

	public static Connection getDBConnection() {
		
	String DATASOURCE_CONTEXT = "java:comp/env/jdbc/crudDB";
    
    	Connection result = null;
    	try {
      		Context initialContext = new InitialContext();
      		if ( initialContext == null){
			log("JNDI problem. Cannot get InitialContext.");
      		}
      		DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
      		if (datasource != null) {
        		result = datasource.getConnection();
      		}
      		else {
       	 		log("Failed to lookup datasource.");
      		}
    	}
    	catch ( NamingException ex ) {
     	 log("Cannot get connection: " + ex);
    	}
    	catch(SQLException ex){
     	 log("Cannot get connection: " + ex);
    	}
    	return result;
    }
}
