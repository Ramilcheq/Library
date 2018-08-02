package ru.bookmanager.controller;

import ru.bookmanager.model.Book;
import ru.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "/books/add/{page}", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book,
                          @PathVariable("page") int page,
                          Model model) {
        if (book.getId() == 0) {
            this.bookService.addBook(book);
        } else {
            this.bookService.updateBook(book);
        }

        return "redirect:/books?page=" + page;
    }

    @RequestMapping("/remove/{id}/{page}")
    public String removeBook(@PathVariable("id") int id,
                             @PathVariable("page") int page) {
        this.bookService.removeBook(id);

        return "redirect:/books?page=" + page;
    }

    @RequestMapping(value = "/read/{id}/{page}")
    public String readBook(@PathVariable("id") int id,
                           @PathVariable("page") int page) {
        this.bookService.readBook(id);

        return "redirect:/books?page=" + page;
    }

    @RequestMapping("update/{id}/{page}")
    public String editBook(@PathVariable("id") int id, Model model,
                           @PathVariable("page") int page) {
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks(id));

        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks1(@RequestParam(required = false) Integer page,
                             Model model) {
        model.addAttribute("book", new Book());

        PagedListHolder<Book> pagedBooks = new PagedListHolder<>(this.bookService.listBooks(0));
        pagedBooks.setPageSize(10);
        model.addAttribute("maxPages", pagedBooks.getPageCount());

        if (page == null || page < 1 || page > pagedBooks.getPageCount()) {
            page = 1;
            pagedBooks.setPage(0);
            model.addAttribute("listBooks", pagedBooks.getPageList());
        }

        if (page <= pagedBooks.getPageCount()) {
            pagedBooks.setPage(page - 1);
            model.addAttribute("listBooks", pagedBooks.getPageList());
        }

        model.addAttribute("page", page);

        return "books";
    }

    @RequestMapping(value = "search")
    public String search(@ModelAttribute("book") Book book, Model model,
                         @RequestParam(required = false) Integer page) {

        PagedListHolder<Book> pagedBooks = new PagedListHolder<>(this.bookService.listBooks(book));
        pagedBooks.setPageSize(10);
        model.addAttribute("maxPages", pagedBooks.getPageCount());

        if (page == null || page < 1 || page > pagedBooks.getPageCount()) {
            page = 1;
            pagedBooks.setPage(0);
            model.addAttribute("listBooks", pagedBooks.getPageList());
        }

        if (page <= pagedBooks.getPageCount()) {
            pagedBooks.setPage(page - 1);
            model.addAttribute("listBooks", pagedBooks.getPageList());
        }

        model.addAttribute("page", page);
        return "search";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String listBooks2(@RequestParam(required = false) Integer page,
                             Model model) {
        model.addAttribute("book", new Book());

        PagedListHolder<Book> pagedBooks = new PagedListHolder<>(this.bookService.listBooks(0));
        pagedBooks.setPageSize(10);
        model.addAttribute("maxPages", pagedBooks.getPageCount());

        if (page == null || page < 1 || page > pagedBooks.getPageCount()) {
            page = 1;
            pagedBooks.setPage(0);
            model.addAttribute("listBooks", pagedBooks.getPageList());
        }

        if (page <= pagedBooks.getPageCount()) {
            pagedBooks.setPage(page - 1);
            model.addAttribute("listBooks", pagedBooks.getPageList());
        }

        model.addAttribute("page", page);

        return "search";
    }
}
