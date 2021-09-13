package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.Shift;
import com.qltc.springqltc.respositorys.ShiftRespository;
import com.qltc.springqltc.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    ShiftRespository shiftRespository;

    @Override
    public List<Shift> getAll() {
        return shiftRespository.findAll();
    }

    @Override
    public Shift findShiftById(int id) {
        return shiftRespository.findShiftById(id);
    }

}
