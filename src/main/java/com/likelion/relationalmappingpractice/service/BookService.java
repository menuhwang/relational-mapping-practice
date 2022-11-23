package com.likelion.relationalmappingpractice.service;

import com.likelion.relationalmappingpractice.domain.entity.Book;
import com.likelion.relationalmappingpractice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book get(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 책 없음"));
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
