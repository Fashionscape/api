package io.salmonllama.fashionscapeapi.repository;

import io.salmonllama.fashionscapeapi.model.IgnoredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IgnoredUserRepository extends JpaRepository<IgnoredUser, String> {

}
