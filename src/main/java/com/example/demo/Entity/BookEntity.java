package com.example.demo.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class BookEntity {
    @Id
    @NotNull
    int id;

    @NotEmpty
    @Size(min = 2, message = "Book name should be 2 characters in length")
    String bookName;

    @NotEmpty
    @Size(min = 2, message = "Book name should be 2 characters in length")
    String bookDescription;

    @NotNull
    int authorId;
}
