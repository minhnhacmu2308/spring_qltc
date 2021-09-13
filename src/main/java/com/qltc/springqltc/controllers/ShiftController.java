package com.qltc.springqltc.controllers;

import com.qltc.springqltc.domains.Shift;
import com.qltc.springqltc.serviceimpl.ShiftServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ShiftController {

    @Autowired
    ShiftServiceImpl shiftService;

   /* @GetMapping(value = "get-shift")
    public void getShift(HttpServletRequest request, HttpServletResponse response){
        List<Shift> list = shiftService.getAll();
        try {
            PrintWriter pw = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            for (Shift shift : list) {
                pw.println(" <option value="+shift.getId()+">"+shift.getName()+"</option>");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}
