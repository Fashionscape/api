package io.salmonllama.fashionscapeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.salmonllama.fashionscapeapi.model.Outfit;

@Repository
public interface OutfitRepository extends JpaRepository<Outfit, String> {
    @Query(value = "SELECT o FROM outfit o ORDER BY random() LIMIT 1", nativeQuery = true)
    Outfit findRandomOutfit();

    @Query(value = "SELECT o FROM outfit o WHERE o.submitter = ?1", nativeQuery = true)
    List<Outfit> findUsersOutfits(String userId);
}
