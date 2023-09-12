package io.salmonllama.fashionscapeapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.salmonllama.fashionscapeapi.exception.ResourceNotFoundException;
import io.salmonllama.fashionscapeapi.model.Outfit;
import io.salmonllama.fashionscapeapi.repository.OutfitRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class OutfitController {
    @Autowired
    private OutfitRepository outfitRepository;

    @GetMapping("/outfits")
    public List<Outfit> getAllOutfits() {
        return outfitRepository.findAll();
    }

    @GetMapping("/outfits/{id}")
    public ResponseEntity<Outfit> getOutfitById(@PathVariable(value = "id") String outfitId) throws ResourceNotFoundException {
        Outfit outfit = outfitRepository.findById(outfitId).orElseThrow(() -> new ResourceNotFoundException("Outfit not found for id :: " + outfitId));

        return ResponseEntity.ok().body(outfit);
    }

    @PostMapping("/outfits")
    public Outfit createOutfit(@Valid @RequestBody Outfit outfit) {
        return outfitRepository.save(outfit);
    }

    @PutMapping("/outfits/{id}")
    public ResponseEntity<Outfit> updateOutfit(@PathVariable(value = "id") String outfitId, @Valid @RequestBody Outfit outfitDetails) throws ResourceNotFoundException  {
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

    @DeleteMapping("/outfits/{id}")
    public Map<String, Boolean> deleteOutfit(@PathVariable(value = "id") String outfitId) throws ResourceNotFoundException {
        Outfit outfit = outfitRepository.findById(outfitId).orElseThrow(() -> new ResourceNotFoundException("Outfit not found for id :: " + outfitId));

        outfitRepository.delete(outfit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
