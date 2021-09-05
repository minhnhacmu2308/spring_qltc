package com.qltc.springqltc.controllers;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.User;
import com.qltc.springqltc.serviceimpl.UserServiceImpl;
import com.qltc.springqltc.utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;


@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    public UserServiceImpl userService;

    UploadFile uploadFile = new UploadFile();

    @GetMapping(value = "thong-tin-ca-nhan")
    public ModelAndView getProfile(@RequestParam(required = false,name = "username") String username){
        ModelAndView mv = new ModelAndView("user/profile");
        User user = userService.findByUserName(username);
        mv.addObject("profile",user);
        return mv;
    }
    @PostMapping(value = "doi-anh-dai-dien")
    public ModelAndView postChangeAvatar(HttpServletRequest request, @RequestParam("file") MultipartFile image){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(MyConstants.SESSION_USER);
        String pathView = "redirect:thong-tin-ca-nhan/?username="+ user.getUserName();
        ModelAndView mv = new ModelAndView(pathView);
        String anh = uploadFile.upload(request,image);
        if(!anh.isEmpty()){
            int result = userService.changeAvatar(anh,user.getId());
            if(result == 1) {
                System.out.println(MyConstants.MSG_SUCCESS);
            }else {
                System.out.println(MyConstants.MSG_FAILED);
            }
        }else{
            System.out.println(MyConstants.MSG_FAILED);
        }

        return mv;
    }
}