package com.qltc.springqltc.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bookingservice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookService {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_booking", referencedColumnName = "id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "id_service", referencedColumnName = "id")
    private Service service;
}
