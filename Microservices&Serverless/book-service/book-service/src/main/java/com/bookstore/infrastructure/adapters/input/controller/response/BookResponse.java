package com.bookstore.infrastructure.adapters.input.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookResponse {

    private Long bookId;
    private String name;
    private String isbn;
    private String summary;
    private int rating;
}
