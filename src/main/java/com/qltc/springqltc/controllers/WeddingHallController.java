package com.qltc.springqltc.controllers;

import com.qltc.springqltc.constants.MyConstants;
import com.qltc.springqltc.domains.*;
import com.qltc.springqltc.models.ResponseAjax;
import com.qltc.springqltc.serviceimpl.*;
import com.qltc.springqltc.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class WeddingHallController {

    @Autowired
    WeddingHallServiceImpl weddingHallService;

    @Autowired
    PageWeddingHallServiceImpl pageWeddingHallService;

    @Autowired
    ShiftServiceImpl shiftService;

    @Autowired
    MenuFoodServiceImpl menuFoodService;

    @Autowired
    ServiceServiceImpl serviceService;

    @Autowired
    BookingServiceImpl bookingService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "sanh-cuoi")
    public ModelAndView getWeddingHall(@RequestParam("page") Optional<Integer> page){
        ModelAndView mv = new ModelAndView("user/weddinghall");
        Pageable pageable = PageRequest.of(page.orElse(0),20);
        Page<WeddingHall> list = pageWeddingHallService.findAll(pageable);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.roll(Calendar.DATE, 3);
        String datemin = dateFormat.format(cal.getTime());
        List<Shift> listShift = shiftService.getAll();
        List<MenuFood> listMenu = menuFoodService.getAll();
        List<Service> listService = serviceService.getAll();
        System.out.println(page.orElse(0).intValue());
        mv.addObject("dated",datemin);
        mv.addObject("list",list);
        mv.addObject("listS",listShift);
        mv.addObject("listM",listMenu);
        mv.addObject("listService",listService);
        mv.addObject("numberPage",page.orElse(0).intValue());
        return mv;
    }
    @GetMapping(value = "chi-tiet-sanh-cuoi")
    public ModelAndView getDetailWeddingHall(@RequestParam(name = "id") int id){
        ModelAndView mv = new ModelAndView("user/detailweddinghall");
        WeddingHall weddingHall = weddingHallService.findById(id);
        int numberViewCurrent = weddingHallService.numberViewCurrent(id);
        int resultUpdate = weddingHallService.updateView(numberViewCurrent+1,id);
        mv.addObject("weddinghall",weddingHall);
        return mv;
    }

    /*@GetMapping(value = "danh-sach-sanh-cuoi")
    public ModelAndView paginate(@RequestParam("page") Optional<Integer> page){
        ModelAndView mv
    }*/
    @GetMapping(value = "get-sum")
    public void getSum(HttpServletRequest request, HttpServletResponse response){
        String idShift = request.getParameter("idShift");
        String idMenu = request.getParameter("idMenu");
        String idService = request.getParameter("idService");
        String idWeddinghall = request.getParameter("idWeddingHall");
        Shift shift = shiftService.findShiftById(Integer.parseInt(idShift));
        MenuFood menuFood = menuFoodService.findMenuById(Integer.parseInt(idMenu));
        Service  service = null;
        List<Integer> arrSeat = StringUtils.convertStringArray(idService);
        WeddingHall weddingHall = weddingHallService.findById(Integer.parseInt(idWeddinghall));
        int sum = 0;
        System.out.println(arrSeat.size());
        if (arrSeat.size() == 0 ) {
            sum += shift.getCost() + menuFood.getCost() + weddingHall.getCost();
        } else {
            arrSeat = StringUtils.convertStringArray(idService);
            int sumService = 0;
            for (int i = 0; i < arrSeat.size(); i++) {
                service = serviceService.findServiceById(arrSeat.get(i));
                sumService += service.getCost();
            }
            sum += shift.getCost() + menuFood.getCost() + weddingHall.getCost() + sumService;

        }
        try {
            PrintWriter pw = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            pw.println( sum );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @PostMapping(value = "booking")
    public @ResponseBody ResponseAjax bookingParty(HttpServletRequest request, HttpServletResponse response){
        ResponseAjax rA = new ResponseAjax();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(MyConstants.SESSION_USER);

        String idWeddingHall = (String) request.getParameter("idWeddingHall");
        String idShift = (String) request.getParameter("idShift");
        String idService = (String) request.getParameter("idService");
        String idMenuFood = (String) request.getParameter("idMenuFood");
        String dateHeld = (String) request.getParameter("dateHeld");
        String total = (String)request.getParameter("total");
        Booking booking = new Booking();
        WeddingHall weddingHall = weddingHallService.findById(Integer.parseInt(idWeddingHall));
        MenuFood menuFood = menuFoodService.findMenuById(Integer.parseInt(idMenuFood));
        Shift shift = shiftService.findShiftById(Integer.parseInt(idShift));
        if("0".equals(idWeddingHall) || "0".equals(idShift) || "0".equals(idMenuFood) || "0".equals(dateHeld)) {
            rA.setStatus("ErrorEmpty");
            rA.setMessage("❌ Cần chọn đầy đủ thông tin");
        } else {
            if(user == null) {
                rA.setStatus("ErrorLogin");
                rA.setMessage("❌ Bạn cần phải đăng nhập");
            } else if("0".equals(idService)){
                Booking checkExist = bookingService.checkBookingExist(dateHeld,Integer.parseInt(idWeddingHall),Integer.parseInt(idShift));
                if (!Objects.isNull(checkExist)) {
                    rA.setStatus("Error");
                    rA.setMessage("❌ Sảnh khung giờ này đã có người đặt vui lòng đặt lại !!");
                } else {
                    booking.setWeddingHall(weddingHall);
                    booking.setStatus(0);
                    booking.setMenuFood(menuFood);
                    booking.setTotal(total);
                    booking.setUser(user);
                    booking.setShift(shift);
                    booking.setDateHeld(dateHeld);
                    Booking result = bookingService.save(booking);
                    if(!Objects.isNull(result)){
                        rA.setStatus("Success");
                        rA.setMessage("✅ Đặt tiệc thành công");
                    } else {
                        rA.setStatus("Error");
                        rA.setMessage("❌ Đặt tiệc thất bại");
                    }
                }

            } else {
                Booking checkExist = bookingService.checkBookingExist(dateHeld,Integer.parseInt(idWeddingHall),Integer.parseInt(idShift));
                if (!Objects.isNull(checkExist)) {
                    rA.setStatus("Error");
                    rA.setMessage("❌ Sảnh khung giờ này đã có người đặt vui lòng đặt lại !!");
                } else {
                    booking.setWeddingHall(weddingHall);
                    booking.setStatus(0);
                    booking.setMenuFood(menuFood);
                    booking.setTotal(total);
                    booking.setShift(shift);
                    booking.setUser(user);
                    booking.setDateHeld(dateHeld);
                    Booking result = bookingService.save(booking);
                    List<Integer> arrSeat = StringUtils.convertStringArray(idService);
                    Service service = null;
                    Booking booking1 = null;
                    System.out.println(arrSeat.size());
                    for (int i = 0; i < arrSeat.size(); i++) {
                        service = serviceService.findServiceById(arrSeat.get(i));
                        booking1 = bookingService.findTop();

                        bookingService.save(booking1.getId(),service.getId());
                        System.out.println("sd");
                    }
                    if(!Objects.isNull(result)){
                        rA.setStatus("Success");
                        rA.setMessage("✅ Đặt tiệc thành công");
                    } else {
                        rA.setStatus("Error");
                        rA.setMessage("❌ Đặt tiệc thất bại");
                    }
                }

            }
        }
        return rA;
    }
}
