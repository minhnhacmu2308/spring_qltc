package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.Booking;
import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.respositorys.WeddingHallRespository;
import com.qltc.springqltc.services.WeddingHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeddingHallServiceImpl implements WeddingHallService {
    @Autowired
    WeddingHallRespository weddingHallRespository;

    @Override
    public List<WeddingHall> getWeddingHallByNumber(int number) {
        return weddingHallRespository.getWeddingHallByNumber(number);
    }



    @Override
    public List<WeddingHall> getWeddingHall() {
        return weddingHallRespository.getWeddingHall();
    }
    @Override
    public WeddingHall save(WeddingHall weddingHall) {
        return weddingHallRespository.save(weddingHall);
    }
    @Override
    public WeddingHall findById(int id) {
        return weddingHallRespository.findById(id);
    }

    @Override
    public List<WeddingHall> findAll() {
        return null;
    }

    @Override
    public int update(String name, int cost,String description, String image, int id) {
        return weddingHallRespository.update(name,cost,description,image,id);
    }

    @Override
    public int delete(int id) {
        return weddingHallRespository.delete(id);
    }

    @Override
    public int numberViewCurrent(int id) {
        return weddingHallRespository.getViewCurrent(id);
    }

    @Override
    public int updateView(int number, int id) {
        return weddingHallRespository.updateView(number,id);
    }

}
