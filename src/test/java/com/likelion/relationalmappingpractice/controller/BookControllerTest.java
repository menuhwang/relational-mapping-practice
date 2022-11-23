package com.likelion.relationalmappingpractice.controller;

import com.likelion.relationalmappingpractice.domain.entity.Author;
import com.likelion.relationalmappingpractice.domain.entity.Book;
import com.likelion.relationalmappingpractice.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;

    @Test
    void get(String s) throws Exception {
        final Integer ID = 1;
        final String TITLE = "Do It! 자바 프로그래밍 입문";
        final Integer AUTHOR_ID = 1;
        final String AUTHOR_NAME = "박은종";
        final Author AUTHOR = Author.builder()
                .id(AUTHOR_ID)
                .name(AUTHOR_NAME)
                .build();

        Book book = Book.builder()
                .id(ID)
                .title(TITLE)
                .author(AUTHOR)
                .build();

        given(bookService.get(1)).willReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/" + ID))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(ID))
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value(TITLE))
                .andExpect(jsonPath("$.author").exists())
                .andExpect(jsonPath("$.author.id").exists())
                .andExpect(jsonPath("$.author.id").value(AUTHOR_ID))
                .andExpect(jsonPath("$.author.name").exists())
                .andExpect(jsonPath("$.author.name").value(AUTHOR_NAME))
                .andDo(print());
        verify(bookService).get(ID);
    }
}