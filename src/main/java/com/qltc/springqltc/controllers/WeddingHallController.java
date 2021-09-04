package com.qltc.springqltc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeddingHallController {

    @GetMapping(value = "sanh-cuoi")
    public ModelAndView getWeddingHall(){
        ModelAndView mv = new ModelAndView("user/weddinghall");
        return mv;
    }
}
