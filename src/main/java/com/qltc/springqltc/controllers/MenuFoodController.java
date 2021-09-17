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
public class MenuFoodController {

    @Autowired
    MenuFoodServiceImpl menuFoodService;

    @Autowired
    WeddingHallServiceImpl weddingHallService;


    @GetMapping(value = "chi-tiet-menu-thuc-an")
    public ModelAndView getDetailMenuFood(@RequestParam(required = false,name = "id") int id){
        ModelAndView mv = new ModelAndView("user/detailmenufood");
        MenuFood menuFood = menuFoodService.findById(id);
        System.out.println(menuFood);
        mv.addObject("menufood",menuFood);
        return mv;
    }

    @GetMapping(value = "danh-sach-menu-thuc-an")
    public ModelAndView getListMenu(@RequestParam("page") Optional<Integer> page){
        ModelAndView mv = new ModelAndView("user/menufood");
        Pageable pageable = PageRequest.of(page.orElse(0),20);
        Page<MenuFood> list = menuFoodService.findAll(pageable);
        System.out.println(page.orElse(0).intValue());
        System.out.println(list);
        List<WeddingHall> listW = weddingHallService.getWeddingHallByNumber(5);
        mv.addObject("list",list);
        mv.addObject("listW",listW);
        mv.addObject("numberPage",page.orElse(0).intValue());
        return mv;
    }
}
