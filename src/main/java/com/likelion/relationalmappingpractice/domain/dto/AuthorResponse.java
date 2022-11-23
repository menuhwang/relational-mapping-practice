package com.likelion.relationalmappingpractice.domain.dto;

import com.likelion.relationalmappingpractice.domain.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class AuthorResponse {
    private Integer id;
    private String name;

    public static AuthorResponse of(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }
}
