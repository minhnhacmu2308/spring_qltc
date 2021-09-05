package com.qltc.springqltc.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "weddinghallshift")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeddingHallShift {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_weddinghall", referencedColumnName = "id")
    private WeddingHall weddingHall1;

    @ManyToOne
    @JoinColumn(name = "id_shìft", referencedColumnName = "id")
    private Shift shift;
}
