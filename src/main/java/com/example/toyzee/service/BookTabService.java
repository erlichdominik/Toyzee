package com.example.toyzee.service;

import com.example.toyzee.dto.BookDTO;
import com.example.toyzee.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookTabService {
    List<Book> getBooks();
    BookDTO getBookById(Long id);
    List<BookDTO> getBooksDTOS();
}
