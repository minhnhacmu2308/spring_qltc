package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    List<Service> getService();

    Service findById(int id);

    Page<Service> findAll(Pageable pageable);

    List<Service> getAll();

    Service findServiceById(int id);
}
