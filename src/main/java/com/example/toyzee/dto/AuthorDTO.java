package com.example.toyzee.dto;

import com.example.toyzee.model.Author;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<String> publishingHouses;


    public static AuthorDTO convertFromAuthor(Author author) {
        return AuthorDTO.builder()
                .id(author.getId())
                .lastName(author.getPerson().getLastName())
                .firstName(author.getPerson().getFirstName())
                .publishingHouses(author.getPublishingHouses())
                .build();
    }

    public static List<AuthorDTO> convertFromAuthorsSet(Set<Author> authors) {
        return authors.stream().map(AuthorDTO::convertFromAuthor).collect(Collectors.toList());
    }
}
