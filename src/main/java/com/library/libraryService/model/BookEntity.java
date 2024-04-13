package com.library.libraryService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Data
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    private String genre;
    private String resume;
    private String condition;
    private String conditionDescription;

}
