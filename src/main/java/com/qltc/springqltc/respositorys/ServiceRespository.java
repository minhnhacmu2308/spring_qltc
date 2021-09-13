package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRespository extends PagingAndSortingRepository<Service,Integer> {

    @Query(value = "SELECT * FROM service LIMIT 2",nativeQuery = true)
    List<Service> getService();

    Service findById(int id);

    @Query(value = "SELECT * FROM service ",nativeQuery = true)
    List<Service> getAll();

    Service findServiceById(int id);
}
