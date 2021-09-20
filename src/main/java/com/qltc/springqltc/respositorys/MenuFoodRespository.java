package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.WeddingHall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface MenuFoodRespository extends PagingAndSortingRepository<MenuFood,Integer> {

    Page<MenuFood> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM menufood LIMIT ?",nativeQuery = true)
    List<MenuFood> getMenuFoodByNumber(int number);

    MenuFood findById(int id);

    @Query(value = "SELECT * FROM menufood WHERE status = 1",nativeQuery = true)
    Page<MenuFood> getStatus(Pageable pageable);

    @Query(value = "SELECT * FROM menufood WHERE status = 1",nativeQuery = true)
    List<MenuFood> getAll();

    MenuFood findMenuFoodById(int id);

    MenuFood save(MenuFood menuFood);

    @Query(value = "SELECT * FROM menufood WHERE status = 1",nativeQuery = true)
    List<MenuFood> getSer();



    @Modifying
    @Transactional
    @Query(value = "Update menufood SET name = ? , cost = ?, description = ?, image = ? WHERE id = ?",nativeQuery = true)
    int update(String name, int cost,String description, String image, int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE menufood SET status = 0 WHERE id = ?",nativeQuery = true)
    int delete( int id);

    @Query(value = "SELECT COUNT(id) FROM menufood ",nativeQuery = true)
    int countM();
}
