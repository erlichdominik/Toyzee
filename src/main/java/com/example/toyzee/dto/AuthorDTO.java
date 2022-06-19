package com.example.toyzee.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<String> publishingHouses;
}
