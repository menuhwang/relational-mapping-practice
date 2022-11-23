package com.likelion.relationalmappingpractice.service;

import com.likelion.relationalmappingpractice.domain.dto.BookResponse;
import com.likelion.relationalmappingpractice.domain.entity.Book;
import com.likelion.relationalmappingpractice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse get(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 책 없음"));
        return BookResponse.of(book);
    }

    public List<BookResponse> getAll() {
        return bookRepository.findAll().stream().map(BookResponse::of).collect(Collectors.toList());
    }
}
