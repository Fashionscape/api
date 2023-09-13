package io.salmonllama.fashionscapeapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "ignored_server")
public class IgnoredServer {
    private String id;
    private String name;
    private String ownerId;
    private String reason;
    private Timestamp added;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public IgnoredServer setId(String id) {
        this.id = id;
        return this;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public IgnoredServer setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "owner_id", nullable = false)
    public String getOwnerId() {
        return ownerId;
    }

    public IgnoredServer setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    @Column(name = "reason", nullable = false)
    public String getReason() {
        return reason;
    }

    public IgnoredServer setReason(String reason) {
        this.reason = reason;
        return this;
    }

    @Column(name = "added", nullable = false)
    public Timestamp getAdded() {
        return added;
    }

    public IgnoredServer setAdded(Timestamp added) {
        this.added = added;
        return this;
    }
}
