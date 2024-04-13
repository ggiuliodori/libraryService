package com.library.libraryService.service;

import com.library.libraryService.model.BookEntity;
import com.library.libraryService.parser.BookParser;
import com.library.libraryService.repository.BookRepository;
import com.library.libraryService.model.BookDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    private BookParser bookParser;

    public List<BookDTO> searchByTitle(String title) {
        List<BookEntity> resultBookEntities = bookRepository.findByTitleContainingIgnoreCase(title);
        List<BookDTO> resultBooksDTO = new ArrayList<>();
        resultBookEntities.forEach(bookEntity -> resultBooksDTO.add(bookParser.toBookDTO(bookEntity)));
        return resultBooksDTO;
    }

    public List<BookDTO> searchByGenre(String genre) {
        List<BookEntity> resultBookEntities = bookRepository.findByGenreContainingIgnoreCase(genre);
        List<BookDTO> resultBooksDTO = new ArrayList<>();
        resultBookEntities.forEach(bookEntity -> resultBooksDTO.add(bookParser.toBookDTO(bookEntity)));
        return resultBooksDTO;
    }

    public List<BookDTO> listBooks() {
        List<BookEntity> resultBookEntities = bookRepository.findAll();
        List<BookDTO> resultBooksDTO = new ArrayList<>();
        resultBookEntities.forEach(bookEntity -> resultBooksDTO.add(bookParser.toBookDTO(bookEntity)));
        return resultBooksDTO;
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
        existingBook.setGenre(bookDTO.getGenre());
        existingBook.setCondition(bookDTO.getCondition());
        existingBook.setConditionDescription(bookDTO.getConditionDescription());

        return bookParser.toBookDTO(bookRepository.save(existingBook));
    }
}
