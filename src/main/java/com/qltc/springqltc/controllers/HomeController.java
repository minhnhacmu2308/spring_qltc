package com.qltc.springqltc.controllers;

import com.qltc.springqltc.respositorys.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private UserRespository userRespository;

    @GetMapping(value = "/trang-chu")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("user/home");
        return mv;
    }
}
