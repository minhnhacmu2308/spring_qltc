package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.serviceimpl.WeddingHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeddingHallController {

    @Autowired
    WeddingHallServiceImpl weddingHallService;

    @GetMapping(value = "sanh-cuoi")
    public ModelAndView getWeddingHall(){
        ModelAndView mv = new ModelAndView("user/weddinghall");
        return mv;
    }
    @GetMapping(value = "chi-tiet-sanh-cuoi")
    public ModelAndView getDetailWeddingHall(@RequestParam(name = "id") int id){
        ModelAndView mv = new ModelAndView("user/detailweddinghall");
        WeddingHall weddingHall = weddingHallService.findById(id);
        mv.addObject("weddinghall",weddingHall);
        return mv;
    }

}
