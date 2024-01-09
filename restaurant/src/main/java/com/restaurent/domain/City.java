package com.restaurent.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City extends AbstractPersistable<Long> {
    @Id
    private long id;
    private String name;

    public Long getId() {
        return id;
    }
}
