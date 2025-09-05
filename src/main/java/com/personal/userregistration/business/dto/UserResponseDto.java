package com.personal.userregistration.business.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private LocalDate birthdate;
}