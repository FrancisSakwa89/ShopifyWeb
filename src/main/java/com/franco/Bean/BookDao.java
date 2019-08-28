package com.franco.Bean;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;

//import java.sql.SQLException;
public abstract class BookDao {

    // [START example]

    Long createBook(Book book) throws SQLException {
        return null;
    }

    abstract Book readBook(Long bookId) throws SQLException;

        abstract void updateBook(Book book) throws SQLException;

        abstract void deleteBook(Long bookId) throws SQLException;

        abstract ArrayList<Book> listBooks(String startCursor) throws SQLException;

    public abstract Long createBook(com.franco.models.Book book);
}

