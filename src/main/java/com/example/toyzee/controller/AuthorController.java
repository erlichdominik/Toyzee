package com.example.toyzee.controller;

import com.example.toyzee.dto.AuthorDTO;
import com.example.toyzee.model.Author;
import com.example.toyzee.service.AuthorTabService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthorController {
    private final AuthorTabService authorTabService;
//
//    @GetMapping("/authors")
//    public ResponseEntity<List<AuthorDTO>> getAuthors() {
//        return ResponseEntity.ok(authorTabService.getAuthors());
//    }

//    @GetMapping("/authors/{id}")
//    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
////        return ResponseEntity.of(authorTabService.getAuthorById(id));
//    }
}
