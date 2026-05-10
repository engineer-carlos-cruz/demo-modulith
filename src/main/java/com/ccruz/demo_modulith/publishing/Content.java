package com.ccruz.demo_modulith.publishing;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("content")
public record Content(
    @Id Long id,
    String title,
    String url,
    ContentType type,
    Instant publishedAt
) {

    public static Content draft(String title, String url, ContentType type) {
        return new Content(null, title, url, type, Instant.now());
    }
}
