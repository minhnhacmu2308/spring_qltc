package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.Booking;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookingRespository extends PagingAndSortingRepository<Booking,Integer> {

    Booking save(Booking booking);

    @Query(value = "SELECT * FROM booking ORDER BY id DESC  LIMIT 1",nativeQuery = true)
    Booking findTop();

    @Query(value = "SELECT * FROM booking WHERE dateheld = ? and id_weddinghall = ? and id_shift = ?",nativeQuery = true)
    Booking checkBookingExist(String dateHeld,int idWeddingHall,int idShift);

    @Query(value = "SELECT * FROM booking WHERE id_weddinghall = ?",nativeQuery = true)
    List<Booking> check(int id);

    List<Booking> findAll();

    @Modifying
    @Transactional
    @Query(value = "UPDATE booking SET status = 1 WHERE id = ?",nativeQuery = true)
    int delete( int id);

    @Query(value = "SELECT COUNT(id) FROM booking ",nativeQuery = true)
    int countB();

    @Query(value = "SELECT COUNT(id) FROM booking WHERE id_shift = ? ",nativeQuery = true)
    int countCF(int id);

    @Query(value = "SELECT SUM(total) FROM booking WHERE YEAR(dateheld) = ?",nativeQuery = true)
    int totalY(int number);

    @Query(value = "SELECT SUM(total) FROM booking WHERE MONTH(dateheld) = ? AND YEAR(dateheld) = 2021",nativeQuery = true)
    int totalM(int number);

    @Query(value = "SELECT SUM(total) FROM booking WHERE MONTH(dateheld) >= ? AND MONTH(dateheld) <= ? AND YEAR(dateheld) = 2021",nativeQuery = true)
    int totalQ(int min,int max);

    @Query(value = "select * from booking where id_user = ?",nativeQuery = true)
    List<Booking> findBookingById(int idUser);
}
