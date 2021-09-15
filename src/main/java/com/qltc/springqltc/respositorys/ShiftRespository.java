package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShiftRespository extends JpaRepository<Shift,Integer> {
    Shift findShiftById(int id);
    Shift save(Shift Shift);

    @Query(value = "SELECT * FROM shift WHERE status = 1",nativeQuery = true)
    List<Shift> getSer();



    @Modifying
    @Transactional
    @Query(value = "Update shift SET name = ? , cost = ? WHERE id = ?",nativeQuery = true)
    int update(String name, int cost, int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE shift SET status = 0 WHERE id = ?",nativeQuery = true)
    int delete( int id);
}
