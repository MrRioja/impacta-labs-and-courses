package com.bookstore.infrastructure.adapters.input.controller.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookRequest {

    @NotEmpty(message = "Name may not be empty")
    private String name;

    @NotEmpty(message = "ISBN may not be empty")
    private String isbn;

    @NotEmpty(message = "Summary may not be empty")
    private String summary;

    private int rating;
}
