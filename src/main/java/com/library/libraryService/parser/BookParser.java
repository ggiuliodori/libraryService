package com.library.libraryService.parser;

import com.library.libraryService.model.BookEntity;
import com.library.libraryService.model.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookParser {

    public BookDTO toBookDTO(BookEntity bookEntity) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(bookEntity.getId());
        bookDTO.setTitle(bookEntity.getTitle());
        bookDTO.setAuthor(bookEntity.getAuthor());
        bookDTO.setGenre(bookEntity.getGenre());
        bookDTO.setCondition(bookEntity.getCondition());
        bookDTO.setConditionDescription(bookEntity.getConditionDescription());

        return bookDTO;
    }

    public BookEntity toBookEntity(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDTO.getId());
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setGenre(bookDTO.getGenre());
        bookEntity.setCondition(bookDTO.getCondition());
        bookEntity.setConditionDescription(bookDTO.getConditionDescription());

        return bookEntity;
    }
}
