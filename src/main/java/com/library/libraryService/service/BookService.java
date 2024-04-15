package com.library.libraryService.service;

import com.library.libraryService.model.BookEntity;
import com.library.libraryService.parser.BookParser;
import com.library.libraryService.repository.BookRepository;
import com.library.libraryService.model.BookDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    private BookParser bookParser;

    public Page<BookDTO> searchByTitle(String title, Pageable pageable) {
        Page<BookEntity> resultBookEntities = bookRepository.findByTitleContainingIgnoreCase(title, pageable);
        return resultBookEntities.map(bookParser::toBookDTO);
    }

    public Page<BookDTO> searchByGenre(String genre, Pageable pageable) {
        Page<BookEntity> resultBookEntities = bookRepository.findByGenreContainingIgnoreCase(genre, pageable);
        return resultBookEntities.map(bookParser::toBookDTO);
    }

    public Page<BookDTO> listBooks(Pageable pageable) {
        Page<BookEntity> resultBookEntities = bookRepository.findAll(pageable);
        return resultBookEntities.map(bookParser::toBookDTO);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        return bookParser.toBookDTO(bookRepository.save(bookParser.toBookEntity(bookDTO)));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        BookEntity existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with the provided ID"));

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setEditorial(bookDTO.getEditorial());
        existingBook.setPublicationDate(bookDTO.getPublicationDate());
        existingBook.setGenre(bookDTO.getGenre());
        existingBook.setResume(bookDTO.getResume());
        existingBook.setCondition(bookDTO.getCondition());
        existingBook.setConditionDescription(bookDTO.getConditionDescription());

        return bookParser.toBookDTO(bookRepository.save(existingBook));
    }
}
