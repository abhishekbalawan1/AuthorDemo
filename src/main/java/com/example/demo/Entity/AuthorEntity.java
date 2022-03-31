package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
public class AuthorEntity {
    @Id
    @NotNull
    int id;

    @NotEmpty
    @Size(min = 2, message = "Name should be 2 characters in length")
    String name;

    @NotEmpty
    @Size(min = 2, message = "Address should be 2 characters in length")
    String address;

    @NotNull
    int age;

    @OneToMany
    @JoinColumn(name = "authorId")
    List<BookEntity> books;
}
