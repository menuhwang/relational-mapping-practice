package com.likelion.relationalmappingpractice.domain.dto;

import lombok.Getter;

@Getter
public class BookResponse {
    private Integer id;
    private String title;
    private AuthorResponse author;
}
