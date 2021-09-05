package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.Service;

import java.util.List;

public interface ServiceService {
    List<Service> getService();
    Service findById(int id);
}
