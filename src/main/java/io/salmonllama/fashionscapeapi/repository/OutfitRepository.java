package io.salmonllama.fashionscapeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.salmonllama.fashionscapeapi.model.Outfit;

@Repository
public interface OutfitRepository extends JpaRepository<Outfit, String> {
    
}
