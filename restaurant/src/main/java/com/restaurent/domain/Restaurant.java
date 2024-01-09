package com.restaurent.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Restaurant extends AbstractPersistable<UUID> {

    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.VARCHAR)
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;
    @Column
    private String name;
    @Column
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId")
    private Set<Address> addresses = new HashSet<>();

    public UUID getId() {
        return id;
    }
}
