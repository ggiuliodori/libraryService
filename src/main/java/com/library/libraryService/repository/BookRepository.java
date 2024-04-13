package com.library.libraryService.repository;

import com.library.libraryService.model.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// ...

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Page<BookEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<BookEntity> findByGenreContainingIgnoreCase(String genre, Pageable pageable);
}
