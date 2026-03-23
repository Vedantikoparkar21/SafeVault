package com.safevault.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

protected void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

String fileName=request.getParameter("file");

String filePath="C:/SafeVaultUploads/"+fileName;

File file=new File(filePath);

FileInputStream fis=new FileInputStream(file);

response.setContentType("application/octet-stream");
response.setHeader("Content-Disposition","attachment; filename="+fileName);

OutputStream os=response.getOutputStream();

byte[] buffer=new byte[4096];

int bytesRead;

while((bytesRead=fis.read(buffer))!=-1){

os.write(buffer,0,bytesRead);

}

fis.close();
os.close();

}
}