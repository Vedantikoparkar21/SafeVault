package com.safevault.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://centerbeam.proxy.rlwy.net:49268/railway"
                    + "?useSSL=false"
                    + "&allowPublicKeyRetrieval=true"
                    + "&serverTimezone=UTC";

            String user = "root";
            String password = "xMdSIvopVWdGukNXDQtrfVTaIHBQqfqd";

            con = DriverManager.getConnection(url, user, password);

            System.out.println("✅ DB Connected");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}