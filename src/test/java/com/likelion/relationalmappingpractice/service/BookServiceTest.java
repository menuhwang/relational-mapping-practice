package com.likelion.relationalmappingpractice.service;

import com.likelion.relationalmappingpractice.domain.entity.Author;
import com.likelion.relationalmappingpractice.domain.entity.Book;
import com.likelion.relationalmappingpractice.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class BookServiceTest {
    private final BookRepository bookRepository = Mockito.mock(BookRepository.class);
    private final BookService bookService = new BookService(bookRepository);
    @Test
    void get() {
        final Integer ID = 1;
        final String TITLE = "Do It! 자바 프로그래밍 입문";
        final String AUTHOR_NAME = "박은종";
        final Author AUTHOR = Author.builder()
                .id(1)
                .name(AUTHOR_NAME)
                .build();

        Book book = Book.builder()
                .id(ID)
                .title(TITLE)
                .author(AUTHOR)
                .build();

        given(bookRepository.findById(ID)).willReturn(Optional.of(book));

        Book result = bookService.get(ID);

        assertBoot(book, result);
    }

    void assertBoot(Book expected, Book actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getAuthor(), actual.getAuthor());
    }
}