package com.qltc.springqltc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping(value = "home")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("user/home");
        return mv;
    }
}
