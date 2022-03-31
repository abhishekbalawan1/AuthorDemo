package com.example.demo.Repository;

import com.example.demo.Entity.AuthorEntity;
import com.example.demo.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>, QueryByExampleExecutor<AuthorEntity> {

    @Query("SELECT book FROM AuthorEntity author JOIN author.books book WHERE author.name = :name")
    public List<BookEntity> getBooksOfAuthor(@Param("name") String authorName);
}
