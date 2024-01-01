package com.restaurent.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private boolean isActive;
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private Set<Address> addresses = new HashSet<>();
}