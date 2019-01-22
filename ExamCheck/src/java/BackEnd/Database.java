/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Douglas
 */
public class Database {
    
    private Connection conn = null;
    
    /**
     *
     * @return Returns an instance of the sql.Connection class which is the 
     * current connection to the database.
     */
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } 
        catch (Exception ex) {
            System.out.println("Failed to register MySQL Connector/J");
            System.out.println(ex);
	    return null;
        }

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam7db","18agileteam7","8302.at7.2038");
            return conn;
        } 
        catch (SQLException ex) {
            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
	    return null;
        }
    }
    
    /**
     *
     * @param query SQL query for the database to process.
     * @return Returns results of query for the database in a sql.ResultSet object.
     */
    public ResultSet executeQuery(String query){
        try{
            Statement state = conn.createStatement();
            
            ResultSet rs = state.executeQuery(query);
            
            return rs;
        }
        catch (SQLException ex) {
            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
	    return null;
        }
    }
    
    /**
     *
     * @param query SQL query for the database to process.
     * @return Returns results of query for the database in a sql.ResultSet object.
     */
    public boolean updateQuery(String query){
        try{
            Statement state = conn.createStatement();
            
            state.executeUpdate(query);
            
            return true;
        }
        catch (SQLException ex) {
            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
	    return false;
        }
    }
}
