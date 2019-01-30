/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas
 */
public class Database {

    private Connection conn;

    public Database() {
        conn = null;
    }
    
    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return Returns an instance of the sql.Connection class which is the
     * current connection to the database.
     */
    public Connection connect() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            System.out.println("Failed to register MySQL Connector/J");
            System.out.println(ex);
            return null;
        }

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam7db", "18agileteam7", "8302.at7.2038");
            return conn;
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
    public ResultSet executeQuery(String query) {
        try {
            this.connect();
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
            this.connect();
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

    public void movetoexamvettingcommite(String pk) {

        try {

            Statement state = conn.createStatement();

            String sql = "update exams set internal_moderator_int_mod_pk=2 where exam_pk=" + pk + ";";

            state.executeUpdate(sql);

        } catch (SQLException ex) {

            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());

            System.out.println("SQLState: " + ex.getSQLState());

            System.out.println("VendorError: " + ex.getErrorCode());

        }

    }

    
    
    
    
    
    public void movetoexamvetexternalmodderator(String pk) {

        try {

            Statement state = conn.createStatement();

            String sql = "update exams set Exam_Vetting_Committee_exmVet_pk=2 where exam_pk=" + pk + ";";

            state.executeUpdate(sql);

        } catch (SQLException ex) {

            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());

            System.out.println("SQLState: " + ex.getSQLState());

            System.out.println("VendorError: " + ex.getErrorCode());

        }

    }

    public void finish_exam(String pk) {

        try {

            Statement state = conn.createStatement();

            String sql = "update exams set External_Examiner_ext_exam_pk=2 where exam_pk = " + pk + ";";

            state.executeUpdate(sql);

        } catch (SQLException ex) {

            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());

            System.out.println("SQLState: " + ex.getSQLState());

            System.out.println("VendorError: " + ex.getErrorCode());

        }

    }

    public void addcomment(String comments, String pk, String date, int pointer) {

        if (pointer == 1) {

            this.movetoexamvettingcommite(pk);
        }

        if (pointer == 2) {

            this.movetoexamvetexternalmodderator(pk);

        }
        if (pointer == 3) {

            this.finish_exam(pk);
        }

        try {
            Statement state = conn.createStatement();
            // INSERT INTO `18agileteam7db`.`comments`(`comments_pk`,`commentssssss`,`Attribute_3`,`exams_exam_pk`)VALUES(1,"a","a",15758);

            String sql = "INSERT INTO `18agileteam7db`.`comments`(`comments_pk`,`commentssssss`,`Attribute_3`,`exams_exam_pk`)VALUES(" + pk + pointer + ",\"" + comments + "\",\"" + date + "\"," + pk + ");";
            state.executeUpdate(sql);

        } catch (SQLException ex) {
            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /**
     *
     * @param username the username / email of the user
     * @param password the password of the user
     * @return Returns the user_pk of the if they are a valid user in the
     * database
     */
    public String checkLogin(String username, String password) {
        try {
            this.connect();
            if(username == null || password == null){
                return null;
            }
            
            String sql = "select user_pk, password, salt from users where username = '" + username + "';";
            
            if(conn == null){
                System.out.println("The connection is null");
            }
            
            Statement state = conn.createStatement();
            
            Base64.Decoder dec = Base64.getDecoder();
            
            ResultSet rs = state.executeQuery(sql);
            
            if(rs == null){
                System.out.println("No Results for such credentials exist in the database.");
                return null;
            }
            
            rs.first();
            
            byte[] salt = dec.decode(rs.getString("salt"));
            byte[] saltedHash = dec.decode(rs.getString("password"));
            byte[] passwordHash = null;

            Security security = new Security();
            try {
                passwordHash = security.getSaltedHash(password, salt);
            } catch (Exception e) {
                System.out.println("ERROR: PASSWORD CHECK FAILED TO GET SALTED HASH");
                System.out.println(e);
            }

            String user_pk = rs.getString(1);

            if (Arrays.equals(passwordHash, saltedHash) && user_pk != null) {
                System.out.println("User: " + username + " Logged in successfully!");
                System.out.println("UserPK: " + user_pk);

                return user_pk;
            } else {
                System.out.println("User: " + username + " Log in failed!");
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Database Erorr");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

    /**
     *
     * @param pk
     * @return
     */
    public String getexamsetter(String pk) {
        try {
            String sql = "select lect_pk from exam_setter where user_user_pk =" + pk + ";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        }
    }

    /**
     *
     * @param pk
     * @return
     */
    public String getinternalmod(String pk) {
        try {
            String sql = "select int_mod_pk from internal_moderator where user_user_pk =" + pk + ";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        } catch (Exception e) {
            System.out.println("Something broke.");
        }
        return null;
    }
  public ResultSet list_all_usernames() {
        try {
            String sql = "select username from users ;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            

            return rs;

        } catch (SQLException ex) {
            return null;
        } catch (Exception e) {
            System.out.println("Something broke.");
        }
        return null;
    }
    /**
     *
     * @param pk
     * @return
     */
    public String getexamvetcommit(String pk) {
        try {
            String sql = "select exmVet_pk from ExmVetComit where user_user_pk =" + pk + ";";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            return "0";
        }
    }

    /**
     *
     * @param pk
     * @return
     */
    public String getexternal(String pk) {
        try {
            String sql = "select ext_exam_pk from External_Examiner where user_user_pk =" + pk + ";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        }
    }

    /**
     *
     * @param pk
     * @return
     */
    public String getoffice(String pk) {
        try {
            String sql = "select school_office_pk from School_office where user_user_pk =" + pk + ";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        }
    }

    /**
     *
     * @param pk
     * @return
     */
    public String number_of_completed_exams(String pk) {
        try {
            String sql = "select count(*) from exams where ExmVetComit_exmVet_pk=2;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        }

    }

    /**
     *
     * @param pk
     * @return
     */
    public String number_of_in_progress_exams(String pk) {
        try {
            String sql = "select count(*) from exams where External_Examiner_ext_exam_pk!=2 and ExmVetComit_exmVet_pk!=2 and internal_moderator_int_mod_pk!=2 and External_Examiner_ext_exam_pk!=1 and ExmVetComit_exmVet_pk!=1 and internal_moderator_int_mod_pk!=1;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            return "0";
        }
    }

    /**
     *
     * @param pk
     * @return
     */
    public String number_examslinkedtopk(String pk) {
        try {
            String sql = "select count(*) from exams where exam_setter_lect_pk=" + pk + ";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            return "0";
        }
    }

    public ResultSet info_examslinkedtopk(String pk) {
        try {
            String sql = "select * from exams where exam_setter_lect_pk=" + pk + ";";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String number_examslinkedtopkintmod(String pk) {
        try {
            String sql = "select count(*) from exams where internal_moderator_int_mod_pk=" + pk + ";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            return "0";
        }
    }

    public ResultSet info_examslinkedtopkintmod(String pk) {
        try {
            String sql = "select * from exams where internal_moderator_int_mod_pk=" + pk + ";";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String number_examslinkedtopkextmod(String pk) {
        try {
            String sql = "select count(*) from exams where External_Examiner_ext_exam_pk=" + pk + ";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            return "0";
        }
    }

    public ResultSet info_examslinkedtopkextmod(String pk) {
        try {
            String sql = "select * from exams where External_Examiner_ext_exam_pk=" + pk + ";";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String number_examslinkedtopkvetcommit(String pk) {
        try {
            String sql = "select count(*) from exams where ExmVetComit_exmVet_pk=" + pk + ";";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            return "0";
        }
    }

    /**
     *
     * @param inputStream
     * @param Modulecode
     * @param level
     * @param pk
     * @param title
     * @param online
     * @param resit
     * @param exam_setter_lect_pk
     * @param examPK
     * @param docType
     * @return
     */
    public String blobin(InputStream inputStream, String Modulecode, String level, String pk, String title, String online, String resit, String exam_setter_lect_pk, String examPK, String docType) {
        try {

            //     InputStream inputStream = new FileInputStream(new File(path));
            String sql = "INSERT INTO `18agileteam7db`.`exams`(`exam_pk`,`module_code`,`title`,`online_or_paper`,`resit`,`exam`,`grade`,`examFile`,`doctype`,`exam_setter_lect_pk`,`internal_moderator_int_mod_pk`,`External_Examiner_ext_exam_pk`,`ExmVetComit_exmVet_pk`)VALUES(\"" + examPK + "\",\"" + Modulecode + "\",\"" + title + "\",\"" + online + "\",\"" + resit + "\",\"1\",\"" + level + "\",?,\"" + docType + "\",1,1,1,1);";
            //   String sql = "INSERT INTO `18agileteam7db`.`entity_1`(`PK`,`test`)VALUES(134,?);";

            //        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssss");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setBlob(1, inputStream);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e);
            return e.toString();
        }
        return "end of blob in";
    }

    public String updateblob(InputStream inputStream, String docType, String pk) {

        try {

            String sql = "update exams set doctype ='" + docType + "' , examFile =? where exam_pk =" + pk + " ;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setBlob(1, inputStream);

            statement.executeUpdate();

        } catch (SQLException e) {

            System.out.println("error");

            System.out.println(e);

            return e.toString();

        }

        return "end of blob in";

    }

    public ResultSet info_examslinkedtopkvetcommit(String pk) {
        try {
            String sql = "select * from exams where ExmVetComit_exmVet_pk=" + pk + ";";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String number_of_new_examsextmod(String pk) {
        try {
            String sql = "select count(*) from exams where External_Examiner_ext_exam_pk=1 AND ExmVetComit_exmVet_pk=1 AND internal_moderator_int_mod_pk=1;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            return "0";
        }

    }

    
    
    
    
    
    
     public  String colour1(String pk) {    
         
            try {
            Statement state = conn.createStatement();
            String sql = "select * from exams where exam_pk = "+pk+";";
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            String res =  rs.getString("exam_setter_lect_pk");
            if (res.equals("1") ){            
            return "red";
            }  else  if (res.equals("2") ){            
            return "green";
            }               
            else {return "yellow";} 
          
        } catch (SQLException ex) {
        }         
         return"grey";
             }
     
         public  String colour2(String pk) {    
         
            try {
            Statement state = conn.createStatement();
            String sql = "select * from exams where exam_pk = "+pk+";";
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            String res =  rs.getString("internal_moderator_int_mod_pk");
            if (res.equals("1") ){            
            return "red";
            }  else  if (res.equals("2") ){            
            return "green";
            }               
            else {return "yellow";} 
          
        } catch (SQLException ex) {
        }         
         return"grey";
             }
    
    
    
         public  String colour3(String pk) {    
         
            try {
            Statement state = conn.createStatement();
            String sql = "select * from exams where exam_pk = "+pk+";";
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            String res =  rs.getString("External_Examiner_ext_exam_pk");
            if (res.equals("1") ){            
            return "red";
            }  else  if (res.equals("2") ){            
            return "green";
            }               
            else {return "yellow";} 
          
        } catch (SQLException ex) {
        }         
         return"grey";
             }
    
         
         
         
         
         
         
         
         public  String colour4(String pk) {    
         
            try {
            Statement state = conn.createStatement();
            String sql = "select * from exams where exam_pk = "+pk+";";
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            String res =  rs.getString("ExmVetComit_exmVet_pk");
            if (res.equals("1") ){            
            return "red";
            }  else  if (res.equals("2") ){            
            return "green";
            }               
            else {return "yellow";} 
          
        } catch (SQLException ex) {
        }         
         return"grey";
             }
         
         
         
         
         
         public  int  gettotalnumberofusers() {

        try {

            Statement state = conn.createStatement();

            String sql = "select count(*) from users;";

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {

          
        return -1;
        }
    }
         
         
         
         
         
         
         
         
         
         
        public  int  gettotalnumberofexams() {

        try {

            Statement state = conn.createStatement();

            String sql = "select count(*) from exams;";

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {

          
        return -1;
        }

    }

    
       public ResultSet getallexams() {
        try {
            String sql = "select * from exams ;";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     *
     * @param pk
     * @return
     */
//    public boolean changeStage(String pk) {
//        try {
//            Statement state = conn.createStatement();
//
//            state.executeUpdate("");
//
//            return true;
//        } catch (SQLException ex) {
//            // handle any sql errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//            return false;
//        }
//
//    }
//    public ResultSet view_unsigned_exams() {
//
//        try {
//            Statement state = conn.createStatement();
//
//            ResultSet rs = state.executeQuery(query);
//
//            return rs;
//        } catch (SQLException ex) {
//            // handle any sql errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//            return null;
//        }
//    }
    /**
     *
     * @param exampk
     * @return
     */
//    public Blob blobout(String exampk) {
//        try {
//            Statement state = conn.createStatement();
//            ResultSet rset = state.executeQuery("select examFile from exams where exam_pk=" + exampk + ";");
//            byte b[];
//            Blob blob;
//            int i = 1;
//            // String doctype = rset.getString("doctype");
//            //File f = new File(path + "\\" + name + doctype);
//            //FileOutputStream fs = new FileOutputStream(f);
//            blob = rset.getBlob("examFile");
//
//            return blob;
//        } catch (SQLException e) {
//            System.out.println(e);
//            File v = new File("Csbxfgfgn");
//            return null;
//        }
//
//    }
}
