package com.jpa.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jpa_user_test")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "student")
    private String student;
}
