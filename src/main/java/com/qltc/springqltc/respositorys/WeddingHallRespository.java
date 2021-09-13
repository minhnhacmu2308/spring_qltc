package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.WeddingHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WeddingHallRespository extends JpaRepository<WeddingHall,Integer> {

    @Query(value = "SELECT * FROM weddinghall LIMIT ?",nativeQuery = true)
    List<WeddingHall> getWeddingHallByNumber(int number);

    @Query(value = "SELECT * FROM weddinghall WHERE status = 1",nativeQuery = true)
    List<WeddingHall> getWeddingHall();

    WeddingHall findById(int id);

    List<WeddingHall> findAll();

    @Query(value = "SELECT view FROM weddinghall where id = ?",nativeQuery = true)
    int getViewCurrent(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE weddinghall SET view = ? WHERE id = ?",nativeQuery = true)
    int updateView(int number,int id);

}
