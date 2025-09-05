package com.personal.userregistration.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRegistrationDto {

    @Size(min = 2, max = 60)
    @NotBlank(message="Name is required.")
    private String name;

    @Email(message = "Please provide a valid email address.")
    @NotBlank(message = "Email is required.")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, max = 20, message = "Password must contain at least 8 characters.")
    private String password;

    @NotBlank(message="Birth date is required.")
    @Past
    private LocalDate birthdate;
}
