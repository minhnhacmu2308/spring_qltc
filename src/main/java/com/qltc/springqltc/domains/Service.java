package com.qltc.springqltc.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "cost")
    private int cost;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "service")
    private List<BookService> bookServices;
}
