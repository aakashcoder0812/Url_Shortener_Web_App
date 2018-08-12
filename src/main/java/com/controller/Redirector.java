package com.controller;


import com.core.NewEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Redirector {

    @RequestMapping(value = "/{name}")
    public String redirect(@PathVariable String name, Model model)
    {   System.out.println("name in url is"+name);
        NewEntry newEntry = new NewEntry();
        String url=newEntry.actualUrl(name);
        //RedirectView redirectView = new RedirectView();
        if(url.length()>0)
        {
            System.out.println("url found is"+url+"redirecting to that site");
            url=correctUrl(url);
            return "redirect:"+url;
          //  redirectView.setUrl(url);
        }
        else{
            System.out.println("url not found , redirecting back to home page");
            model.addAttribute("flag","something");
            return "redirect:http://localhost:8080/";
            //redirectView.setUrl("http://localhost:8080/");

        }


    }

    public String correctUrl(String url)
    {
        String ans="";
        int val=url.indexOf("http");
        if(val==0)return url;
        val=url.indexOf("www.");
        if(val==0)return "http://"+url;
        else
            return "http://www."+url;


    }

}
