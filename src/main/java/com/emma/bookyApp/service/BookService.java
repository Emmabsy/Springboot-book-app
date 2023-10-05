package com.emma.bookyApp.service;

import com.emma.bookyApp.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);

}
