package com.ccruz.demo_modulith.notification.internal;

import org.springframework.stereotype.Service;

import com.ccruz.demo_modulith.publishing.internal.ContentRepository;

@Service
class DigestService {

    private final ContentRepository content;

    public DigestService(ContentRepository contentRepository) {
        this.content = contentRepository;
    }

    void sendDigest() {
        content.findAll().forEach(item -> System.out.println("Digest: " + item.title()));
    }
}
