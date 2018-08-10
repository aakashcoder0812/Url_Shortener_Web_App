package com.core;

import com.db.Operations;

import java.util.Random;

public class NewEntry {

    /*
    take input string from user , check if it already exist in db if yes then check if present timestamp is less than strored in db if yes return the
    url by computation of int to small string else take random integer more than some value and then do base conversiion and then store the v
    values in db

     */

    //skipping the select query
    //proceeding to inserting
    //make it for expiry also
    public String proceed(String Str, Long expiry)
    {
        long number = (long)(Math.random()*Integer.MAX_VALUE + 1);
        System.out.println("the number generated is "+ number);

        BaseConverter baseConverter = new BaseConverter();
        String shorturl= baseConverter.idToShortUrl(number);
        System.out.println("short url is "+shorturl);

        Operations operations = new Operations();
        //you have to first check that this random number is not already present in db

        boolean ans =operations.insert(number,Str,expiry);
        if(ans)
        {System.out.println("Successfully inserted");
        return shorturl;}
        else{
            System.out.println("Unable to insert");

        return " ";}


    }


}
