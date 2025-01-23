package com.codergm.sdj;

import com.codergm.sdj.entity.Book;
import com.codergm.sdj.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void test_auditing(){
        Book book = new Book();
        book.setTitle("Core");
        book.setIsbn("001-CDJ");
        bookRepository.save(book);
        book.setTitle("Core, 2nd Edition");
        bookRepository.save(book);
        System.out.println(book);
    }
}
