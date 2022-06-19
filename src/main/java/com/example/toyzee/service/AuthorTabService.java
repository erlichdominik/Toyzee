package com.example.toyzee.service;

import com.example.toyzee.dto.AuthorDTO;
import com.example.toyzee.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorTabService {
//    List<AuthorDTO> getAuthors();
    AuthorDTO getAuthorDTOByID(Long id);
}
