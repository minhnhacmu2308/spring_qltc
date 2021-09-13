package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRespository extends JpaRepository<Shift,Integer> {
    Shift findShiftById(int id);
}
