package com.mycode.springboot.thymeleafdemo.controller;

import com.mycode.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    // create a method for student-form
    @Value("${systems}")
    private List<String> systems;
    @RequestMapping("/showStudentForm")
    public String showForm(Model model)
    {
        // create a new student object
        Student theStudent = new Student();


        // add student object to the model
        model.addAttribute("student",theStudent);
        // add a list of countries to the model
        model.addAttribute("countries",countries);
        // add a list of languages to the model
        model.addAttribute("languages",languages);
        model.addAttribute("systems",systems);

        return "student-form";
    }

    // create a method to process student
    @RequestMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {
        // log the input data
        System.out.println("theStudent: "+ theStudent.getFirstName()+ " "+ theStudent.getLastName());
        System.out.println("Country : "+theStudent.getCountry());
        System.out.println("Favorite language : "+theStudent.getFavoriteLanguage());
        return "student-confirmation";
    }
}
