package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.respositorys.ServiceRespository;
import com.qltc.springqltc.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRespository serviceRespository;

    @Override
    public List<Service> getService() {
        return serviceRespository.getService();
    }

    @Override
    public Service findById(int id) {
        return serviceRespository.findById(id);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRespository.findAll(pageable);
    }
}
