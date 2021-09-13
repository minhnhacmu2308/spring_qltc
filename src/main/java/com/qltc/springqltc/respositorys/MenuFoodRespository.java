package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.MenuFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuFoodRespository extends PagingAndSortingRepository<MenuFood,Integer> {

    Page<MenuFood> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM menufood LIMIT ?",nativeQuery = true)
    List<MenuFood> getMenuFoodByNumber(int number);

    MenuFood findById(int id);

    @Query(value = "SELECT * FROM menufood ",nativeQuery = true)
    List<MenuFood> getAll();

    MenuFood findMenuFoodById(int id);

}
