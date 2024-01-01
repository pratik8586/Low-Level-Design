package com.restaurent.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @NonNull
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;
    @Column
    @NonNull
    private String name;
    @Column
    @NonNull
    private String city;
    @Column
    @NonNull
    private String state;
}
