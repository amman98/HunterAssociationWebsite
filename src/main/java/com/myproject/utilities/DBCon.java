package com.myproject.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Amman Nega
 * 
 * This class is a utility used to connect to our database.
 */
public class DBCon {
    private static Connection con = null;
    
    // URL should work on any computer
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=HunterAssociation;integratedSecurity=true";
    private static final String username = "LAPTOP-7UIV5OG9\\Amman Nega";
    
    public static Connection getConnection() {
        if(con==null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            	con = DriverManager.getConnection(URL);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    
    public static void closeConnection() {
        try {
            if(con != null && !con.isClosed()) {
                con.close();
            }
            con = null;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
