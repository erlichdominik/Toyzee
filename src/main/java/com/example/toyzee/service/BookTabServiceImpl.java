package com.example.toyzee.service;

import com.example.toyzee.dto.AuthorDTO;
import com.example.toyzee.dto.BookDTO;
import com.example.toyzee.model.Author;
import com.example.toyzee.model.Book;
import com.example.toyzee.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookTabServiceImpl implements BookTabService{
    private final BookRepository bookRepository;
    private final AuthorTabService authorTabService;
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }



    @Override
    public BookDTO getBookById(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isEmpty()) return null;
        Book book = byId.get();
        return BookDTO.builder()
                .id(book.getId())
                .description(book.getDescription())
                .price(book.getProduct().getPrice())
                .publishedDate(book.getProduct().getPublishedDate())
                .quantity(book.getProduct().getQuantity())
                .name(book.getProduct().getName())
                .build();
    }
    @Override
    public List<BookDTO> getBooksDTOS() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOS = books.stream()
                .map(book -> {
                    List<Author> authorsForSingleBook = book.getAuthors().stream().toList();
                    List<AuthorDTO> authorDTOS = authorsForSingleBook.stream().map(it -> authorTabService.getAuthorDTOByID(it.getId())).collect(Collectors.toList());
                    BookDTO bookDTO = BookDTO.builder()
                            .id(book.getId())
                            .name(book.getProduct().getName())
                            .publishedDate(book.getProduct().getPublishedDate())
                            .description(book.getDescription())
                            .quantity(book.getProduct().getQuantity())
                            .price(book.getProduct().getPrice())
                            .authors(authorDTOS)
                            .build();
                    return bookDTO;
                }).collect(Collectors.toList());
        return bookDTOS;
    }
}
