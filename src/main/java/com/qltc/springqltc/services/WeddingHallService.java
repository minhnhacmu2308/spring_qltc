package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.Booking;
import com.qltc.springqltc.domains.WeddingHall;

import java.util.List;

public interface WeddingHallService {

    List<WeddingHall> getWeddingHallByNumber(int number);



    List<WeddingHall> getWeddingHall();

    WeddingHall save(WeddingHall weddingHall);

    WeddingHall findById(int id);

    List<WeddingHall> findAll();

    int update(String name, int cost,String description, String image, int id);

    int delete(int id);

    int numberViewCurrent(int id);

    int updateView(int number ,int id);
}
