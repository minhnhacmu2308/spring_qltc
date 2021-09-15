package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.respositorys.BookingRespository;
import com.qltc.springqltc.respositorys.MenuFoodRespository;
import com.qltc.springqltc.respositorys.ServiceRespository;
import com.qltc.springqltc.respositorys.WeddingHallRespository;
import com.qltc.springqltc.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    WeddingHallRespository weddingHallRespository;

    @Autowired
    ServiceRespository serviceRespository;

    @Autowired
    MenuFoodRespository menuFoodRespository;

    @Autowired
    BookingRespository bookingRespository;

    @Override
    public int countW() {
        return weddingHallRespository.countW();
    }

    @Override
    public int countS() {
        return serviceRespository.countS();
    }

    @Override
    public int countM() {
        return menuFoodRespository.countM();
    }

    @Override
    public int countB() {
        return bookingRespository.countB();
    }

    @Override
    public int countCF(int id) {
        return bookingRespository.countCF(id);
    }

    @Override
    public int totalY(int number) {
        return bookingRespository.totalY(number);
    }

    @Override
    public int totalM(int number) {
        return bookingRespository.totalM(number);
    }

    @Override
    public int totalQ(int min,int max) {
        return bookingRespository.totalQ(min,max);
    }

}
