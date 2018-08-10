package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    static Connection conn;

    public static Connection con(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/urlshortener","root","root");
            System.out.println("Connection done properly");
        } catch (Exception e) {

            e.printStackTrace();
        }


        return conn;
    }
}



