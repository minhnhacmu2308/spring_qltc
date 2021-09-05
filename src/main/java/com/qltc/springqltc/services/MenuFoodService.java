package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.MenuFood;

import java.util.List;

public interface MenuFoodService {
    List<MenuFood> findAll();

    List<MenuFood> getMenuFoodByNumber(int number);

    MenuFood findById(int id);
}
