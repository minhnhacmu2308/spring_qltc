package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuFoodService {

    Page<MenuFood> findAll(Pageable pageable);

    List<MenuFood> getMenuFoodByNumber(int number);

    MenuFood findById(int id);

    List<MenuFood> getAll();

    MenuFood findMenuById(int id);

    MenuFood save(MenuFood menuFood);

    List<MenuFood> getSer();
    int update(String name, int cost,String description, String image, int id);

    int delete(int id);
}
