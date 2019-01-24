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
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } 
        catch (Exception ex) {
            System.out.println("Failed to register MySQL Connector/J");
            System.out.println(ex);
            return null;
        }

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam7db", "18agileteam7", "8302.at7.2038");
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
     * @return Returns results of query for the database in a sql.ResultSet
     * object.
     */
    public ResultSet executeQuery(String query) {
        try {
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(query);

            return rs;
        } catch (SQLException ex) {
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
     * @return Returns results of query for the database in a sql.ResultSet
     * object.
     */
    public boolean updateQuery(String query) {
        try {
            Statement state = conn.createStatement();

            state.executeUpdate(query);

            return true;
        } catch (SQLException ex) {
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

 public String[] checklogin(String username, String password){
        try{
          String sql = "select user_pk from users where username ="+username+" and password ="+password+";";
          //  String sql = "select user_pk from users where username =\"admin\" and password =\"1234\";";
            
             Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);

          
            String[] roles = new String[5];
rs.beforeFirst();
rs.next();

           String user_pk = rs.getString(1);
           
           if(user_pk!=null){
        
         roles[0]=     this.getexamsetter(user_pk);
         roles[1]=         this.getinternalmod(user_pk);
         roles[2]=           this.getexamvetcommit(user_pk);
         roles[3]=           this.getexternal(user_pk);
         roles[4]=          this.getoffice(user_pk);
           }
         return roles;
        }
        catch (SQLException ex) {
             String[] error = new String[5];
             error[0]="-1";
             error[1]="-1";
             error[2]="-1";
             error[3]="-1";
             error[4]="-1";
           return error;
        }
        
        
     
    }
 
 
  public String getexamsetter(String pk){
        try{
            String sql ="select lect_pk from exam_setter where user_user_pk ="+pk+";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

           return  rs.getString(1);
            
            
        }
        catch (SQLException ex) {
           return "0";
        }  
  }
public String getinternalmod(String pk){   
        try{
            String sql ="select int_mod_pk from internal_moderator where user_user_pk ="+pk+";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

                      return  rs.getString(1);
            
            
        }
        catch (SQLException ex) {
              return "0";
        }  
  }
public String getexamvetcommit(String pk){
        try{
            String sql ="select exmVet_pk from ExmVetComit where user_user_pk ="+pk+";";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
                    return  rs.getString(1);          
        }
        catch (SQLException ex) {
             return "0";
        }  
  }


public String getexternal(String pk){
        try{
            String sql ="select ext_exam_pk from External_Examiner where user_user_pk ="+pk+";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

                   return  rs.getString(1);
            
            
        }
        catch (SQLException ex) {
             return "0";
        }  
  }
public String getoffice(String pk){
        try{
            String sql ="select school_office_pk from School_office where user_user_pk ="+pk+";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

                     return  rs.getString(1);
            
            
        }
        catch (SQLException ex) {
            return "0";
        }  
  }
public String number_of_completed_exams(String pk){
  try{
            String sql ="select count(*) from exams where ExmVetComit_exmVet_pk=2;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();    
            
            
                     return  rs.getString(1);
            
            
        }
        catch (SQLException ex) {
            return "0";
        }  


}
public String number_of_in_progress_exams(String pk){
try{
            String sql ="select count(*) from exams where exams_External_Examiner_FK!=2 and exams_ExmVetComit_FK!=2 and exams_internal_moderator_FK!=2 and exams_External_Examiner_FK!=1 and exams_ExmVetComit_FK!=1 and exams_internal_moderator_FK!=1;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();               
            return  rs.getString(1);            
        }
        catch (SQLException ex) {
            return "0";
        }  



}
public String number_of_new_exams(String pk){
try{
            String sql ="select count(*) from exams where exams_External_Examiner_FK=1 and exams_ExmVetComit_FK=1 and exams_internal_moderator_FK=1;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();               
            return  rs.getString(1);            
        }
        catch (SQLException ex) {
            return "0";
        }  


}




public boolean changeStage(String pk){
try{
     Statement state = conn.createStatement();

            state.executeUpdate("");

            return true;
        } catch (SQLException ex) {
            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }

}
/*
public ResultSet view_unsigned_exams(){

    try {
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(query);

            return rs;
        } catch (SQLException ex) {
            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
}
*/

     public String blobin(InputStream inputStream ,String Modulecode,String level, String pk,String title, String online,String resit, String exam_setter_lect_pk){
        try{
              
           
         //       InputStream inputStream = new FileInputStream(new File(path));
                String sql = "INSERT INTO `18agileteam7db`.`exams`(`exam_pk`,`module_code`,`title`,`online_or_paper`,`resit`,`examFile`,`exam_setter_lect_pk`,`internal_moderator_int_mod_pk`,`External_Examiner_ext_exam_pk`,`ExmVetComit_exmVet_pk`)VALUES("+pk+","+Modulecode+","+title+","+online+","+resit+","+"?"+exam_setter_lect_pk+"1,1,1);";
                //String sql = "INSERT INTO `18agileteam7db`.`entity_1`(`PK`,`test`)VALUES(8,null);";
                
                
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setBlob(1, inputStream);
                statement.executeUpdate();
            }
       
        catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
        return "end of blob in";
    }
     
     
     

        public File blobout(String exampk,String path,String name){
        try{
            Statement state = conn.createStatement();
            ResultSet rset = state.executeQuery("select examFile from exams where exam_pk="+exampk+";");
            byte b[];
            Blob blob;
            int i=1;
            String doctype =  rset.getString("doctype");
            File f=new File("C:\\"+name+doctype);
            FileOutputStream fs = new FileOutputStream(f);
            blob=rset.getBlob("test");
            b=blob.getBytes(1, (int)blob.length());
            fs.write(b);
         return f;
        }
        catch(Exception e){
            System.out.println(e);
           File v= new File("Csbxfgfgn");
           return v;
        }
        
    }
}
