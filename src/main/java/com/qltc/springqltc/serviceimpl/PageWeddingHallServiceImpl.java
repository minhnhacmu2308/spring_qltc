package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.WeddingHall;
import com.qltc.springqltc.respositorys.PageWeddingHallRespository;
import com.qltc.springqltc.services.PageWeddingHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PageWeddingHallServiceImpl implements PageWeddingHallService {

    @Autowired
    PageWeddingHallRespository pageWeddingHallRespository;

    @Override
    public Page<WeddingHall> findAll(Pageable pageable) {
        return pageWeddingHallRespository.findAll(pageable);
    }

    @Override
    public Page<WeddingHall> search(String keySearch, Pageable pageable) {
        return pageWeddingHallRespository.searchAndPagine(keySearch,pageable);
    }
}
