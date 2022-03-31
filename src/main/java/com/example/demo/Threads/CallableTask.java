package com.example.demo.Threads;

import com.example.demo.Entity.BookEntity;
import com.example.demo.Repository.AuthorRepository;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

@Data
public class CallableTask implements Callable<List<BookEntity>> {

    AuthorRepository authorRepository;
    String authorName;
    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    public CallableTask(AuthorRepository authorRepository, String authorName){
        this.authorRepository = authorRepository;
        this.authorName = authorName;
    }

    @Override
    public List<BookEntity> call() throws Exception {
        List<BookEntity> bookList = new LinkedList<BookEntity>();
        bookList = authorRepository.getBooksOfAuthor(this.authorName);
        logger.info("The books of the author " + this.authorName +" are fetched using the thread "+ Thread.currentThread().getName());
        return bookList;
    }


}
