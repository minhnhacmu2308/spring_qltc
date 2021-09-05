package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.respositorys.MenuFoodRespository;
import com.qltc.springqltc.respositorys.UserRespository;
import com.qltc.springqltc.serviceimpl.MenuFoodServiceImpl;
import com.qltc.springqltc.serviceimpl.ServiceServiceImpl;
import com.qltc.springqltc.serviceimpl.WeddingHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    MenuFoodServiceImpl menuFoodService;

    @Autowired
    WeddingHallServiceImpl weddingHallService;

    @Autowired
    ServiceServiceImpl serviceService;


    @GetMapping(value = "/trang-chu")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("user/home");
        int NUMBER_MENUFOOD_LIMIT = 5;
        int NUMBER_WEDDINGHALL_LIMIT = 3;
        List<MenuFood> listMenuFood = menuFoodService.getMenuFoodByNumber(NUMBER_MENUFOOD_LIMIT);
        List<WeddingHall> weddingHallList = weddingHallService.getWeddingHallByNumber(NUMBER_WEDDINGHALL_LIMIT);
        List<Service> serviceServiceList = serviceService.getService();
        mv.addObject("listMenuFood",listMenuFood);
        mv.addObject("listWeddingHall",weddingHallList);
        mv.addObject("listService",serviceServiceList);
        return mv;
    }
}
