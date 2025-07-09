package com.adrar.api.dto;

import java.sql.Date;

public record BookDTO(
        String title,
        Date createdAt,
        String authorName
) {
}
