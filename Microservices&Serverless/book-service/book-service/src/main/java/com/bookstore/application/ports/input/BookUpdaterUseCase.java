package com.bookstore.application.ports.input;

import com.bookstore.domain.model.Book;

public interface BookUpdaterUseCase {

    Book updateBookRecord(Book bookRecord);
}
