package com.ccruz.demo_modulith.publishing.internal;

import org.springframework.data.repository.ListCrudRepository;

import com.ccruz.demo_modulith.publishing.Content;

public interface ContentRepository extends ListCrudRepository<Content, Long> {

}
