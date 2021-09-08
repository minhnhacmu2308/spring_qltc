package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.WeddingHall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PageWeddingHallService {
    Page<WeddingHall> findAll(Pageable pageable);

    Page<WeddingHall> search(String keySearch,Pageable pageable);
}
