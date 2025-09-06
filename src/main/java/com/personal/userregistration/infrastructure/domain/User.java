package com.personal.userregistration.infrastructure.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="name", nullable = false)
    @Size(min=2, max=60)
    @NotBlank(message="Name is required.")
    private String name;

    @Column(name="email", unique=true, nullable=false)
    @Email(message="Please provide a valid email address.")
    @NotBlank(message="Email is required.")
    private String email;

    @Column(name="password", nullable=false)
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @Size(min=8, max=20, message="Password must contain at least 8 characters.")
    private String password;

    @Column(name="birthdate", nullable=false)
    @NotNull(message="Birth date is required.")
    @Past
    private LocalDate birthdate;

}
