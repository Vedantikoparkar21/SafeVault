package com.safevault.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://centerbeam.proxy.rlwy.net:49268/railway",
                "root",
                "xMdSIvopVWdGukNXDQtrfVTaIHBQqfqd"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}