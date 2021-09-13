package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.serviceimpl.WeddingHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminWeddingHallController {
    @Autowired
    WeddingHallServiceImpl weddingHallService;

    @GetMapping(value = "/sanh-cuoi")
    public ModelAndView index(Principal principal){
        ModelAndView mv = new ModelAndView("admin/weddinghall");
        String userName = principal.getName();
        List<WeddingHall> list = weddingHallService.getWeddingHall();
        mv.addObject("userName",userName);
        mv.addObject("list",list);
        return mv;
    }
}
