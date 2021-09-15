package com.qltc.springqltc.serviceimpl;

import com.qltc.springqltc.domains.BookService;
import com.qltc.springqltc.domains.Booking;
import com.qltc.springqltc.respositorys.BookingRespository;
import com.qltc.springqltc.respositorys.BookingServiceRespository;
import com.qltc.springqltc.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRespository bookingRespository;

    @Autowired
    BookingServiceRespository bookingServiceRespository;

    @Override
    public Booking save(Booking booking) {
        return bookingRespository.save(booking);
    }

    @Override
    public List<Booking> check(int id) {
        return bookingRespository.check(id);
    }

    @Override
    public Booking findTop() {
        return bookingRespository.findTop();
    }

    @Override
    public void save(int idBooking, int idService) {
        bookingServiceRespository.save(idBooking,idService);
    }

    @Override
    public Booking checkBookingExist(String dateHeld,int idWeddingHall, int idShift) {
        return bookingRespository.checkBookingExist(dateHeld,idWeddingHall,idShift);
    }

    @Override
    public List<BookService> getBookSer(){
        return  bookingServiceRespository.getBookSer();
    }

    @Override
    public List<Booking> findAll(){ return bookingRespository.findAll();}

    @Override
    public int delete(int id) {
        return bookingRespository.delete(id);
    }
}
