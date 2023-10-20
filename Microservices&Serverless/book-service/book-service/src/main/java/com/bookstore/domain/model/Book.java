package com.bookstore.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {

    private Long bookId;
    private String name;
    private String isbn;
    private String summary;
    private int rating;
}
