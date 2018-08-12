package com.core;

import com.db.Operations;
import static com.core.BaseConverter.*;

import java.util.Random;

public class NewEntry {

    /*
    take input string from user , check if it already exist in db if yes then check if present timestamp is less than strored in db if yes return the
    url by computation of int to small string else take random integer more than some value and then do base conversiion and then store the v
    values in db

     */

    public String proceed(String Str, Long expiry)
    {
        Operations operations = new Operations();
        String ispresent="";
        String shortUrl="";
        long number;
        int count=0;
        shortUrl=ifKeyAlreadyPresent(Str);
        if(shortUrl.length()>0)
        {
            System.out.println("url"+Str+"is already present in db , thus returning its oorresponding shorturl"+shortUrl);
            return shortUrl;
        }
        //generating random number and then checking if it is not present in db already
        do {
            count++;
             number = (long) (Math.random() * Integer.MAX_VALUE + 1);

            System.out.println("the number generated is " + number);

            //BaseConverter baseConverter = new BaseConverter();
            shortUrl = BaseConverter.idToShortUrl(number);
            System.out.println("short url is " + shortUrl);
             ispresent=operations.isKeyPresent(number,0);
             if(count>1)
             {System.out.println("value is already is present in db and now count is"+count);}
        }while(ispresent.length()>0&& count<10);

        if(count==10)
        {
            System.out.println("Unable to insert in table as generated values are already present in db, no of times tried: "+count);
            return "";
        }
        //you have to first check that this random number is not already present in db

        boolean ans =operations.insert(number,Str,expiry);
        if(ans)
        {System.out.println("Successfully inserted in db with key: "+number+" url: "+Str+"with expiry: "+expiry);
        return shortUrl;}
        else{
            System.out.println("Unable to insert");

        return "";}


    }

    public String ifKeyAlreadyPresent(String url)
    {
        Operations operations = new Operations();
        String shortUrl="";
        long key=operations.isValuePresent(url);
        if(key==-1)
        {System.out.println("String url:"+url+" is not present in db with expiry > present time");
            return "";

        }
        else
        {
            shortUrl=BaseConverter.idToShortUrl(key);
            System.out.println("shortUrl is "+shortUrl);
            return shortUrl;

        }


    }

    public String actualUrl(String shortUrl)
    {
        long key=BaseConverter.shortURLtoID(shortUrl);
        System.out.println("the corresponding key of shorturl"+shortUrl+" is: "+key);
        Operations operations= new Operations();
        long unixTime = System.currentTimeMillis() / 1000L;
        System.out.println("present unix time is "+unixTime);
        String url=operations.isKeyPresent(key,unixTime);
        if(url.length()>0)
        {
            System.out.println("actual url found is "+url);
            return url;
        }
        else {
            System.out.println("wrong input is provided ,unable to find entry for key"+key+"in db");
            return  "";
        }

    }


}
