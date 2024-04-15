package com.library.libraryService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
