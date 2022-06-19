package com.example.toyzee.dto;

import com.example.toyzee.model.Author;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BookDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private LocalDateTime publishedDate;
    private String description;
    private List<AuthorDTO> authors;
}
