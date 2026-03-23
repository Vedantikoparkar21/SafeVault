package com.safevault.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.safevault.util.DBConnection;

public class UserDAO {

    public boolean registerUser(String fullName, String email, String password, String pin) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users (full_name, email, password, pin, is_verified) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, pin);
            ps.setInt(5, 1);   // user verified automatically
            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}