package com.db;

import com.db.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Operations {

    Connection conn;

    public boolean insert(Long key, String value, Long expiry)
    {
        int i=0;
        System.out.println("going to insert values into db");
        try{

            conn=DbConnection.con();
            PreparedStatement ps= conn.prepareStatement("INSERT INTO urlshortener.url2 VALUES (?,?,?)");
            ps.setString(1,Long.toString(key));
            ps.setString(2,value);
            ps.setString(3, Long.toString(expiry));
            i=ps.executeUpdate();
            System.out.println("Operation successfull for insertion of data");
            }catch(Exception e) {
            System.out.println("Operation failed, Now in catch block");
            e.printStackTrace();
            }

        if(i!=0)
        {return  true;
        }
        else {return  false;}

    }




}
