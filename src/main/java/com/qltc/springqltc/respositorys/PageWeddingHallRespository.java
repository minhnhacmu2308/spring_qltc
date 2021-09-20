package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.WeddingHall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageWeddingHallRespository extends PagingAndSortingRepository<WeddingHall,Integer> {

    @Query(value = "SELECT * FROM weddinghall WHERE name LIKE ?",nativeQuery = true)
    Page<WeddingHall> searchAndPagine(String keySearch, Pageable pageable);

    @Query(value = "SELECT * FROM weddinghall WHERE status = 1",nativeQuery = true)
    Page<WeddingHall> getStatus(Pageable pageable);

}
