package io.salmonllama.fashionscapeapi.repository;

import io.salmonllama.fashionscapeapi.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GalleryRepository extends JpaRepository<Gallery, UUID> {

    @Query(value = "SELECT g FROM gallery g WHERE g.server_id = ?1", nativeQuery = true)
    List<Gallery> findAllByServer(String serverId);

    @Query(value = "SELECT g FROM gallery g WHERE g.server_id = ?1 and g.channel_id = ?2", nativeQuery = true)
    Optional<Gallery> findByServerAndChannel(String serverId, String channelId);
}
