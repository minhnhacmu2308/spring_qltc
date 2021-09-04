package com.qltc.springqltc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PreferentialService {
    @GetMapping(value = "dich-vu-va-uu-dai")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("user/service");
        return mv;
    }
}
