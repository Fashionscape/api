package io.salmonllama.fashionscapeapi.controller;

import io.salmonllama.fashionscapeapi.exception.ResourceNotFoundException;
import io.salmonllama.fashionscapeapi.model.IgnoredServer;
import io.salmonllama.fashionscapeapi.repository.IgnoredServerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ignoredserver")
public class IgnoredServerController {
    @Autowired
    private IgnoredServerRepository ignoredServerRepository;

    @GetMapping
    public ResponseEntity<List<IgnoredServer>> getIgnoredServers() {
        List<IgnoredServer> servers = ignoredServerRepository.findAll();

        return ResponseEntity.ok(servers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IgnoredServer> getIgnoredServerById(@PathVariable(value = "id") String serverId) throws ResourceNotFoundException {
        IgnoredServer server = ignoredServerRepository.findById(serverId).orElseThrow(() -> new ResourceNotFoundException("Ignored Server not found for id :: " + serverId));

        return ResponseEntity.ok(server);
    }

    @PostMapping()
    public ResponseEntity<IgnoredServer> createIgnoredServer(@Valid @RequestBody IgnoredServer server) {
        IgnoredServer createdServer = ignoredServerRepository.save(server);

        return ResponseEntity.ok(createdServer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IgnoredServer> updateIgnoredServer(@PathVariable(value = "id") String serverId, @Valid @RequestBody IgnoredServer serverDetails) throws ResourceNotFoundException {
        IgnoredServer server = ignoredServerRepository.findById(serverId).orElseThrow(() -> new ResourceNotFoundException("Ignored Server not found for id :: " + serverId));

        server
                .setName(serverDetails.getName())
                .setOwnerId(serverDetails.getOwnerId())
                .setReason(serverDetails.getReason())
                ;

        final IgnoredServer updatedServer = ignoredServerRepository.save(server);

        return ResponseEntity.ok(updatedServer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteIgnoredServer(@PathVariable(value = "id") String serverId) throws ResourceNotFoundException {
        IgnoredServer server = ignoredServerRepository.findById(serverId).orElseThrow(() -> new ResourceNotFoundException("Ignored Server not found for id :: " + serverId));

        ignoredServerRepository.delete(server);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
