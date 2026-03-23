package com.safevault.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.safevault.util.DBConnection;

@WebServlet("/ViewDocumentsServlet")
public class ViewDocumentsServlet extends HttpServlet {

protected void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

HttpSession session=request.getSession(false);

if(session==null){

response.sendRedirect("login.jsp");
return;
}

int userId=(Integer)session.getAttribute("userId");

List<String> docs=new ArrayList<>();

try{

Connection con=DBConnection.getConnection();

String sql="SELECT document_name FROM documents WHERE user_id=?";

PreparedStatement ps=con.prepareStatement(sql);

ps.setInt(1,userId);

ResultSet rs=ps.executeQuery();

while(rs.next()){

docs.add(rs.getString("document_name"));

}

}catch(Exception e){
e.printStackTrace();
}

request.setAttribute("documents",docs);

request.getRequestDispatcher("viewDocuments.jsp").forward(request,response);

}
}