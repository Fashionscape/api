package io.salmonllama.fashionscapeapi.repository;

import io.salmonllama.fashionscapeapi.model.ContestGallery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContestGalleryRepository extends JpaRepository<ContestGallery, UUID> {
}
