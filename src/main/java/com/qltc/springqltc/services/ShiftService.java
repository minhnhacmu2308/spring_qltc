package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.Shift;

import java.util.List;

public interface ShiftService {

    List<Shift> getAll();

    Shift findShiftById(int id);
}
