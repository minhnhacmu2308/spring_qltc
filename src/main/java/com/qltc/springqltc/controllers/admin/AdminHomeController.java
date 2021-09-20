package com.qltc.springqltc.controllers.admin;

import com.qltc.springqltc.serviceimpl.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class AdminHomeController {
    @Autowired
    HomeServiceImpl homeService;

    @GetMapping(value = "/home")
    public ModelAndView index(Principal principal){
        ModelAndView mv = new ModelAndView("admin/index");
        String userName = principal.getName();
        int countW = homeService.countW();
        int countB = homeService.countB();
        int countM = homeService.countM();
        int countS = homeService.countS();
        int counttc = homeService.countCF(1);
        int counthd = homeService.countCF(2);
        int countkd = homeService.countCF(3);
        int y2021 = homeService.totalY(2021);
        int y2020 = homeService.totalY(2020);
        int y2019 = homeService.totalY(2019);
        int m1 = homeService.totalM(1);
        int m2 = homeService.totalM(2);
        int m3 = homeService.totalM(3);
        int m4 = homeService.totalM(4);
        int m5 = homeService.totalM(5);
        int m6 = homeService.totalM(6);
        int m7 = homeService.totalM(7);
        int m8 = homeService.totalM(8);
        int m9 = homeService.totalM(9);
        int m10 = homeService.totalM(10);
        int m11 = homeService.totalM(11);
        int m12 = homeService.totalM(12);
        int q1 = homeService.totalQ(1,3);
        int q2 = homeService.totalQ(4,6);
        int q3 = homeService.totalQ(7,9);
        int q4 = homeService.totalQ(10,12);
        mv.addObject("q1", q1);
        mv.addObject("q2", q2);
        mv.addObject("q3", q3);
        mv.addObject("q4", q4);
        mv.addObject("m1", m1);
        mv.addObject("m2", m2);
        mv.addObject("m3", m3);
        mv.addObject("m4", m4);
        mv.addObject("m5", m5);
        mv.addObject("m6", m6);
        mv.addObject("m7", m7);
        mv.addObject("m8", m8);
        mv.addObject("m9", m9);
        mv.addObject("m10", m10);
        mv.addObject("m11", m11);
        mv.addObject("m12", m12);
        mv.addObject("y2021",y2021);
        mv.addObject("y2020",y2020);
        mv.addObject("y2019",y2019);
        mv.addObject("ctc", counttc);
        mv.addObject("chd", counthd);
        mv.addObject("ckd", countkd);
        mv.addObject("W",countW);
        mv.addObject("B",countB);
        mv.addObject("S",countS);
        mv.addObject("M",countM);
        mv.addObject("userName",userName);
        return mv;
    }

}
