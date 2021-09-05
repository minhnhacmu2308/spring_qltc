package com.qltc.springqltc.controllers;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.Role;
import com.qltc.springqltc.domains.User;
import com.qltc.springqltc.respositorys.UserRespository;
import com.qltc.springqltc.serviceimpl.UserServiceImpl;
import com.qltc.springqltc.utils.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.PushBuilder;
import java.util.Locale;
import java.util.Objects;


@Controller
@RequestMapping("/user/")
public class AuthenticationController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    public UserServiceImpl userService;

    EncrytedPasswordUtils encrytedPasswordUtils = new EncrytedPasswordUtils();

    @GetMapping("dang-nhap")
    public ModelAndView getLogin(String msg){
        ModelAndView mv = new ModelAndView("user/login");
        mv.addObject(MyConstants.MSG,msg);
        return mv;
    }
    @GetMapping("dang-ki")
    public ModelAndView getRegister(){
        ModelAndView mv = new ModelAndView("user/register");
        return mv;
    }
    @PostMapping("post-dang-ki")
    public ModelAndView postRegister(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("user/register");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullname");
        String phoneNumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        if (!password.equalsIgnoreCase(rePassword)){
            mv.addObject(MyConstants.MSG,messageSource.getMessage("password_and_repassword", null, Locale.getDefault()));
        }else{
            String passwordEncryte = encrytedPasswordUtils.md5(password);
            Role role = new Role();
            role.setId(1);
            User user = new User();
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setUserName(username);
            user.setPassword(passwordEncryte);
            user.setAddress(address);
            user.setEnable(1);
            user.setRole(role);
            User checkUser = userService.findByUserName(username);
            if (!Objects.isNull(checkUser)){
                mv.addObject(MyConstants.MSG,messageSource.getMessage("email_exited",null,Locale.getDefault()));
            }else{
                User userSave = userService.save(user);
                if(!Objects.isNull(userSave)){
                    mv = new ModelAndView("user/login");
                }
            }
        }
        return  mv;
    }
    @PostMapping("post-dang-nhap")
    public ModelAndView postLogin(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:dang-nhap");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordEncryte = encrytedPasswordUtils.md5(password);
        User user = userService.findByUserNameAndPassword(username,passwordEncryte);
        if(!Objects.isNull(user)){
            User userInfo = userService.findByUserName(username);
            HttpSession session = request.getSession();
            session.setAttribute(MyConstants.SESSION_USER, userInfo);
            mv = new ModelAndView("redirect:/trang-chu");
        }else{
            mv.addObject(MyConstants.MSG,messageSource.getMessage("password_or_username_incorret",null,Locale.getDefault()));
        }
        return mv;
    }
    @GetMapping(value = "dang-xuat")
    public ModelAndView getLogout(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:/trang-chu");
        HttpSession session = request.getSession(false);
        session.invalidate();
        return mv;
    }
}
