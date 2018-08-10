package com.controller;

import com.core.NewEntry;
import org.springframework.stereotype.Controller;
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
    public String processor(@RequestParam("input_string") String input_string)
    {
        System.out.println("input string provided is"+input_string);
        NewEntry entry = new NewEntry();
        String shorturl=entry.proceed(input_string,(long)999999999);
        return "homepage.jsp";
    }

}
