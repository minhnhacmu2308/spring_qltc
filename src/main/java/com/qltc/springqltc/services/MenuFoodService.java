package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.MenuFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuFoodService {

    Page<MenuFood> findAll(Pageable pageable);

    List<MenuFood> getMenuFoodByNumber(int number);

    MenuFood findById(int id);
}
