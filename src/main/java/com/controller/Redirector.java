package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Redirector {

    @RequestMapping(value = "/{name}")
    public RedirectView redirect(@PathVariable String name)
    {   System.out.println("name in url is"+name);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.google.co.in");
        return redirectView;
    }

}
