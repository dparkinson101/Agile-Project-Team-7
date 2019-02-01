/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.Date;
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

public class Database {

    private Connection conn;

    public Database() {
        conn = null;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public ResultSet get_done_exams() {
        try {
            String sql = "select * from exams where External_Examiner_ext_exam_pk =2;";
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void updatelog(String query) {
        try {
            this.connect();
            Statement state = conn.createStatement();
            Date date = new Date();
            state.executeUpdate("insert into audit_log(log_entry, date_time)values(" + query + "," + date + ");");
        } catch (SQLException ex) {

        }
    }

    public void movetoexamvettingcommite(String pk) {

        try {

            Statement state = conn.createStatement();

            String sql = "update exams set internal_moderator_int_mod_pk=2 where exam_pk=" + pk + ";";
            //this.updatelog("exam :"+pk+" was internal modderated and approved");
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
            //this.updatelog("exam :"+pk+" was moved externally modderated and approved");
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
            //this.updatelog("exam :"+pk+" has been approved the school office can now download the exam");
            state.executeUpdate(sql);

        } catch (SQLException ex) {

            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());

            System.out.println("SQLState: " + ex.getSQLState());

            System.out.println("VendorError: " + ex.getErrorCode());

        }

    }

    public String getapkfromtheusername(String name, int number) {

        try {
            String sql = "A";
            if (number == 1) {
                sql = "select exmVet_pk from exmvetcomit inner join users where  users.user_pk = exmvetcomit.exmVet_pk and users.username = \"" + name + "\";";
            }
            if (number == 2) {
                sql = "select int_mod_pk from internal_moderator inner join users where  users.user_pk = internal_moderator.int_mod_pk and users.username = \"" + name + "\";";
            }
            if (number == 3) {
                sql = "select ext_exam_pk from external_examiner inner join users where  users.user_pk = external_examiner.ext_exam_pk and users.username = \"" + name + "\";";
            }
            if (sql.equals("A")) {
                return null;
            }
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return null;
        }
    }

    //   returns tru if the username is not taken
    public boolean isusername_taken(String name) {

        try {
            String sql = "select count(*) from users where username=\"" + name + "\";";

            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            if (rs.getString(1).equals("0")) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        }
    }

    public void setmods(String pk, int number, String name) {

        try {

            Statement state = conn.createStatement();
            String sql = "A";

            if (number == 1) {
                sql = "update exams set ExmVetComit_exmVet_pk=" + getapkfromtheusername(name, number) + " where exam_pk = " + pk + ";";
            }
            if (number == 2) {
                sql = "update exams set internal_moderator_int_mod_pk=" + getapkfromtheusername(name, number) + " where exam_pk = " + pk + ";";
            }
            if (number == 3) {
                sql = "update exams set External_Examiner_ext_exam_pk=" + getapkfromtheusername(name, number) + " where exam_pk = " + pk + ";";
            }

            //this.updatelog("exam :"+pk+" has been approved the school office can now download the exam");
            state.executeUpdate(sql);

        } catch (SQLException ex) {

            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());

            System.out.println("SQLState: " + ex.getSQLState());

            System.out.println("VendorError: " + ex.getErrorCode());

        }

    }

    public void addcomment(String comments, String pk, String date, int pointer) {
        
        System.out.println("POINTER GOTTEN: " + pointer);

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
            //this.updatelog("exam :"+pk+" has been commented on :"+comments +"by :" +getusername(pk));
            String sql = "INSERT INTO `18agileteam7db`.`comments`(`comments_pk`,`commentssssss`,`Attribute_3`,`exams_exam_pk`)VALUES(" + pk + pointer + ",\"" + comments + "\",\"" + date + "\"," + pk + ");";
            state.executeUpdate(sql);

        } catch (SQLException ex) {
            try {
                String sql = " UPDATE `18agileteam7db`.`comments`SET`comments_pk` = " + pk + pointer + ",`commentssssss` = \"" + comments + "\",`Attribute_3` = \"" + date + "\",`exams_exam_pk` = " + pk + " WHERE `comments_pk` = " + pk + ";";

                Statement state = conn.createStatement();

                state.executeUpdate(sql);
            } catch (SQLException exe) {

                System.out.println("SQLExceptionaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
    }

    public void add_to_storage(String date1, String date2, String date3, String date4, String date5) {

        try {
            Statement state = conn.createStatement();

            String sql = "UPDATE `18agileteam7db`.`storeage_dates`SET`date_of_exam_submission` =\"" + date1 + "\",`deadline_for_internal_modderation` = \"" + date2 + "\",`deadline_for_exam_vetting` = \"" + date3 + "\",`deadline_for_external_modderation` =\"" + date4 + "\",`date_of_database_clearing` =\"" + date5 + "\" WHERE `store_pk` = 1;";
            state.executeUpdate(sql);

        } catch (SQLException ex) {
            // handle any sql errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public String checkLogin(String username, String password) {
        try {
            this.connect();
            if (username == null || password == null) {
                return null;
            }

            String sql = "select user_pk, password, salt from users where username = '" + username + "';";

            if (conn == null) {
                System.out.println("The connection is null");
            }

            Statement state = conn.createStatement();

            Base64.Decoder dec = Base64.getDecoder();

            ResultSet rs = state.executeQuery(sql);

            if (rs == null) {
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
                //this.updatelog(username+"logged in");
                System.out.println("UserPK: " + user_pk);

                return user_pk;
            } else {
                System.out.println("User: " + username + " Log in failed!");
                //this.updatelog("a login was attempted for the user :"+username);
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

    public String getusername(String pk) {
        try {
            String sql = "select username from users where user_pk =" + pk + ";";
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

    public ResultSet list_all_examsetters_username() {
        try {
            String sql = "SELECT users.username from users INNER JOIN exam_setter ON users.user_pk = exam_setter.lect_pk and users.user_pk !=1 and users.user_pk !=2;";
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

    public ResultSet list_all_internal_modderators_username() {
        try {
            String sql = "SELECT users.username from users INNER JOIN internal_moderator ON users.user_pk = internal_moderator.int_mod_pk and users.user_pk !=1 and users.user_pk !=2;";
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

    public ResultSet list_all_exam_vetting_commitey_username() {
        try {
            String sql = "SELECT users.username from users INNER JOIN exmvetcomit ON users.user_pk = exmvetcomit.exmVet_pk and users.user_pk !=1 and users.user_pk !=2;";
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

    public ResultSet list_all_external_examiners_username() {
        try {
            String sql = "SELECT users.username from users INNER JOIN external_examiner ON users.user_pk = external_examiner.ext_exam_pk and users.user_pk !=1 and users.user_pk !=2;";
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

    public String download_comments1(String pk) {
        try {
            String sql = "select commentssssss from comments where comments_pk =" + pk + " ;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        }
    }

    public String download_comments2(String pk) {
        try {
            String sql = "select commentssssss from comments where comments_pk =" + pk + 1 + " ;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        }
    }

    public String get_username_from_exam_pk(String pk, int camel) {
        try {
            String sql = null;

            if (camel == 3) {
                sql = "select users.username from users inner join exams ON users.user_pk = exams.ExmVetComit_exmVet_pk where exams.exam_pk=" + pk + ";";
            }
            if (camel == 1) {
                sql = "select users.username from users inner join exams ON users.user_pk = exams.internal_moderator_int_mod_pk where exams.exam_pk=" + pk + ";";
            }
            if (camel == 2) {
                sql = "select users.username from users inner join exams ON users.user_pk = exams.External_Examiner_ext_exam_pk where exams.exam_pk=" + pk + ";";
            }
            if (camel != 1 && camel != 2 && camel != 3) {
                return "error with input to function";
            }

            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        }
    }

    public int exam_rows() {
        try {
            String sql = "select count(*) from exams;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            int a = rs.getInt(1);
            return a * 3;

        } catch (SQLException ex) {
            return -1;
        }
    }

    public int user_rows() {
        try {
            String sql = "select count(*) from users;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            int a = rs.getInt(1);
            return a;

        } catch (SQLException ex) {
            return -1;
        }
    }

    public int getRows(int no) {
        try {
            String sql = "a";
            if (no == 2) {
                sql = "select count(*) from ExmVetComit;";
            }
            if (no == 1) {
                sql = "select count(*) from internal_moderator;";
            }
            if (no == 3) {
                sql = "select count(*) from External_Examiner;";
            }

            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            int a = rs.getInt(1);
            return a - 2;

        } catch (SQLException ex) {
            return -1;
        }
    }

    public String download_comments3(String pk) {
        try {
            String sql = "select commentssssss from comments where comments_pk =" + pk + 2 + " ;";
            Statement state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();

            return rs.getString(1);

        } catch (SQLException ex) {
            return "0";
        }
    }

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
            String sql = "INSERT INTO `18agileteam7db`.`exams`(`exam_pk`,`module_code`,`title`,`online_or_paper`,`resit`,`exam`,`grade`,`examFile`,`doctype`,`exam_setter_lect_pk`,`internal_moderator_int_mod_pk`,`External_Examiner_ext_exam_pk`,`ExmVetComit_exmVet_pk`)VALUES(\"" + examPK + "\",\"" + Modulecode + "\",\"" + title + "\",\"" + online + "\",\"" + resit + "\",\"1\",\"" + level + "\",?,\"" + docType + "\"," + exam_setter_lect_pk + ",1,1,1);";
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

    public String colour1(String pk) {

        try {
            Statement state = conn.createStatement();
            String sql = "select * from exams where exam_pk = " + pk + ";";
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            String res = rs.getString("exam_setter_lect_pk");
            if (res.equals("1")) {
                return "red";
            } else if (res.equals("2")) {
                return "green";
            } else {
                return "yellow";
            }

        } catch (SQLException ex) {
        }
        return "grey";
    }

    public String colour2(String pk) {

        try {
            Statement state = conn.createStatement();
            String sql = "select * from exams where exam_pk = " + pk + ";";
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            String res = rs.getString("internal_moderator_int_mod_pk");
            if (res.equals("1")) {
                return "red";
            } else if (res.equals("2")) {
                return "green";
            } else {
                return "yellow";
            }

        } catch (SQLException ex) {
        }
        return "grey";
    }

    public String colour3(String pk) {

        try {
            Statement state = conn.createStatement();
            String sql = "select * from exams where exam_pk = " + pk + ";";
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            String res = rs.getString("External_Examiner_ext_exam_pk");
            if (res.equals("1")) {
                return "red";
            } else if (res.equals("2")) {
                return "green";
            } else {
                return "yellow";
            }

        } catch (SQLException ex) {
        }
        return "grey";
    }

    public String colour4(String pk) {

        try {
            Statement state = conn.createStatement();
            String sql = "select * from exams where exam_pk = " + pk + ";";
            ResultSet rs = state.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            String res = rs.getString("ExmVetComit_exmVet_pk");
            if (res.equals("1")) {
                return "red";
            } else if (res.equals("2")) {
                return "green";
            } else {
                return "yellow";
            }

        } catch (SQLException ex) {
        }
        return "grey";
    }

    public int gettotalnumberofusers() {

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

    public int gettotalnumberofexams() {

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
