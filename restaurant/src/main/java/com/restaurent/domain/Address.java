package com.restaurent.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Address extends AbstractPersistable<UUID> {

    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.VARCHAR)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne
    @NonNull
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;
    @Column
    @NonNull
    private String addressLine1;
    @Column
    private String addressLine2;
    @Column
    private String street;
    @Column
    private String landmark;
    @ManyToOne
    @JoinColumn(name = "CityId", nullable = false)
    private City city;
    @ManyToOne
    @JoinColumn(name = "StateId", nullable = false)
    private State state;
    @ManyToOne
    @JoinColumn(name = "CountryId", nullable = false)
    private Country country;
}
