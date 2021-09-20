package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.MenuFood;
import com.qltc.springqltc.domains.Service;
import com.qltc.springqltc.domains.WeddingHall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ServiceRespository extends PagingAndSortingRepository<Service,Integer> {

    @Query(value = "SELECT * FROM service LIMIT 2",nativeQuery = true)
    List<Service> getService();

    Service findById(int id);

    @Query(value = "SELECT * FROM service WHERE status = 1",nativeQuery = true)
    Page<Service> getStatus(Pageable pageable);

    @Query(value = "SELECT * FROM service WHERE status = 1",nativeQuery = true)
    List<Service> getAll();

    Service findServiceById(int id);

    Service save(Service service);

    @Query(value = "SELECT * FROM service WHERE status = 1",nativeQuery = true)
    List<Service> getSer();



    @Modifying
    @Transactional
    @Query(value = "Update service SET name = ? , cost = ?, description = ?, image = ? WHERE id = ?",nativeQuery = true)
    int update(String name, int cost,String description, String image, int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE service SET status = 0 WHERE id = ?",nativeQuery = true)
    int delete( int id);

    @Query(value = "SELECT COUNT(id) FROM service ",nativeQuery = true)
    int countS();
}
