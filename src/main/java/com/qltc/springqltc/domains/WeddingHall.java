package com.qltc.springqltc.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "weddinghall")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeddingHall {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "weddingHall")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "weddingHall1")
    private List<WeddingHallShift> weddingHallShifts;
}
