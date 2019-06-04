package com.mkdk.app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Autor implements Serializable {
    private static final long serialVersionUID = 5102537551841098262L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "autor_book",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;

}
