package com.codergm.sdj.repository;

import com.codergm.sdj.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
