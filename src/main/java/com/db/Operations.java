package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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

    public String isKeyPresent(long key,long expiry_time)
    {
        String ans="";
        try{
            conn=DbConnection.con();
            PreparedStatement ps = conn.prepareStatement("SELECT u.key,u.value from urlshortener.url2 u where u.key =? && u.expiry >?");
            ps.setLong(1,key);
            ps.setLong(2,expiry_time);
            ResultSet resultSet=ps.executeQuery();
            if(resultSet.next())
            {
                ans=resultSet.getString(2);
                System.out.println("Found the key in db"+key+" corresponding url is"+ans);
            }
            else {
                System.out.println("key"+key+" is not present in db");
            }
        }catch(Exception e){
            System.out.println("unable to check if key is present in db in operations");
            e.printStackTrace();

    }
    return  ans;

    }

    public long isValuePresent(String url) {
        long ans = -1;
        //checking if value is present and also that is not expired if yes then returning the corresponding key
        try {
            conn=DbConnection.con();
            long unixTime = System.currentTimeMillis() / 1000L;
            System.out.println("present unix time is "+unixTime);
            PreparedStatement ps = conn.prepareStatement("SELECT u.key from urlshortener.url2 u where u.value =? && u.expiry>=?");
            ps.setString(1,url);
            ps.setLong(2,unixTime);
            ResultSet resultSet= ps.executeQuery();
            if(resultSet.next())
            {
             ans=resultSet.getLong(1);
             System.out.println("value  recieved from db is "+ans);
            }

        } catch (Exception e){
            System.out.println("Exception occurred "+e);
            e.printStackTrace();
        }
        return ans;
    }




}
