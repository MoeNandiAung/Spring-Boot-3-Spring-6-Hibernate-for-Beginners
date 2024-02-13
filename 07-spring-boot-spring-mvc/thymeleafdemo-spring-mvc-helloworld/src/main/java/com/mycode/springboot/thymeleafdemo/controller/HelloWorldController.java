package com.mycode.springboot.thymeleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // create new a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }

    // create a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }

    // create a controller method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model)
    {
        // read the data from form
        String theName = request.getParameter("studentName");

        // convert the data to uppercase
        theName = theName.toUpperCase();

        // create a message
        String result = "Yo!"+ theName;

        // add a message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }
    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model)
    {

        // convert the data to uppercase
        theName = theName.toUpperCase();

        // create a message
        String result = "How are you! "+ theName;

        // add a message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }
}
