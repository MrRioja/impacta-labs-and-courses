package com.bookstore.infrastructure.adapters.output.persistence.mapper;

import com.bookstore.domain.model.Book;
import com.bookstore.infrastructure.adapters.output.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookPersistenceMapper {

    BookEntity toBookEntity(Book request);

    Book toBook(BookEntity entity);

    List<Book> map(List<BookEntity> bookEntities);
}
