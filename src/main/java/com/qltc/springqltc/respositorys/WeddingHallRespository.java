package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.WeddingHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeddingHallRespository extends JpaRepository<WeddingHall,Integer> {

    @Query(value = "SELECT * FROM weddinghall LIMIT ?",nativeQuery = true)
    List<WeddingHall> getWeddingHallByNumber(int number);

    WeddingHall findById(int id);
}
