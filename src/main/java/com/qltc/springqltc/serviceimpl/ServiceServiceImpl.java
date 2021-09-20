package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.WeddingHall;
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
        return serviceRespository.getStatus(pageable);
    }

    @Override
    public List<Service> getAll() {
        return serviceRespository.getAll();
    }

    @Override
    public Service findServiceById(int id) {
        return serviceRespository.findServiceById(id);
    }

    @Override
    public Service save(Service service) {
        return serviceRespository.save(service);
    }

    @Override
    public List<Service> getSer() {
        return serviceRespository.getSer();
    }

    @Override
    public int update(String name, int cost,String description, String image, int id) {
        return serviceRespository.update(name,cost,description,image,id);
    }

    @Override
    public int delete(int id) {
        return serviceRespository.delete(id);
    }
}
