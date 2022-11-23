package com.likelion.relationalmappingpractice.domain.dto;

import com.likelion.relationalmappingpractice.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class BookResponse {
    private Integer id;
    private String title;
    private AuthorResponse author;

    public static BookResponse of(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(AuthorResponse.of(book.getAuthor()))
                .build();
    }
}
