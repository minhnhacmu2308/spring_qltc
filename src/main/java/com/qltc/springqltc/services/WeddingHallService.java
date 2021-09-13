package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.WeddingHall;

import java.util.List;

public interface WeddingHallService {

    List<WeddingHall> getWeddingHallByNumber(int number);

    List<WeddingHall> getWeddingHall();

    WeddingHall findById(int id);

    List<WeddingHall> findAll();

    int numberViewCurrent(int id);

    int updateView(int number ,int id);
}
