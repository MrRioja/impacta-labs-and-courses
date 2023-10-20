package com.bookstore.service;

import com.bookstore.application.ports.output.BookOutputPort;
import com.bookstore.domain.exception.NotFoundException;
import com.bookstore.domain.model.Book;
import com.bookstore.domain.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookOutputPort bookOutputPort;

    @InjectMocks
    private BookService service;

    private List<Book> books;

    @BeforeEach
    void setUp() {
        this.books = new ArrayList<>();
        var book1 = Book.builder()
                .bookId(1L)
                .name("Jornada Microsservicos")
                .isbn("9786588431580")
                .summary("Bla bla bla")
                .rating(5)
                .build();
        var book2 = Book.builder()
                .bookId(2L)
                .name("Jornada Java")
                .isbn("9786588431214")
                .summary("Bla bla bla")
                .rating(3)
                .build();
        books.addAll(List.of(book1, book2));
    }

    @Test
    @DisplayName("Unit Test to get Book by Id with success!!!")
    public void getBookById_withSucess() {
        //Arrange
        given(this.bookOutputPort.getBookId(1L)).willReturn(Optional.of(books.get(0)));

        //Act
        var book = service.getBookById(1L);

        //Assert
        Assertions.assertEquals(book.getName(), books.get(0).getName());
        Assertions.assertEquals(book, books.get(0));

    }

    @Test
    @DisplayName("Unit Test to get Book by Id not Found!!!")
    public void getBookById_NotFound() {
        //Arrange
        given(this.bookOutputPort.getBookId(any())).willReturn(Optional.empty());

        //Act & Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> this.service.getBookById(2L));
    }


    @Test
    @DisplayName("Unit Test to get All Book Records with success!!!")
    public void getAllBooksRecords_withSucess() {
        //Arrange
        given(this.bookOutputPort.getAllBookRecords()).willReturn(books);


        //Act
        var booksAllRecordProcessed = this.service.getAllBookRecords();

        //Assert
        Assertions.assertEquals(books.size(), 2L);
        Assertions.assertEquals(booksAllRecordProcessed.get(0).getName(), books.get(0).getName());
        Assertions.assertEquals(booksAllRecordProcessed.get(0), books.get(0));
    }

    @Test
    @DisplayName("Unit Test to get Delete Book By Id with success!!!")
    public void deleteBookById_withSucess() {
        //Arrange
        doNothing().when(this.bookOutputPort).deleteBookById(1L);

        //Act
        service.deleteBookById(1L);

        //Assert
        verify(this.bookOutputPort, times(1)).deleteBookById(1L);
    }

    @Test
    @DisplayName("Unit Test to get Create Book Record with success!!!")
    public void createBookRecord_withSuccess() {
        //Arrange
        given(this.bookOutputPort.saveBook(any())).willReturn(books.get(0));

        //Act
        var response = this.service.createBookRecord(books.get(0));

        //Assert
        verify(this.bookOutputPort, times(1)).saveBook(books.get(0));
        Assertions.assertEquals(books.get(0), response);
    }

    @Test
    @DisplayName("Unit Test to get Update Book Record with success!!!")
    public void updateBookRecord_withSuccess() {
        //Arrange
        given(this.bookOutputPort.saveBook(any())).willReturn(books.get(0));

        //Act
        var response = this.service.updateBookRecord(books.get(0));

        //Assert
        verify(this.bookOutputPort, times(1)).saveBook(books.get(0));
        Assertions.assertEquals(books.get(0), response);
    }
}
