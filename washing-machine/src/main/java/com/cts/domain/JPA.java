package com.cts.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class JPA {

    private Long id;
    private Date version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "version")
    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        Long id = getId();
        return (id == null ? super.hashCode() : id.intValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().isInstance(obj)) {
            return false;
        }
        if (hashCode() != obj.hashCode()) {
            return false;
        }
        Long id = getId();
        Long oid = ((JPA) obj).getId();
        return id != null && oid != null && id.equals(oid);
    }
}
