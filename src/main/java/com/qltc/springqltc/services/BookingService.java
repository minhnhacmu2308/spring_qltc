package com.qltc.springqltc.services;

import com.qltc.springqltc.domains.BookService;
import com.qltc.springqltc.domains.Booking;

public interface BookingService {
    Booking save(Booking booking);

    Booking findTop();

    void save(int idBooking ,int idService );

    Booking checkBookingExist(String dateHeld, int idWeddingHall,  int idShift);
}
