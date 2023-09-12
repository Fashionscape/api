package io.salmonllama.fashionscapeapi.controller;

import io.salmonllama.fashionscapeapi.exception.ResourceNotFoundException;
import io.salmonllama.fashionscapeapi.model.Gallery;
import io.salmonllama.fashionscapeapi.repository.GalleryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/gallery")
public class GalleryController {
    @Autowired
    private GalleryRepository galleryRepository;

    @GetMapping()
    public ResponseEntity<List<Gallery>> getAllGalleries() {
        List<Gallery> galleries = galleryRepository.findAll();

        return ResponseEntity.ok(galleries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable(value = "id") Long galleryId) throws ResourceNotFoundException {
        Gallery gallery = galleryRepository.findById(galleryId).orElseThrow(() -> new ResourceNotFoundException("Gallery not found for id :: " + galleryId));

        return ResponseEntity.ok().body(gallery);
    }

    @GetMapping("/server/{id}")
    public ResponseEntity<List<Gallery>> getGalleriesByServer(@PathVariable(value = "id") String serverId) {
        List<Gallery> galleries = galleryRepository.findAllByServer(serverId);

        return ResponseEntity.ok(galleries);
    }

    @GetMapping("/server/{serverId}/channel/{channelId}")
    public ResponseEntity<Gallery> getGalleryByServerAndChannel(@PathVariable(value = "serverId") String serverId, @PathVariable(value = "channelId") String channelId) throws ResourceNotFoundException {
        Gallery gallery = galleryRepository.findByServerAndChannel(serverId, channelId).orElseThrow(() -> new ResourceNotFoundException("Gallery not found for server :: " + serverId + " and channel :: " + channelId));

        return ResponseEntity.ok().body(gallery);
    }

    @PostMapping()
    public ResponseEntity<Gallery> createGallery(@Valid @RequestBody Gallery gallery) {
        Gallery createdGallery = galleryRepository.save(gallery);

        return ResponseEntity.ok(createdGallery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gallery> updateGallery(@PathVariable(value = "id") Long galleryId, @Valid @RequestBody Gallery galleryDetails) throws ResourceNotFoundException {
        Gallery gallery = galleryRepository.findById(galleryId).orElseThrow(() -> new ResourceNotFoundException("Gallery not found for id :: " + galleryId));

        gallery
                .setServerId(galleryDetails.getServerId())
                .setChannelId(galleryDetails.getChannelId())
                .setTag(galleryDetails.getTag())
                .setEmoji(galleryDetails.getEmoji())
                ;

        final Gallery updatedGallery = galleryRepository.save(gallery);

        return ResponseEntity.ok(updatedGallery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGallery(@PathVariable(value = "id") Long galleryId) throws ResourceNotFoundException {
        Gallery gallery = galleryRepository.findById(galleryId).orElseThrow(() -> new ResourceNotFoundException("Gallery not found for id :: " + galleryId));

        galleryRepository.delete(gallery);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
