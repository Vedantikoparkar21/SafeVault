package com.safevault.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.safevault.util.DBConnection;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔹 Get form data
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String securityAnswer = request.getParameter("securityAnswer");

        // 🔹 Debug (important)
        System.out.println("Full Name: " + fullName);
        System.out.println("Security Answer: " + securityAnswer);

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(full_name, email, password, security_answer) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, securityAnswer.toLowerCase()); // store lowercase

            int i = ps.executeUpdate();

            if (i > 0) {
                response.sendRedirect("login.jsp");
            } else {
                response.getWriter().println("Registration Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("ERROR: " + e.getMessage());
        }
    }
}