package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.serviceimpl.ServiceServiceImpl;
import com.qltc.springqltc.serviceimpl.WeddingHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {

    @Autowired
    ServiceServiceImpl serviceService;

    @GetMapping(value = "chi-tiet-dich-vu")
    public ModelAndView getDetaiService(@RequestParam(value = "id") int id){
        ModelAndView mv = new ModelAndView("user/detailservice");
        Service service = serviceService.findById(id);
        mv.addObject("service",service);
        return mv;
    }
}
