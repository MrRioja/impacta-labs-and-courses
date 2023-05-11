package com.bookstore.application.ports.output;

import com.bookstore.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookOutputPort {

    Book saveBook(Book book);

    Optional<Book> getBookId(Long id);

    List<Book> getAllBookRecords();

    void deleteBookById(Long id);
}
