package com.bookstore.infrastructure.adapters.output.persistence;

import com.bookstore.application.ports.output.BookOutputPort;
import com.bookstore.domain.model.Book;
import com.bookstore.infrastructure.adapters.output.persistence.entity.BookEntity;
import com.bookstore.infrastructure.adapters.output.persistence.mapper.BookPersistenceMapper;
import com.bookstore.infrastructure.adapters.output.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookPersistenceAdapter implements BookOutputPort {

    private final BookRepository repository;

    private final BookPersistenceMapper mapper;

    @Autowired
    public BookPersistenceAdapter(BookRepository repository, BookPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Book saveBook(Book book) {
        var bookEntity = this.mapper.toBookEntity(book);
        bookEntity = this.repository.save(bookEntity);
        return this.mapper.toBook(bookEntity);
    }

    @Override
    public Optional<Book> getBookId(Long id) {
        Optional<BookEntity> bookEntity = this.repository.findById(id);

        if (bookEntity.isEmpty()) {
            return Optional.empty();
        }

        var book = mapper.toBook(bookEntity.get());
        return Optional.of(book);
    }

    @Override
    public List<Book> getAllBookRecords() {
        var books = this.repository.findAll();
        return this.mapper.map(books);
    }

    @Override
    public void deleteBookById(Long id) {
        this.repository.deleteById(id);
    }
}
