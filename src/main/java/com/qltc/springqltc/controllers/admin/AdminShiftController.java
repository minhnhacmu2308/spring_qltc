package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.Shift;
import com.qltc.springqltc.serviceimpl.ServiceServiceImpl;
import com.qltc.springqltc.serviceimpl.ShiftServiceImpl;
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
public class AdminShiftController {
    @Autowired
    ShiftServiceImpl shiftService;


    @GetMapping(value = "/shift")
    public ModelAndView index(String msg){
        ModelAndView mv = new ModelAndView("admin/shift");

        List<Shift> list = shiftService.getSer();
        mv.addObject(MyConstants.MSG,msg);
        mv.addObject("list",list);
        return mv;
    }
    @PostMapping(value = "/shift-add")
    public ModelAndView add(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:shift");
        String name = request.getParameter("namehall");
        String cost = request.getParameter("cost");
        int costhall = Integer.parseInt(cost);

        Shift shift = new Shift();
        shift.setName(name);
        shift.setCost(costhall);

        shift.setStatus(1);

        shiftService.save(shift);
        mv.addObject("msg",MyConstants.MSG_SUCCESS);

        return mv;
    }
    @PostMapping(value = "/shift-update")
    public ModelAndView update(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:shift");
        String name = request.getParameter("namehall");
        String cost = request.getParameter("cost");

        int costhall = Integer.parseInt(cost);
        int id = Integer.parseInt(request.getParameter("id"));

        shiftService.update(name,costhall,id);
        mv.addObject("msg",MyConstants.MSG_SUCCESS);

        return mv;
    }
    @PostMapping(value = "/shift-delete")
    public ModelAndView delete(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:shift");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        shiftService.delete(idc);
        mv.addObject("msg",MyConstants.MSG_SUCCESS);
        return mv;
    }
}
