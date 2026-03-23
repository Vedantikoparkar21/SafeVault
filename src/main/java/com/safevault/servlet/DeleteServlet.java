package com.safevault.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.safevault.util.DBConnection;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

protected void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

String fileName=request.getParameter("file");

String filePath="C:/SafeVaultUploads/"+fileName;

try{

File file=new File(filePath);

if(file.exists()){
file.delete();
}

Connection con=DBConnection.getConnection();

String sql="DELETE FROM documents WHERE document_name=?";

PreparedStatement ps=con.prepareStatement(sql);

ps.setString(1,fileName);

ps.executeUpdate();

}catch(Exception e){
e.printStackTrace();
}

response.sendRedirect("ViewDocumentsServlet");

}
}