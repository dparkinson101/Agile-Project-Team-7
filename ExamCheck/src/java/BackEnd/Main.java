package BackEnd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas
 */

import java.sql.*;

public class Main 
{
    
    public boolean loginHandle(String username, String password){
        if(username.equals("admin") && password.equals("1234")){
            return true;
        }
        else{
            return false;
        }
    } 
    
    public boolean connectDatabase(){
        
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } 
        catch (Exception ex) {
            System.out.println("Failed to register MySQL Connector/J");
            System.out.println(ex);
	    return false;
        }

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam7db","18agileteam7","8302.at7.2038");
            return true;
        } 
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
	    return false;
        }
    }
}
