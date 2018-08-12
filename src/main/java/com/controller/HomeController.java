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
    public String processor(@RequestParam("input_string") String input_string, int input_time, Model model)
    {
        System.out.println("input string provided is"+input_string);
        System.out.println("Input time provided is "+input_time);
        long unixTime = System.currentTimeMillis() / 1000L;
        unixTime=unixTime+((long)input_time*60);
        if(input_time==0)
        {
            unixTime=99999999999999L;
        }
        NewEntry entry = new NewEntry();
        String shorturl=entry.proceed(input_string,unixTime);
        shorturl="http://localhost:8080/"+shorturl;
        model.addAttribute("shortUrl",shorturl);

        return "homepage.jsp";
    }

}
