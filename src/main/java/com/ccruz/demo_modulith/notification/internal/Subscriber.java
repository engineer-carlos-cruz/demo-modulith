package com.ccruz.demo_modulith.notification.internal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("subscriber")
public record Subscriber(
    @Id Long id,
    String email
) {

}
