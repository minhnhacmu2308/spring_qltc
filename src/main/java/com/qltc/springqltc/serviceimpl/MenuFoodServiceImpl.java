package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.respositorys.MenuFoodRespository;
import com.qltc.springqltc.services.MenuFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuFoodServiceImpl implements MenuFoodService {
    @Autowired
    MenuFoodRespository menuFoodRespository;

    @Override
    public Page<MenuFood> findAll(Pageable pageable) {
        return menuFoodRespository.findAll(pageable);
    }

    @Override
    public List<MenuFood> getMenuFoodByNumber(int number) {
        return menuFoodRespository.getMenuFoodByNumber(number);
    }

    @Override
    public MenuFood findById(int id) {
        return menuFoodRespository.findById(id);
    }
}
