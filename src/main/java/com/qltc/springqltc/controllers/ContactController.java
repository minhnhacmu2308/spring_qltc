package com.qltc.springqltc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @GetMapping(value = "/lien-he")
    public ModelAndView getContact(){
        ModelAndView mv = new ModelAndView("user/contact");
        return mv;
    }
}
