package com.bcaf.lgd.testing.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdapterJDBC {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/hacktiv8_bcaf";
    private static final String user = "itnoncore";
    private static final String password = "corenonti";

    public static Connection getConnection(){
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the MySQL server successfully");
        }
        catch (Exception e){
            System.out.println("Connection to the MySQL Error");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
