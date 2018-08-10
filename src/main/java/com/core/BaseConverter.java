package com.core;

public class BaseConverter {

    public String idToShortUrl(long  n)
    {
        String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String shortUrl="";

        while(n>0)
        {
            shortUrl=shortUrl+map.charAt((int)n%62);
            n=n/62;
        }

        return shortUrl;
    }

    long  shortURLtoID(String shortURL)
    {
        long  id = 0;
        for (int i=shortURL.length()-1; i>=0; i--)
        {
            if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
                id = id*62 + shortURL.charAt(i) - 'a';
            if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
                id = id*62 + shortURL.charAt(i) - 'A' + 26;
            if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
                id = id*62 + shortURL.charAt(i) - '0' + 52;
        }
        return id;
    }


}
