package com.bookstore.application.ports.input;

import com.bookstore.domain.model.Book;

import java.util.List;

public interface BookRetrieverUserCase {

    List<Book> getAllBookRecords();

    Book getBookById(Long bookId);

}
