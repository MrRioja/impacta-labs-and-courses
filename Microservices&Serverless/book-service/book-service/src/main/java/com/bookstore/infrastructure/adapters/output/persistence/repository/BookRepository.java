package com.bookstore.infrastructure.adapters.output.persistence.repository;

import com.bookstore.infrastructure.adapters.output.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
