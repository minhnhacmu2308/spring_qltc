package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.MenuFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuFoodRespository extends JpaRepository<MenuFood,Integer> {
    List<MenuFood> findAll();

    @Query(value = "SELECT * FROM menufood LIMIT ?",nativeQuery = true)
    List<MenuFood> getMenuFoodByNumber(int number);

    MenuFood findById(int id);

}
