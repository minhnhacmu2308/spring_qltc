package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.Booking;
import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.serviceimpl.BookingServiceImpl;
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
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminWeddingHallController {
    @Autowired
    WeddingHallServiceImpl weddingHallService;
    @Autowired
    BookingServiceImpl bookingService;
    UploadFile uploadFile = new UploadFile();
    @GetMapping(value = "/sanh-cuoi")
    public ModelAndView index(String msg){
        ModelAndView mv = new ModelAndView("admin/weddinghall");

        List<WeddingHall> list = weddingHallService.getWeddingHall();
        mv.addObject(MyConstants.MSG,msg);
        mv.addObject("list",list);
        return mv;
    }
    @PostMapping(value = "/weddinghall-add")
    public ModelAndView add(HttpServletRequest request,@RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:sanh-cuoi");
        String name = request.getParameter("namehall");
        String cost = request.getParameter("cost");
        int costhall = Integer.parseInt(cost);
        String description = request.getParameter("description");
        String anh = uploadFile.upload(request,image);
        WeddingHall weddingHall = new WeddingHall();
        weddingHall.setName(name);
        weddingHall.setCost(costhall);
        weddingHall.setDescription(description);
        weddingHall.setImage(anh);
        weddingHall.setStatus(1);
        if(!anh.isEmpty()){
            weddingHallService.save(weddingHall);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }else{
            System.out.println(MyConstants.MSG_FAILED);
        }
        return mv;
    }
    @PostMapping(value = "/weddinghall-update")
    public ModelAndView update(HttpServletRequest request,@RequestParam("file") MultipartFile image){
        ModelAndView mv = new ModelAndView("redirect:sanh-cuoi");
        String name = request.getParameter("namehall");
        String cost = request.getParameter("cost");
        String img = request.getParameter("img");
        int costhall = Integer.parseInt(cost);
        int id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        String anh = uploadFile.upload(request,image);
        if(!anh.isEmpty()){
            weddingHallService.update(name,costhall,description,anh,id);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }else{
            weddingHallService.update(name,costhall,description,img,id);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }
        return mv;
    }
    @PostMapping(value = "/weddinghall-delete")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:sanh-cuoi");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        List<Booking> listb = bookingService.check(idc);
        if(listb.size() > 0){
            mv.addObject("msg",MyConstants.MSG_EXISTS);
        }
        else{
            weddingHallService.delete(idc);
            mv.addObject("msg",MyConstants.MSG_SUCCESS);
        }
        return mv;
    }
}
