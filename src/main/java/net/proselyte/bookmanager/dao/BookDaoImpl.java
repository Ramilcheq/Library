package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully saved. Book details: " + book);
    }

    @Override
    public void readBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Book b set b.isRead = :paramRead where id = :paramName");
        query.setParameter("paramRead", true);
        query.setParameter("paramName", id);
        query.executeUpdate();
        logger.info("Book successfully readed. Book details: " + getBookById(id));
    }


    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Book b set b.isRead = :paramRead where id = :paramName");
        query.setParameter("paramRead", false);
        query.setParameter("paramName", book.getId());
        query.executeUpdate();
        session.update(book);
        logger.info("Book successfully update. Book details: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));

        if (book != null) {
            session.delete(book);
        }
        logger.info("Book successfully removed. Book details: " + book);
    }

    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query;
        if (id == 0) {
            query = session.createQuery("from Book");
        } else {
            query = session.createQuery("from Book where id =:paramID");
            query.setParameter("paramID", id);
        }
        List<Book> bookList = query.list();
        for (Book book : bookList) {
            logger.info("Book list: " + book);
        }

        return bookList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Book where bookTitle like :paramTitle" +
                " and bookDescription like:paramDesc" +
                " and bookAuthor like :paramAuthor" +
                " and isbn like :paramISBN" +
                " and (bookYear =:paramYear or 1=:param1)");
        if (book.getBookTitle().equals(""))
            query.setParameter("paramTitle", "%");
        else
            query.setParameter("paramTitle", book.getBookTitle());
        if (book.getBookDescription().equals(""))
            query.setParameter("paramDesc", "%");
        else
            query.setParameter("paramDesc", book.getBookDescription());
        if (book.getBookAuthor().equals(""))
            query.setParameter("paramAuthor", "%");
        else
            query.setParameter("paramAuthor", book.getBookAuthor());
        if (book.getIsbn().equals(""))
            query.setParameter("paramISBN", "%");
        else
            query.setParameter("paramISBN", book.getIsbn());
        if (book.getBookYear() == 0) {
            query.setParameter("paramYear", book.getBookYear());
            query.setParameter("param1", 1);
        } else {
            query.setParameter("paramYear", book.getBookYear());
            query.setParameter("param1", 0);
        }

        List<Book> bookList = query.list();
        for (Book book1 : bookList) {
            logger.info("Book list: " + book1);
        }

        return bookList;
    }
}
