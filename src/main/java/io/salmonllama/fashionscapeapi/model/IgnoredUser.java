package io.salmonllama.fashionscapeapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "ignored_user")
public class IgnoredUser {
    private String id;
    private String reason;
    private Timestamp added;

    public IgnoredUser() {}

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }
    public IgnoredUser setId(String id) {
        this.id = id;
        return this;
    }

    @Column(name = "reason")
    public String getReason() {
        return reason;
    }
    public IgnoredUser setReason(String reason) {
        this.reason = reason;
        return this;
    }

    @Column(name = "added")
    public Timestamp getAdded() {
        return added;
    }
    public IgnoredUser setAdded(Timestamp added) {
        this.added = added;
        return this;
    }
}
