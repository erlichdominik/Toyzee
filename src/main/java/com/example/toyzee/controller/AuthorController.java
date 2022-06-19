package com.example.toyzee.controller;

import com.example.toyzee.dto.AuthorDTO;
import com.example.toyzee.dto.BookDTO;
import com.example.toyzee.model.Author;
import com.example.toyzee.repository.AuthorRepository;
import com.example.toyzee.service.BookTabService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final BookTabService bookTabService;
    private final AuthorRepository authorRepository;
//
//    @GetMapping("/authors")
//    public ResponseEntity<List<AuthorDTO>> getAuthors() {
//        return ResponseEntity.ok(authorTabService.getAuthors());
//    }

    @GetMapping("/authors/{id}")
    public String getAuthorById(Model model, @PathVariable Long id) {
        List<BookDTO> booksDTOS = bookTabService.getBooksDTOS();
        Optional<Author> byId = authorRepository.findById(id);
        if (byId.isEmpty()) return "error";
        Author author = byId.get();
        AuthorDTO authorDTO = AuthorDTO.convertFromAuthor(author);
        model.addAttribute("author", authorDTO);
        model.addAttribute("books", author.getBooks());
        return "authorview";


    }
}
