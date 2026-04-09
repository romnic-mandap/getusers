package com.romnicmandap.getusers.enricheduser.dto;

import java.time.LocalDateTime;

public record EnrichedUserDTO(
        Long id,
        String name,
        String email,
        String department,
        LocalDateTime lastUpdated
) {
}
