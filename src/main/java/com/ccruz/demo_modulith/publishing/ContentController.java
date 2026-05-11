package com.ccruz.demo_modulith.publishing;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/content")
public class ContentController {

    private final PublishingService publishing;
    record PublishRequest(String title, String url, ContentType type) {}

    public ContentController(PublishingService publishingService) {
        this.publishing = publishingService;
    }

    @GetMapping
    public ResponseEntity<List<Content>> all() {
        List<Content> contents = publishing.findAll();
        return ResponseEntity.ok(contents);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Content> byId(@PathVariable Long id) {
        return publishing.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Content> publish(@RequestBody PublishRequest request) {
        var content = publishing.publish(request.title(), request.url(), request.type());
        return ResponseEntity
            .created(URI.create("/api/content/" + content.id()))
            .body(content);
    }
}
