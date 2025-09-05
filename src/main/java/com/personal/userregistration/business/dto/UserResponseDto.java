package com.personal.userregistration.business.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
import java.time.LocalDate;

@Getter
@Setter
public class UserResponseDto {

    private UUID id;
    private String name;
    private String email;
    private LocalDate birthdate;
}
