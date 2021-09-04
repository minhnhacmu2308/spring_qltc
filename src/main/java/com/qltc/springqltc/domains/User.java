package com.qltc.springqltc.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String userName;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name = "image")
    private String image;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "enable")
    private int enable;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;
}
