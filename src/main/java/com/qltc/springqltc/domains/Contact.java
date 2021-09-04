package com.qltc.springqltc.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="fullname")
    private String fullName;

    @Column(name="email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private int status;

}
