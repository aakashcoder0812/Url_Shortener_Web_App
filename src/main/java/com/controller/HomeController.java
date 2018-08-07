package com.controller;

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

        return "homepage.jsp";
    }

}
