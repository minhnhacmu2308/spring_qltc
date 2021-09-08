package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.serviceimpl.PageWeddingHallServiceImpl;
import com.qltc.springqltc.serviceimpl.WeddingHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class WeddingHallController {

    @Autowired
    WeddingHallServiceImpl weddingHallService;

    @Autowired
    PageWeddingHallServiceImpl pageWeddingHallService;

    @GetMapping(value = "sanh-cuoi")
    public ModelAndView getWeddingHall(@RequestParam("page") Optional<Integer> page){
        ModelAndView mv = new ModelAndView("user/weddinghall");
        Pageable pageable = PageRequest.of(page.orElse(0),20);
        Page<WeddingHall> list = pageWeddingHallService.findAll(pageable);
        System.out.println(page.orElse(0).intValue());
        mv.addObject("list",list);
        mv.addObject("numberPage",page.orElse(0).intValue());
        return mv;
    }
    @GetMapping(value = "chi-tiet-sanh-cuoi")
    public ModelAndView getDetailWeddingHall(@RequestParam(name = "id") int id){
        ModelAndView mv = new ModelAndView("user/detailweddinghall");
        WeddingHall weddingHall = weddingHallService.findById(id);
        mv.addObject("weddinghall",weddingHall);
        return mv;
    }

    /*@GetMapping(value = "danh-sach-sanh-cuoi")
    public ModelAndView paginate(@RequestParam("page") Optional<Integer> page){
        ModelAndView mv
    }*/
}
