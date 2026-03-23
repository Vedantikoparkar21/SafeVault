package com.safevault.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.safevault.util.DBConnection;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

HttpSession session=request.getSession(false);

if(session==null || session.getAttribute("userId")==null){

response.sendRedirect("login.jsp");
return;
}

int userId=(Integer)session.getAttribute("userId");

Part filePart=request.getPart("document");

String fileName=filePart.getSubmittedFileName();

String uploadPath="C:/SafeVaultUploads";

File folder=new File(uploadPath);

if(!folder.exists()){
folder.mkdir();
}

String filePath=uploadPath+File.separator+fileName;

filePart.write(filePath);

try{

Connection con=DBConnection.getConnection();

String sql="INSERT INTO documents(user_id,document_name,file_path) VALUES(?,?,?)";

PreparedStatement ps=con.prepareStatement(sql);

ps.setInt(1,userId);
ps.setString(2,fileName);
ps.setString(3,filePath);

ps.executeUpdate();

session.setAttribute("msg","Document Uploaded Successfully");

}catch(Exception e){
e.printStackTrace();
}

response.sendRedirect("dashboard.jsp");

}
}