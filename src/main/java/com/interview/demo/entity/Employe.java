package com.interview.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Autowired
    @Transient
    private Address address;

    @Transient
    private String COMPANY_NAME="TCS";
}
