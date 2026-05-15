package com.ccruz.demo_modulith.publishing.internal;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccruz.demo_modulith.publishing.Content;
import com.ccruz.demo_modulith.publishing.ContentPublished;
import com.ccruz.demo_modulith.publishing.ContentType;

@Service
public class PublishingService {

    private final ContentRepository repository;
    private final ApplicationEventPublisher events;

    public PublishingService(ContentRepository contentRepository, ApplicationEventPublisher events) {
        this.repository = contentRepository;
        this.events = events;
    }

    @Transactional
    public Content publish(String title, String url, ContentType type) {
        var content = repository.save(Content.draft(title, url, type));
        events.publishEvent(new ContentPublished(content));
        return content;
    }

    public Optional<Content> findById(Long id) {
        return repository.findById(id);
    }

    public List<Content> findAll() {
        return repository.findAll();
    }
}
