package com.bookstore.infrastructure.adapters.input.controller.mapper;

import com.bookstore.domain.model.Book;
import com.bookstore.infrastructure.adapters.input.controller.request.BookRequest;
import com.bookstore.infrastructure.adapters.input.controller.response.BookResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookControllerMapper {

    Book toBook(BookRequest bookRequest);

    BookResponse toBookResponse(Book book);

    List<BookResponse> map(List<Book> book);
}
