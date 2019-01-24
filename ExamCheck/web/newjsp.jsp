



<%@page import="java.io.*"%>"
<%@page contentType="text/html" pageEncoding="UTF-8"%>"
<html>
   <head>
      <title>File Uploading Form</title>
   </head>
   <form name="uploadForm" action="newjsp.jsp" method="POST" enctype="multipart/form-data">
       <%
       String saveFile = new String();
       String contentype = request.getContentType();

if((contentype !=null )&& (contentype.indexOf("multipart/form-data")  >=0)){

DataInputStream in = new DataInputStream(request.getInputStream());
int formDataLength = request.getContentLength();
byte dataBytes[] = new byte[formDataLength];
int bytesRead =0;
int totalBytesRead = 0;
while(totalBytesRead < formDataLength){
    
    bytesRead = in.read(dataBytes,totalBytesRead,formDataLength);
    totalBytesRead+= bytesRead;
}
String file = new String(dataBytes);
saveFile = file.substring(file.indexOf("filename=\"")+10 );
saveFile = saveFile.substring(0,saveFile.indexOf("\n"));
saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1 , saveFile.indexOf("\""));

int lastIndex = contentype.lastIndexOf("=");

String boundary=contentype.substring(lastIndex +1,contentype.length());

int pos;
pos = file.indexOf("filename=\"");
pos = file.indexOf("\n", pos)+1;
pos = file.indexOf("\n", pos)+1;
pos = file.indexOf("\n", pos)+1;

int boundaryLocation = file.indexOf(boundary,pos)-4;

int startPos = ((file.substring(0, pos)).getBytes()).length;
int endPos = ((file.substring(0,boundaryLocation)).getBytes()).length;
saveFile = "C://"+saveFile;

File ff = new File(saveFile);
try{

FileOutputStream fileout = new FileOutputStream(ff);
fileout.write(dataBytes,startPos, (endPos-startPos));
fileout.flush();
fileout.close();

}catch(Exception e){

}


}

       %>
       <input type="file" name="file" value="" width="100" />
       <input type="submit" value="submit" name="submit" />
   </form>
   <body>


      </form>
   </body>
   
</html>