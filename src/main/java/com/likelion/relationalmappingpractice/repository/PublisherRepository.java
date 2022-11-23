package com.likelion.relationalmappingpractice.repository;

import com.likelion.relationalmappingpractice.domain.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
