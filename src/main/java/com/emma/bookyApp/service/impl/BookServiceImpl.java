package com.emma.bookyApp.service.impl;

import com.emma.bookyApp.model.Book;
import com.emma.bookyApp.repo.BookRepo;
import com.emma.bookyApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);

    }

    @Override
    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);

    }
}
