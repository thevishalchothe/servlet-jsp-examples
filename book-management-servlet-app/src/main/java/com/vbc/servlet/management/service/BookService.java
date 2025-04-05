package com.vbc.servlet.management.service;

import com.vbc.servlet.management.model.Book;
import com.vbc.servlet.management.repository.BookRepository;

import java.util.List;

public class BookService {
    private static final BookRepository bookRepository = new BookRepository();

    public boolean addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public boolean deleteBook(int bookId) {
        return bookRepository.deleteBook(bookId);
    }

    public Book getBookById(int bookId) {
        return bookRepository.getBookById(bookId);
    }

    public boolean updateBook(Book book) {
        try {
            return bookRepository.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
