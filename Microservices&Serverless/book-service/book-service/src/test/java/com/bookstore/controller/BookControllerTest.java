package com.bookstore.controller;

import com.bookstore.application.ports.input.BookCreatorUseCase;
import com.bookstore.application.ports.input.BookDeletionUseCase;
import com.bookstore.application.ports.input.BookRetrieverUserCase;
import com.bookstore.application.ports.input.BookUpdaterUseCase;
import com.bookstore.domain.model.Book;
import com.bookstore.infrastructure.adapters.input.controller.BookController;
import com.bookstore.infrastructure.adapters.input.controller.mapper.BookControllerMapper;
import com.bookstore.infrastructure.adapters.input.controller.request.BookRequest;
import com.bookstore.infrastructure.adapters.input.controller.response.BookResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private BookCreatorUseCase bookCreatorUseCase;

    @MockBean
    private BookRetrieverUserCase bookRetrieverUserCase;

    @MockBean
    private BookUpdaterUseCase bookUpdaterUseCase;

    @MockBean
    private BookDeletionUseCase bookDeletionUseCase;

    @MockBean
    private BookControllerMapper mapper;

    private List<BookResponse> bookResponses;

    private List<Book> books;

    public BookControllerTest() {
    }

    @BeforeEach
    void setUp() {
        this.bookResponses = new ArrayList<>();
        var bookResponse1 = BookResponse.builder()
                .bookId(1L)
                .name("Jornada Microsservicos")
                .isbn("9786588431580")
                .summary("Bla bla bla")
                .rating(5)
                .build();
        var bookResponse2 = BookResponse.builder()
                .bookId(2L)
                .name("Jornada Java")
                .isbn("9786588431214")
                .summary("Bla bla bla")
                .rating(3)
                .build();
        bookResponses.addAll(List.of(bookResponse1, bookResponse2));

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
    public void getAllBooksRecords_with_success() throws Exception {
        given(this.bookRetrieverUserCase.getAllBookRecords()).willReturn(books);
        given(this.mapper.map(anyList())).willReturn(bookResponses);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/book")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].name", is("Jornada Java")));
    }

    @Test
    public void getBookById_with_success() throws Exception {
        given(this.bookRetrieverUserCase.getBookById(bookResponses.get(0).getBookId()))
                .willReturn(books.get(0));
        given(this.mapper.toBookResponse(any())).willReturn(bookResponses.get(0));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/book/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Jornada Microsservicos")));
    }

    @Test
    public void createBookRecord() throws Exception {
        var bookRequest = BookRequest.builder()
                .name("Jornada Impacta")
                .isbn("9786588431581")
                .summary("Aula de Microservicos")
                .rating(5)
                .build();

        var content = this.objectMapper.writeValueAsString(bookRequest);

        var bookResponse = BookResponse.builder()
                .bookId(3L)
                .name(bookRequest.getName())
                .isbn(bookRequest.getIsbn())
                .summary(bookRequest.getSummary())
                .rating(bookRequest.getRating())
                .build();

        var book = Book.builder()
                .bookId(3L)
                .name(bookRequest.getName())
                .isbn(bookRequest.getIsbn())
                .summary(bookRequest.getSummary())
                .rating(bookRequest.getRating())
                .build();

        given(this.bookCreatorUseCase.createBookRecord(book)).willReturn(book);
        given(this.mapper.toBook(bookRequest)).willReturn(book);
        given(this.mapper.toBookResponse(book)).willReturn(bookResponse);

        var mockRequest = MockMvcRequestBuilders.post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        this.mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Jornada Impacta")));
    }


    @Test
    public void updateBookRecord_with_success() throws Exception {
        var bookRequest = BookRequest.builder()
                .name("Jornada Impacta")
                .isbn("9786588431581")
                .summary("Aula de Microservicos")
                .rating(5)
                .build();

        var bookResponse = BookResponse.builder()
                .bookId(1L)
                .name(bookRequest.getName())
                .isbn(bookRequest.getIsbn())
                .summary(bookRequest.getSummary())
                .rating(bookRequest.getRating())
                .build();

        var book = Book.builder()
                .bookId(3L)
                .name(bookRequest.getName())
                .isbn(bookRequest.getIsbn())
                .summary(bookRequest.getSummary())
                .rating(bookRequest.getRating())
                .build();

        given(this.mapper.toBook(bookRequest)).willReturn(book);
        given(this.mapper.toBookResponse(book)).willReturn(bookResponse);
        given(this.bookUpdaterUseCase.updateBookRecord(book))
                .willReturn(book);

        var contentRequest = this.objectMapper.writeValueAsString(bookRequest);

        var mockRequest = MockMvcRequestBuilders.put("/book/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(contentRequest);

        this.mockMvc.perform(mockRequest)
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Jornada Impacta")));
    }
}
