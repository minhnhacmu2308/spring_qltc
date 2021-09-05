package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.serviceimpl.MenuFoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuFoodController {

    @Autowired
    MenuFoodServiceImpl menuFoodService;

    @GetMapping(value = "chi-tiet-menu-thuc-an")
    public ModelAndView getDetailMenuFood(@RequestParam(required = false,name = "id") int id){
        ModelAndView mv = new ModelAndView("user/detailmenufood");
        MenuFood menuFood = menuFoodService.findById(id);
        System.out.println(menuFood);
        mv.addObject("menufood",menuFood);
        return mv;
    }
}
