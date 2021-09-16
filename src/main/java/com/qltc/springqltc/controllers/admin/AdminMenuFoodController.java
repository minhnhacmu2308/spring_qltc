package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.serviceimpl.MenuFoodServiceImpl;
import com.qltc.springqltc.serviceimpl.ServiceServiceImpl;
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
public class AdminMenuFoodController {
    @Autowired
    MenuFoodServiceImpl menuFoodService;

    UploadFile uploadFile = new UploadFile();
    @GetMapping(value = "/menu-food")
    public ModelAndView index(String msg){
        ModelAndView mv = new ModelAndView("admin/menufood");

        List<MenuFood> list = menuFoodService.getSer();
        mv.addObject(MyConstants.MSG,msg);
        mv.addObject("list",list);
        return mv;
    }
    @PostMapping(value = "/menu-add")
    public ModelAndView add(HttpServletRequest request, @RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:menu-food");
        String name = request.getParameter("namehall");
        String cost = request.getParameter("cost");
        int costhall = Integer.parseInt(cost);
        String description = request.getParameter("description");
        String anh = uploadFile.upload(request,image);
        MenuFood menuFood = new MenuFood();
        menuFood.setName(name);
        menuFood.setCost(costhall);
        menuFood.setDescription(description);
        menuFood.setImage(anh);
        menuFood.setStatus(1);
        if(!image.isEmpty()){
            menuFoodService.save(menuFood);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }else{
            System.out.println(MyConstants.MSG_FAILED);
        }
        return mv;
    }
    @PostMapping(value = "/menu-update")
    public ModelAndView update(HttpServletRequest request,@RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:menu-food");
        String name = request.getParameter("namehall");
        String cost = request.getParameter("cost");
        String img = request.getParameter("img");
        int costhall = Integer.parseInt(cost);
        int id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        String anh = uploadFile.upload(request,image);
        if(!image.isEmpty()){
            menuFoodService.update(name,costhall,description,anh,id);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }else{
            menuFoodService.update(name,costhall,description,img,id);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }
        return mv;
    }
    @PostMapping(value = "/menu-delete")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:menu-food");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        menuFoodService.delete(idc);
        mv.addObject("msg",MyConstants.MSG_SUCCESS);
        return mv;
    }
}
