package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.BookService;
import com.qltc.springqltc.domains.Booking;
import com.qltc.springqltc.serviceimpl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingServiceImpl bookingService;


    @GetMapping(value = "/lich-su-dat-tiec")
    public ModelAndView getHistoryBooking(@RequestParam(name = "id") int id){
        ModelAndView mv = new ModelAndView("user/historybooking");
        List<Booking> list = bookingService.findBookingById(id);
        List<BookService> listB = bookingService.getBookSer();
        mv.addObject("list",list);
        mv.addObject("listB",listB);
        return mv;
    }
}
