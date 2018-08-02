package ru.bookmanager.dao;

import ru.bookmanager.model.Book;

import java.util.List;

public interface BookDao {
    public void addBook(Book book);

    public void readBook(int id);

    public void updateBook(Book book);

    public void removeBook(int id);

    public Book getBookById(int id);

    public List<Book> listBooks(int id);

    public List<Book> listBooks(Book book);
}
