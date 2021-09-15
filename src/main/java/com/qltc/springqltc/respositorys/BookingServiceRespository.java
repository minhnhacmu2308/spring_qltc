package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.BookService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookingServiceRespository extends JpaRepository<BookService,Integer> {

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO bookingservice(id_booking,id_service) VALUES (?,?)",nativeQuery = true)
    void save(int id_booking,int id_service);

    @Query(value = "SELECT * FROM bookingservice ",nativeQuery = true)
    List<BookService> getBookSer();
}
