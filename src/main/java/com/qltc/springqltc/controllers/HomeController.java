package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.respositorys.MenuFoodRespository;
import com.qltc.springqltc.respositorys.UserRespository;
import com.qltc.springqltc.serviceimpl.MenuFoodServiceImpl;
import com.qltc.springqltc.serviceimpl.PageWeddingHallServiceImpl;
import com.qltc.springqltc.serviceimpl.ServiceServiceImpl;
import com.qltc.springqltc.serviceimpl.WeddingHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    MenuFoodServiceImpl menuFoodService;

    @Autowired
    WeddingHallServiceImpl weddingHallService;

    @Autowired
    PageWeddingHallServiceImpl pageWeddingHallService;

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

    @GetMapping(value = "/tim-kiem")
    public ModelAndView search(HttpServletRequest request,@RequestParam("page") Optional<Integer> page){
        ModelAndView mv = new ModelAndView("user/search");
        String keysearch = request.getParameter("keysearch");
        System.out.println(keysearch);
        Pageable pageable = PageRequest.of(page.orElse(0),1);
        System.out.println(page.orElse(0).intValue());
        String keySearchNew = "%"+ keysearch +"%";
        Page<WeddingHall> list = pageWeddingHallService.search(keySearchNew,pageable);
        System.out.println(list);
        mv.addObject("keysearch", keysearch);
        mv.addObject("list", list);
        mv.addObject("numberPage",page.orElse(0).intValue());
        return mv;
    }
}
