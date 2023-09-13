package io.salmonllama.fashionscapeapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "permission")
public class Permission {
    private String userId;

    @Id
    @Column(name = "id")
    public String getUserId() {
        return userId;
    }

    public Permission setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @Column(name = "permission", nullable = false)
    public String getPermission() {
        return permission;
    }

    public Permission setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    @Column(name = "added", nullable = false)
    public Timestamp getAdded() {
        return added;
    }

    public Permission setAdded(Timestamp added) {
        this.added = added;
        return this;
    }

    private String permission;
    private Timestamp added;
}
