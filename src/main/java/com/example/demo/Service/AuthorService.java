package com.example.demo.Service;

import com.example.demo.Entity.AuthorEntity;
import com.example.demo.Entity.BookEntity;
import com.example.demo.Exception.CustomException;
import com.example.demo.Repository.AuthorRepository;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Threads.CallableTask;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

@Service
@Data
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    Logger logger = LoggerFactory.getLogger(AuthorService.class);


    public List<AuthorEntity> getAuthors(){
        List<AuthorEntity> authorList = new LinkedList<AuthorEntity>();
        authorRepository.findAll().forEach(authorList::add);
        if(authorList.size() == 0){
            throw new CustomException(HttpStatus.BAD_REQUEST, "There are no author records in the database");
        }
        return authorList;
    }

    public List<BookEntity> getBooks(){
        List<BookEntity> bookList = new LinkedList<BookEntity>();
        bookRepository.findAll().forEach(bookList::add);
        if(bookList.size() == 0){
            throw new CustomException(HttpStatus.BAD_REQUEST, "There are no book records in the database");
        }
        return bookList;
    }

    public List<BookEntity> getBooksOfAuthor(String authorName){
        return authorRepository.getBooksOfAuthor(authorName);
    }

    public void addAuthor(AuthorEntity author){
        authorRepository.save(author);
    }

    public void addBook(BookEntity book){
        bookRepository.save(book);
    }

    public List<BookEntity> getBooksByThreads() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<CallableTask> callabletasks = new LinkedList<CallableTask>();
        callabletasks.add(new CallableTask(authorRepository, "abhi"));
        callabletasks.add(new CallableTask(authorRepository, "bala"));
        List<Future<List<BookEntity>>> futureBookList = executor.invokeAll(callabletasks);

        List<BookEntity> bookList = new LinkedList<BookEntity>();
        for(Future<List<BookEntity>> future : futureBookList){
            for(BookEntity book : future.get()){
                bookList.add(book);
            }
        }

        return bookList;
    }
}
