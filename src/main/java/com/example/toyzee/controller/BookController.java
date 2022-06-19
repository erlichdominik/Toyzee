package com.example.toyzee.controller;

import com.example.toyzee.dto.BookDTO;
import com.example.toyzee.service.BookTabService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BookController {
    private final BookTabService bookTabService;

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<BookDTO> booksDTOS = bookTabService.getBooksDTOS();
        model.addAttribute("books", booksDTOS);
        return "main";
    }

    @GetMapping("/books/{id}")
    public String getBookDetailsById(Model model, @PathVariable Long id) {
        BookDTO bookById = bookTabService.getBookWithAutorsById(id);
        model.addAttribute("book", bookById);
        return "bookview";
    }

}
