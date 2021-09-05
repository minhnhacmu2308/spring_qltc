package com.qltc.springqltc.controllers;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.Contact;
import com.qltc.springqltc.serviceimpl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Objects;

@Controller
public class ContactController {
    @Autowired
    public ContactServiceImpl contactService;

    @Autowired
    MessageSource messageSource;

    @GetMapping(value = "/lien-he")
    public ModelAndView getContact(){
        ModelAndView mv = new ModelAndView("user/contact");
        return mv;
    }

    @PostMapping(value = "/lien-he")
    public ModelAndView postContact(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("user/contact");
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String phonenumber = request.getParameter("phonenumber");
        String content = request.getParameter("content");
        Contact contact = new Contact();
        contact.setContent(content);
        contact.setFullName(fullname);
        contact.setStatus(0);
        contact.setEmail(email);
        contact.setPhoneNumber(phonenumber);
        Contact contactObj = contactService.save(contact);
        if(!Objects.isNull(contactObj)){
            mv.addObject(MyConstants.MSG,messageSource.getMessage("contact_success",null, Locale.getDefault()));
        }
        return mv;
    }
}
