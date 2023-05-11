package com.bookstore.application.ports.input;

import com.bookstore.domain.model.Book;

public interface BookCreatorUseCase {

    Book createBookRecord(Book bookRecord);
}
