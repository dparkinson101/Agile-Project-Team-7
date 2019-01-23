/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

 public String test(){
return "donedb";
 }




     public String blobin(String path,String Modulecode,String level, String pk,String title, String online,String resit, String exam_setter_lect_pk){
        try{
              
           
                InputStream inputStream = new FileInputStream(new File(path));
                //String sql = "INSERT INTO `18agileteam7db`.`exams`(`exam_pk`,`module_code`,`title`,`online_or_paper`,`resit`,`examFile`,`exam_setter_lect_pk`,`internal_moderator_int_mod_pk`,`External_Examiner_ext_exam_pk`,`ExmVetComit_exmVet_pk`)VALUES("+pk+","+Modulecode+","+title+","+online+","+resit+","+"?"+exam_setter_lect_pk+"1,1,1);";
                String sql = "INSERT INTO `18agileteam7db`.`entity_1`(`PK`,`test`)VALUES(8,null);";
                
                
                PreparedStatement statement = conn.prepareStatement(sql);
               // statement.setBlob(1, inputStream);
                statement.executeUpdate();
            }
       
        catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
        return "end of blob in";
    }

        public void blobout(String exampk,String path,String name){
        try{
            Statement state = conn.createStatement();
            ResultSet rset = state.executeQuery("select examFile from exams where exam_pk="+exampk+";");
            byte b[];
            Blob blob;
            int i=1;
            String doctype =  rset.getString("doctype");
            File f=new File(path+"\\"+name+doctype);
            FileOutputStream fs = new FileOutputStream(f);
            blob=rset.getBlob("test");
            b=blob.getBytes(1, (int)blob.length());
            fs.write(b);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
