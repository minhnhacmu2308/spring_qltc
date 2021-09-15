package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.Contact;
import com.qltc.springqltc.domains.Role;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.User;
import com.qltc.springqltc.serviceimpl.ContactServiceImpl;
import com.qltc.springqltc.serviceimpl.UserServiceImpl;
import com.qltc.springqltc.utils.EncrytedPasswordUtils;
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
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    UserServiceImpl userService ;
    EncrytedPasswordUtils encrytedPasswordUtils = new EncrytedPasswordUtils();
    @GetMapping(value = "/khach-hang")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("admin/customer");
        List<User> list = userService.getCus();
        mv.addObject("list",list);
        return mv;
    }
    UploadFile uploadFile = new UploadFile();
    @GetMapping(value = "/nhan-vien")
    public ModelAndView index(String msg){
        ModelAndView mv = new ModelAndView("admin/employee");
        List<User> list = userService.getEm();
        mv.addObject(MyConstants.MSG,msg);
        mv.addObject("list",list);
        return mv;
    }
    @PostMapping(value = "/user-add")
    public ModelAndView add(HttpServletRequest request, @RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:nhan-vien");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordEncryte = encrytedPasswordUtils.md5(password);
        String anh = uploadFile.upload(request,image);
        User user = new User();
        Role role = new Role();
        role.setId(3);
        user.setFullName(fullname);
        user.setEmail(email);
        user.setPhoneNumber(phonenumber);
        user.setAddress(address);
        user.setUserName(username);
        user.setPassword(passwordEncryte);
        user.setImage(anh);
        user.setEnable(1);
        user.setRole(role);
        if(!anh.isEmpty()){
            userService.save(user);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }else{
            System.out.println(MyConstants.MSG_FAILED);
        }
        return mv;
    }
    @PostMapping(value = "/user-update")
    public ModelAndView update(HttpServletRequest request,@RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:nhan-vien");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordEncryte = encrytedPasswordUtils.md5(password);
        String anh = uploadFile.upload(request,image);
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        if (!password.isEmpty()){
            if(!anh.isEmpty()){
                userService.update(fullname,email,phonenumber,address,username,passwordEncryte,anh,id);
                mv.addObject("msg",MyConstants.MSG_SUCCESS);
            }else{
                userService.update(fullname,email,phonenumber,address,username,passwordEncryte,user.getImage(),id);
                mv.addObject("msg",MyConstants.MSG_SUCCESS);
            }
        }
        else{
            if(!anh.isEmpty()){
                userService.update(fullname,email,phonenumber,address,username,user.getPassword(),anh,id);
                mv.addObject("msg",MyConstants.MSG_SUCCESS);
            }else{
                userService.update(fullname,email,phonenumber,address,username,user.getPassword(),user.getImage(),id);
                mv.addObject("msg",MyConstants.MSG_SUCCESS);
            }
        }

        return mv;
    }
    @PostMapping(value = "/user-delete")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:nhan-vien");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        userService.delete(idc);
        mv.addObject("msg",MyConstants.MSG_SUCCESS);
        return mv;
    }
}
