package com.example.toyzee.service;

import com.example.toyzee.dto.AuthorDTO;
import com.example.toyzee.dto.BookDTO;
import com.example.toyzee.model.Author;
import com.example.toyzee.model.Book;
import com.example.toyzee.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorTabImpl implements AuthorTabService {
    private final AuthorRepository authorRepository;

//    @Override
//    public List<AuthorDTO> getAuthors() {
//        List<Author> authors = authorRepository.findAll();
//        List<AuthorDTO> collect = authors.stream()
//                .map(author -> {
//                    List<Book> booksForAuthor = author.getBooks().stream().toList();
//                    Set<BookDTO> booksDTO = booksForAuthor.stream().map(it -> bookTabService.getBookById(it.getId())).collect(Collectors.toSet());
//                    AuthorDTO authorDTO = AuthorDTO.builder()
//                            .id(author.getId())
//                            .firstName(author.getPerson().getFirstName())
//                            .lastName(author.getPerson().getLastName())
//                            .publishingHouses(author.getPublishingHouses())
//                            .books(booksDTO)
//                            .build();
//                    return authorDTO;
//                }).collect(Collectors.toList());
//        return collect;
//    }
//
    @Override
    public AuthorDTO getAuthorDTOByID(Long id) {
        Optional<Author> byId = authorRepository.findById(id);
        if (byId.isEmpty()) return null;
        Author author = byId.get();
        return AuthorDTO.builder()
                .id(author.getId())
                .firstName(author.getPerson().getFirstName())
                .lastName(author.getPerson().getLastName())
                .publishingHouses(author.getPublishingHouses())
                .build();
    }

//    @Override
//    public Optional<Author> getAuthorById(Long id) {
//        return authorRepository.findById(id);
//    }
}
