package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.Shift;

import java.util.List;

public interface ShiftService {

    List<Shift> getAll();

    Shift findShiftById(int id);

    Shift save(Shift shift);

    List<Shift> getSer();
    int update(String name, int cost, int id);

    int delete(int id);
}
