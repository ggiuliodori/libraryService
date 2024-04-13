package com.library.libraryService.model;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private String condition;
    private String conditionDescription;
}

