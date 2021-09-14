package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.Contact;
import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.serviceimpl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminContactController {
    @Autowired
    ContactServiceImpl contactService ;

    @GetMapping(value = "/lien-he")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("admin/contact");

        List<Contact> list = contactService.findAll();

        System.out.println(list);
        mv.addObject("list",list);
        return mv;
    }
}
