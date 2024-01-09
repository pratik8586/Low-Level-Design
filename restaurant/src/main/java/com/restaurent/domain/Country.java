package com.restaurent.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Country extends AbstractPersistable<Long> {
    @Id
    private long id;
    private String name;
    @Column(name = "code")
    private String countryCode;

    public Long getId() {
        return id;
    }
}
