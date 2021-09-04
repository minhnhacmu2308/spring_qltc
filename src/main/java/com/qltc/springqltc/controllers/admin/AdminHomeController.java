package com.qltc.springqltc.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
    @GetMapping(value = "/home")
    public ModelAndView index(Principal principal){
        ModelAndView mv = new ModelAndView("admin/index");
        String userName = principal.getName();
        mv.addObject("userName",userName);
        return mv;
    }

}
