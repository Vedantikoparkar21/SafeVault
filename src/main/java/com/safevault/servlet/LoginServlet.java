package com.safevault.servlet;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.safevault.util.DBConnection;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String securityAnswer = request.getParameter("securityAnswer");

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int attempts = rs.getInt("attempts");
                Timestamp lockTime = rs.getTimestamp("lock_time");

                // 🔒 Check lock
                if (lockTime != null) {
                    LocalDateTime lock = lockTime.toLocalDateTime();
                    if (lock.plusHours(1).isAfter(LocalDateTime.now())) {
                        response.getWriter().println("Account locked! Try after 1 hour.");
                        return;
                    }
                }

                String dbAnswer = rs.getString("security_answer");

                if (dbAnswer.equalsIgnoreCase(securityAnswer)) {

                    // ✅ Reset attempts
                    PreparedStatement reset = con.prepareStatement(
                        "UPDATE users SET attempts=0, lock_time=NULL WHERE email=?");
                    reset.setString(1, email);
                    reset.executeUpdate();

                    HttpSession session = request.getSession();
                    session.setAttribute("userId", rs.getInt("user_id"));

                    response.sendRedirect("dashboard.jsp");

                } else {

                    attempts++;

                    if (attempts >= 3) {
                        PreparedStatement lockUser = con.prepareStatement(
                            "UPDATE users SET attempts=?, lock_time=NOW() WHERE email=?");
                        lockUser.setInt(1, attempts);
                        lockUser.setString(2, email);
                        lockUser.executeUpdate();

                        response.getWriter().println("Too many wrong attempts! Account locked for 1 hour.");
                    } else {
                        PreparedStatement update = con.prepareStatement(
                            "UPDATE users SET attempts=? WHERE email=?");
                        update.setInt(1, attempts);
                        update.setString(2, email);
                        update.executeUpdate();

                        response.getWriter().println("Wrong security answer! Attempts left: " + (3 - attempts));
                    }
                }

            } else {
                response.getWriter().println("Invalid Email or Password!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}