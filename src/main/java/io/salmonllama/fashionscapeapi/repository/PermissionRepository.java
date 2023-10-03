package io.salmonllama.fashionscapeapi.repository;

import io.salmonllama.fashionscapeapi.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, String> {
    @Query(value = "SELECT p FROM permission p WHERE p.permission = ?1", nativeQuery = true)
    List<Permission> findByPermissionType(String permission);
}
