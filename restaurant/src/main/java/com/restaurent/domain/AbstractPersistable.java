package com.restaurent.domain;

import jakarta.persistence.*;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractPersistable<ID extends Serializable> implements Persistable<ID> {

    @Column(name = "createdBy")
    private UUID createdBy;
    @Column(name = "createdDT")
    private Date createdDate;
    @Column(name = "updatedBy")
    private UUID lastModifiedBy;
    @Column(name = "updatedDT")
    private Date lastModifiedDate;

    public AbstractPersistable() {
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.getId() == null;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UUID getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(UUID lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @PrePersist
    private void onPrePersist() {
        //Set current user details
        Calendar calendar = new GregorianCalendar();
        this.setCreatedDate(calendar.getTime());
    }

    @PreUpdate
    private void onPreUpdate() {
        Calendar calendar = new GregorianCalendar();
        this.setLastModifiedDate(calendar.getTime());
    }
}
