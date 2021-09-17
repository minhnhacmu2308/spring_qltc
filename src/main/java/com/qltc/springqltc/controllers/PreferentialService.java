package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.serviceimpl.MenuFoodServiceImpl;
import com.qltc.springqltc.serviceimpl.ServiceServiceImpl;
import com.qltc.springqltc.serviceimpl.WeddingHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class PreferentialService {
    @Autowired
    ServiceServiceImpl serviceService;

    @Autowired
    WeddingHallServiceImpl weddingHallService;

    @Autowired
    MenuFoodServiceImpl menuFoodService;

    @GetMapping(value = "dich-vu-va-uu-dai")
    public ModelAndView index(@RequestParam("page") Optional<Integer> page){
        ModelAndView mv = new ModelAndView("user/service");
        Pageable pageable = PageRequest.of(page.orElse(0),20);
        Page<Service> list = serviceService.findAll(pageable);
        System.out.println(page.orElse(0).intValue());
        System.out.println(list);
        List<WeddingHall> listW = weddingHallService.getWeddingHallByNumber(5);
        List<MenuFood> listM = menuFoodService.getMenuFoodByNumber(5);
        mv.addObject("list",list);
        mv.addObject("listW",listW);
        mv.addObject("listM",listM);
        mv.addObject("numberPage",page.orElse(0).intValue());
        return mv;
    }
}
