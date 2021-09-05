package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRespository extends JpaRepository<Service,Integer> {
    @Query(value = "SELECT * FROM service LIMIT 2",nativeQuery = true)
    List<Service> getService();

    Service findById(int id);
}
