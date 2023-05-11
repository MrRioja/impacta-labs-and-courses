package com.bookstore.domain.service;

import com.bookstore.application.ports.input.BookCreatorUseCase;
import com.bookstore.application.ports.input.BookDeletionUseCase;
import com.bookstore.application.ports.input.BookRetrieverUserCase;
import com.bookstore.application.ports.input.BookUpdaterUseCase;
import com.bookstore.application.ports.output.BookOutputPort;
import com.bookstore.domain.exception.NotFoundException;
import com.bookstore.domain.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService implements BookCreatorUseCase, BookRetrieverUserCase, BookUpdaterUseCase, BookDeletionUseCase {

    @Autowired
    BookOutputPort bookOutputPort;

    @Override
    public Book createBookRecord(Book bookRecord) {
        return this.bookOutputPort.saveBook(bookRecord);
    }


    @Override
    public Book getBookById(Long bookId) {
        return this.bookOutputPort.getBookId(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found with id: "+ bookId));
    }

    @Override
    public List<Book> getAllBookRecords() {
        return this.bookOutputPort.getAllBookRecords();
    }


    @Override
    public void deleteBookById(Long bookId) {
        this.bookOutputPort.deleteBookById(bookId);
    }

    @Override
    public Book updateBookRecord(Book bookRecord) {
        return this.bookOutputPort.saveBook(bookRecord);
    }
}
