package com.qltc.springqltc.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dateheld")
    private String dateHeld;


    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "total")
    private String total;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "id_webdinghall",referencedColumnName = "id")
    private WeddingHall weddingHall;

    @ManyToOne
    @JoinColumn(name = "id_shift",referencedColumnName = "id")
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "id_menufood",referencedColumnName = "id")
    private MenuFood menuFood;


    @OneToMany(mappedBy = "booking")
    private List<BookService> bookServices;


}
