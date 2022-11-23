package com.likelion.relationalmappingpractice.controller;

import com.likelion.relationalmappingpractice.domain.entity.Book;
import com.likelion.relationalmappingpractice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(bookService.get(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }
}
