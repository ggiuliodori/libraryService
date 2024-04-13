package com.library.libraryService.controller;

import com.library.libraryService.model.BookDTO;
import com.library.libraryService.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping
    public Page<BookDTO> search(@RequestParam(required = false) String title,
                                @RequestParam(required = false) String genre,
                                Pageable pageable) {
        if (title != null) {
            return bookService.searchByTitle(title, pageable);
        } else if (genre != null) {
            return bookService.searchByGenre(genre, pageable);
        } else {
            return bookService.listBooks(pageable);
        }
    }

    @PostMapping
    public BookDTO saveBook(@RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}

