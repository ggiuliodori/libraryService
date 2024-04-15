package com.library.libraryService.model;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String nomenclature;
    private String title;
    private String author;
    private String editorial;
    private String publicationDate;
    private String genre;
    private String resume;
    private String condition;
    private String conditionDescription;
}

