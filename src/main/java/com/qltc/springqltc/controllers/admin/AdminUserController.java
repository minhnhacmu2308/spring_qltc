package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.Contact;
import com.qltc.springqltc.domains.Role;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.User;
import com.qltc.springqltc.serviceimpl.ContactServiceImpl;
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
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    UserServiceImpl userService ;

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
        String anh = uploadFile.upload(request,image);
        User user = new User();
        Role role = userService.findRoleById(1);
        user.setFullName(fullname);
        user.setEmail(email);
        user.setPhoneNumber(phonenumber);
        user.setAddress(address);
        user.setUserName(username);
        user.setPassword(password);
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
    /*@PostMapping(value = "/service-update")
    public ModelAndView update(HttpServletRequest request,@RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:dich-vu");
        String name = request.getParameter("namehall");
        String cost = request.getParameter("cost");
        String img = request.getParameter("img");
        int costhall = Integer.parseInt(cost);
        int id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        String anh = uploadFile.upload(request,image);
        if(!anh.isEmpty()){
            serviceService.update(name,costhall,description,anh,id);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }else{
            serviceService.update(name,costhall,description,img,id);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }
        return mv;
    }*/
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
