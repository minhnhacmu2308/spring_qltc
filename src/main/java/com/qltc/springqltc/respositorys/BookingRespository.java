package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRespository extends PagingAndSortingRepository<Booking,Integer> {

    Booking save(Booking booking);

    @Query(value = "SELECT * FROM booking ORDER BY id DESC  LIMIT 1",nativeQuery = true)
    Booking findTop();

    @Query(value = "SELECT * FROM booking WHERE dateheld = ? and id_webdinghall = ? and id_shift = ?",nativeQuery = true)
    Booking checkBookingExist(String dateHeld,int idWeddingHall,int idShift);

    @Query(value = "SELECT * FROM booking WHERE id_weddinghall = ?",nativeQuery = true)
    List<Booking> check(int id);
}
