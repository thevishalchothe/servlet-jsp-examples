package com.vbc.servlet.management.service;

import com.vbc.servlet.management.model.Book;
import com.vbc.servlet.management.dao.BookDAO;

import java.util.List;

public class BookService {
    private static final BookDAO BOOK_DAO = new BookDAO();

    public boolean addBook(Book book) {
        return BOOK_DAO.addBook(book);
    }

    public List<Book> getAllBooks() {
        return BOOK_DAO.getAllBooks();
    }

}
