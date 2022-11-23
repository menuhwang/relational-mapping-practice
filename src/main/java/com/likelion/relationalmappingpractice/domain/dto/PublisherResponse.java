package com.likelion.relationalmappingpractice.domain.dto;

import com.likelion.relationalmappingpractice.domain.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class PublisherResponse {
    private Integer id;
    private String name;
    private String address;

    public static PublisherResponse of(Publisher publisher) {
        return PublisherResponse.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .address(publisher.getAddress())
                .build();
    }
}
