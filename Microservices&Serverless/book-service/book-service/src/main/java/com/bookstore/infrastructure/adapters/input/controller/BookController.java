package com.bookstore.infrastructure.adapters.input.controller;


import com.bookstore.application.ports.input.BookCreatorUseCase;
import com.bookstore.application.ports.input.BookDeletionUseCase;
import com.bookstore.application.ports.input.BookRetrieverUserCase;
import com.bookstore.application.ports.input.BookUpdaterUseCase;
import com.bookstore.infrastructure.adapters.input.controller.mapper.BookControllerMapper;
import com.bookstore.infrastructure.adapters.input.controller.request.BookRequest;
import com.bookstore.infrastructure.adapters.input.controller.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {

    private final BookCreatorUseCase bookCreatorUseCase;

    private final BookRetrieverUserCase bookRetrieverUserCase;

    private final BookUpdaterUseCase bookUpdaterUseCase;

    private final BookDeletionUseCase bookDeletionUseCase;

    private final BookControllerMapper mapper;

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooksRecords() {
        var books = this.bookRetrieverUserCase.getAllBookRecords();
        return new ResponseEntity<>(this.mapper.map(books), HttpStatus.OK);
    }

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable(value = "bookId") Long bookId) {

        var book = this.bookRetrieverUserCase.getBookById(bookId);
        return new ResponseEntity<>(this.mapper.toBookResponse(book), HttpStatus.OK);
    }


    @PutMapping(value = "/{bookId}")
    public ResponseEntity<BookResponse> updateBookRecord(@PathVariable(value = "bookId") Long bookId,
                                                         @RequestBody BookRequest bookRequest) {
        var book = this.mapper.toBook(bookRequest);
        book.setBookId(bookId);
        book = this.bookUpdaterUseCase.updateBookRecord(book);
        return new ResponseEntity<>(this.mapper.toBookResponse(book), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<Void> deleteBookById(@PathVariable(value = "bookId") Long bookId) {
        this.bookDeletionUseCase.deleteBookById(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBookRecord(@RequestBody @Valid BookRequest bookRequest){
        var book = this.mapper.toBook(bookRequest);
        book = this.bookCreatorUseCase.createBookRecord(book);
        return new ResponseEntity<>(this.mapper.toBookResponse(book), HttpStatus.CREATED);
    }


}
