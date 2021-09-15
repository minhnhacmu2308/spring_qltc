package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.BookService;
import com.qltc.springqltc.domains.Booking;
import com.qltc.springqltc.domains.Shift;
import com.qltc.springqltc.serviceimpl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminBookingController {
    @Autowired
    BookingServiceImpl bookingService;

    @GetMapping(value = "/tiec-cuoi")
    public ModelAndView index(String msg){
        ModelAndView mv = new ModelAndView("admin/booking");

        List<Booking> list = bookingService.findAll();
        List<BookService> listb = bookingService.getBookSer();
        mv.addObject(MyConstants.MSG,msg);
        mv.addObject("list",list);
        mv.addObject("listb",listb);
        return mv;
    }
    @PostMapping(value = "/booking-delete")
    public ModelAndView delete(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:tiec-cuoi");
        String id = request.getParameter("id");
        int idc = Integer.parseInt(id);
        bookingService.delete(idc);
        mv.addObject("msg",MyConstants.MSG_SUCCESS);
        return mv;
    }
}
