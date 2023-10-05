package com.emma.bookyApp.controller;

import com.emma.bookyApp.model.Book;
import com.emma.bookyApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")

public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index"; // Return the name of your home page template
    }



    @GetMapping("/list")
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        //model.addAttribute("books", bookService.getAllBooks());
        return "list";
    }
    //Added
    @GetMapping("/details/{id}")
    public String viewBookDetails(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "details";
    }


    @GetMapping("/add")
    public String addBook(Model model){
        //create book object to hold book catalog data
        Book book=new Book();
        model.addAttribute("book",book);
        return "add-book";
    }
    @PostMapping("/bookSave")
    public String saveBook(@ModelAttribute("book") Book book) {
        //binding to the book Entity
        bookService.saveBook(book);
        return "redirect:/books/list";
    }//redirect to books method handler above
    // Display a form to edit an existing book
    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id")Long id, Model model){
        Book book=bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }
    // Update an existing book
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/books/list";
    }
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books/list";
    }







}
