package com.controller;

import com.core.NewEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home()
    {   System.out.println("Program Completed");
        return "homepage.jsp";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String processor(@RequestParam("input_string") String input_string, int input_time,String input_custom_url, Model model)
    {
        System.out.println("input string provided is"+input_string);
        System.out.println("Input time provided is "+input_time);
        if(input_custom_url.length()>0)
        {
            System.out.println("custom url provided is"+input_custom_url);
        }
        else{
            System.out.println("No custom url provided");
        }
        long unixTime = System.currentTimeMillis() / 1000L;
        unixTime=unixTime+((long)input_time*60);
        if(input_time<=0)
        {
            unixTime=99999999999999L;
        }
        NewEntry entry = new NewEntry();
        String shorturl=entry.proceed(input_string,unixTime,input_custom_url,model);
        if(shorturl.length()>0)
        {shorturl="http://localhost:8080/"+shorturl;}
        model.addAttribute("shortUrl",shorturl);

        return "homepage.jsp";
    }

}
