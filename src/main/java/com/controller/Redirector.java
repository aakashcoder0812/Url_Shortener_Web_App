package com.controller;


import com.core.NewEntry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Redirector {

    @RequestMapping(value = "/{name}")
    public RedirectView redirect(@PathVariable String name)
    {   System.out.println("name in url is"+name);
        NewEntry newEntry = new NewEntry();
        String url=newEntry.actualUrl(name);
        RedirectView redirectView = new RedirectView();
        if(url.length()>0)
        {
            System.out.println("url found is"+url+"redirecting to that site");
            redirectView.setUrl(url);
        }
        else{
            System.out.println("url not found , redirecting back to home page");
            redirectView.setUrl("http://localhost:8080/");
        }
        return redirectView;

    }

}
