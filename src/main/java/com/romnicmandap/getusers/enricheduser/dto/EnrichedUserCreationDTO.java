package com.romnicmandap.getusers.enricheduser.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnrichedUserCreationDTO(
        @NotBlank(message="name => must not be blank")
        @Size(max=255, message="name => must not exceed 255 characters")
        String name,

        @NotBlank(message="email => must not be blank")
        @Size(max=255, message="email => must not exceed 255 characters")
        @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "email  => must be valid")
        String email,

        @NotBlank(message="department => must not be blank")
        @Size(max=255, message="department => must not exceed 255 characters")
        String department
) {
}
