package com.example.demo.Controller;

import com.example.demo.Entity.AuthorEntity;
import com.example.demo.Entity.BookEntity;
import com.example.demo.Service.AuthorService;
import com.example.demo.Threads.CallableTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.*;

@RestController
public class AuthorController {

    Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public List<AuthorEntity> getAuthors(){
        logger.debug("Getting list of authors...");
        List<AuthorEntity> listAuthors = authorService.getAuthors();
        logger.debug("Getting list of authors completed");
        return listAuthors;
    }

    @GetMapping("/books")
    public List<BookEntity> getBooks(){
        logger.debug("Getting list of books...");
        List<BookEntity> listBooks =  authorService.getBooks();
        logger.debug("Getting list of books completed");
        return listBooks;
    }

    @GetMapping("/books/{authorName}")
    public List<BookEntity> getBooksOfAuthor(@PathVariable String authorName){
        logger.debug("Getting list of books...");
        List<BookEntity> listBooks =  authorService.getBooksOfAuthor(authorName);
        logger.debug("Getting list of books completed");
        return listBooks;
    }

    @PostMapping("/authors")
    public void createAuthor(@RequestBody AuthorEntity authorEntity){
        logger.debug("Creating author...");
        authorService.addAuthor(authorEntity);
        logger.debug("Author created successfully");
    }

    @PostMapping("/books")
    public void createBook(@RequestBody BookEntity bookEntity){
        logger.debug("Creating book...");
        authorService.addBook(bookEntity);
        logger.debug("Book created successfully");
    }

    @GetMapping("/booksByThreads")
    public List<BookEntity> getBooksByThreads() throws ExecutionException, InterruptedException {
        return authorService.getBooksByThreads();
    }

}
