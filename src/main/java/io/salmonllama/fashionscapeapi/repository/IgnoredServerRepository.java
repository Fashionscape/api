package io.salmonllama.fashionscapeapi.repository;

import io.salmonllama.fashionscapeapi.model.IgnoredServer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IgnoredServerRepository extends JpaRepository<IgnoredServer, String> {
}
