package io.salmonllama.fashionscapeapi.controller;

import io.salmonllama.fashionscapeapi.exception.ResourceNotFoundException;
import io.salmonllama.fashionscapeapi.model.IgnoredUser;
import io.salmonllama.fashionscapeapi.repository.IgnoredUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ignoreduser")
public class IgnoredUserController {
    @Autowired
    private IgnoredUserRepository ignoredUserRepository;

    @GetMapping()
    public ResponseEntity<List<IgnoredUser>> getIgnoredUsers() {
        List<IgnoredUser> users = ignoredUserRepository.findAll();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IgnoredUser> getIgnoredUserById(@PathVariable(value = "id") String userId) throws ResourceNotFoundException {
        IgnoredUser user = ignoredUserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Ignored User not found for id :: " + userId));

        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<IgnoredUser> createIgnoredUser(@Valid @RequestBody IgnoredUser user) {
        IgnoredUser createdUser = ignoredUserRepository.save(user);

        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IgnoredUser> updateIgnoredGallery(@PathVariable(value = "id") String userId, @Valid @RequestBody IgnoredUser userDetails) throws ResourceNotFoundException {
        IgnoredUser user = ignoredUserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Ignored User not found for id :: " + userId));

        user
                .setReason(userDetails.getReason())
                ;

        final IgnoredUser updatedUser = ignoredUserRepository.save(user);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteIgnoredUser(@PathVariable(value = "id") String userId) throws ResourceNotFoundException {
        IgnoredUser user = ignoredUserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Ignored User not found for id :: " + userId));

        ignoredUserRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
