package com.example.demo.Repository;

import com.example.demo.Entity.AuthorEntity;
import com.example.demo.Entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>, QueryByExampleExecutor<BookEntity> {

}
