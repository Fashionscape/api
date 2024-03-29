package io.salmonllama.fashionscapeapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.salmonllama.fashionscapeapi.exception.ResourceNotFoundException;
import io.salmonllama.fashionscapeapi.model.Outfit;
import io.salmonllama.fashionscapeapi.repository.OutfitRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/outfit")
public class OutfitController {
    @Autowired
    private OutfitRepository outfitRepository;

    @GetMapping()
    public ResponseEntity<List<Outfit>> getAllOutfits() {
        List<Outfit> outfits = outfitRepository.findAll();

        return ResponseEntity.ok(outfits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Outfit> getOutfitById(@PathVariable(value = "id") UUID outfitId) throws ResourceNotFoundException {
        Outfit outfit = outfitRepository.findById(outfitId).orElseThrow(() -> new ResourceNotFoundException("Outfit not found for id :: " + outfitId));

        return ResponseEntity.ok().body(outfit);
    }

    @GetMapping("/random")
    public ResponseEntity<Outfit> getRandomOutfit() {
        Outfit outfit = outfitRepository.findRandomOutfit();

        return ResponseEntity.ok(outfit);
    }

    @PostMapping()
    public ResponseEntity<Outfit> createOutfit(@Valid @RequestBody Outfit newOutfit) {
        Outfit outfit = outfitRepository.save(newOutfit);

        return ResponseEntity.ok(outfit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Outfit> updateOutfit(@PathVariable(value = "id") UUID outfitId, @Valid @RequestBody Outfit outfitDetails) throws ResourceNotFoundException  {
        Outfit outfit = outfitRepository.findById(outfitId).orElseThrow(() -> new ResourceNotFoundException("Outfit not found for id :: " + outfitId));

        outfit
                .setLink(outfitDetails.getLink())
                .setSubmitter(outfitDetails.getSubmitter())
                .setTag(outfitDetails.getTag())
                .setMeta(outfitDetails.getMeta())
                .setDiscordName(outfitDetails.getDiscordName())
                .setUpdated(outfitDetails.getUpdated())
                .setDeleted(outfitDetails.getDeleted())
                .setFeatured(outfitDetails.getFeatured())
                .setDisplayCount(outfitDetails.getDisplayCount())
                .setDeleteHash(outfitDetails.getDeleteHash())
        ;

        final Outfit updatedOutfit = outfitRepository.save(outfit);

        return ResponseEntity.ok(updatedOutfit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOutfit(@PathVariable(value = "id") UUID outfitId) throws ResourceNotFoundException {
        Outfit outfit = outfitRepository.findById(outfitId).orElseThrow(() -> new ResourceNotFoundException("Outfit not found for id :: " + outfitId));

        outfitRepository.delete(outfit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
