package com.library.libraryService.repository;

import com.library.libraryService.model.BookEntity;
import com.library.libraryService.model.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    Page<MemberEntity> findByLastnameContainingIgnoreCase(String lastname, Pageable pageable);

    Page<MemberEntity> findByDniContainingIgnoreCase(String dni, Pageable pageable);
}
