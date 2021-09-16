package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.Booking;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.serviceimpl.BookingServiceImpl;
import com.qltc.springqltc.serviceimpl.ServiceServiceImpl;
import com.qltc.springqltc.serviceimpl.WeddingHallServiceImpl;
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
public class AdminServiceController {
    @Autowired
    ServiceServiceImpl serviceService;

    UploadFile uploadFile = new UploadFile();
    @GetMapping(value = "/dich-vu")
    public ModelAndView index(String msg){
        ModelAndView mv = new ModelAndView("admin/service");

        List<Service> list = serviceService.getSer();
        mv.addObject(MyConstants.MSG,msg);
        mv.addObject("list",list);
        return mv;
    }
    @PostMapping(value = "/service-add")
    public ModelAndView add(HttpServletRequest request, @RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:dich-vu");
        String name = request.getParameter("namehall");
        String cost = request.getParameter("cost");
        int costhall = Integer.parseInt(cost);
        String description = request.getParameter("description");
        String anh = uploadFile.upload(request,image);
        Service service = new Service();
        service.setName(name);
        service.setCost(costhall);
        service.setDescription(description);
        service.setImage(anh);
        service.setStatus(1);
        if(!image.isEmpty()){
            serviceService.save(service);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }else{
            System.out.println(MyConstants.MSG_FAILED);
        }
        return mv;
    }
    @PostMapping(value = "/service-update")
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
    }
    @PostMapping(value = "/service-delete")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:dich-vu");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        serviceService.delete(idc);
        mv.addObject("msg",MyConstants.MSG_SUCCESS);
        return mv;
    }
}
