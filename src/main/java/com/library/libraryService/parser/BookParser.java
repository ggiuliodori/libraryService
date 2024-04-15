package com.library.libraryService.parser;

import com.library.libraryService.model.BookEntity;
import com.library.libraryService.model.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookParser {

    public BookDTO toBookDTO(BookEntity bookEntity) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(bookEntity.getId());
        bookDTO.setNomenclature(bookEntity.getNomenclature());
        bookDTO.setTitle(bookEntity.getTitle());
        bookDTO.setAuthor(bookEntity.getAuthor());
        bookDTO.setEditorial(bookEntity.getEditorial());
        bookDTO.setPublicationDate(bookEntity.getPublicationDate());
        bookDTO.setGenre(bookEntity.getGenre());
        bookDTO.setResume(bookEntity.getResume());
        bookDTO.setCondition(bookEntity.getCondition());
        bookDTO.setConditionDescription(bookEntity.getConditionDescription());

        return bookDTO;
    }

    public BookEntity toBookEntity(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDTO.getId());
        bookEntity.setNomenclature(bookDTO.getNomenclature());
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setEditorial(bookDTO.getEditorial());
        bookEntity.setPublicationDate(bookDTO.getPublicationDate());
        bookEntity.setGenre(bookDTO.getGenre());
        bookEntity.setResume(bookDTO.getResume());
        bookEntity.setCondition(bookDTO.getCondition());
        bookEntity.setConditionDescription(bookDTO.getConditionDescription());

        return bookEntity;
    }
}
