<%@page import="java.io.*,java.sql.*"%>
<%@page import="BackEnd.Database"%>
<%
String fileName ="test.docx";
        //= request.getParameter( "f" );

try {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam7db", "18agileteam7", "8302.at7.2038");
                    Database db = new Database();
                 
                    
     Statement stmtD = conn.createStatement();
     ResultSet rsD = stmtD.executeQuery( "SELECT examFile from exams where exam_pk =35362;" );
                 rsD.beforeFirst();
            rsD.next();
          //  rsD.first();
          try {
                byte contents[] = new byte[4666];
               response.setContentType("application/download");
               response.setHeader("Content-Disposition", "attachment; filename=" + fileName);               
               java.sql.Blob blobFile = rsD.getBlob("examFile");                              
              contents[] = blobFile.getBytes(0, (int) blobFile.length());               
               response.setContentLength((int) blobFile.length());                              
               //out.write(new String(contents));
          } catch(SQLException se) {
               out.println(se.getMessage());          
          }
   
     rsD.close();
     stmtD.close();
     conn.close();     
} catch(SQLException se) {
     out.println(se.getMessage());
}
%>