package com.mkdk.app.controller;

import com.mkdk.app.model.Autor;
import com.mkdk.app.model.Book;
import com.mkdk.app.repository.AutorRepository;
import com.mkdk.app.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AppController implements Serializable {

    private static final long serialVersionUID = -3868927676297188670L;

    private BookRepository bookRepository;
    private AutorRepository autorRepository;

    public AppController(BookRepository bookRepository, AutorRepository autorRepository) {
        this.bookRepository = bookRepository;
        this.autorRepository = autorRepository;
    }

    @GetMapping("/book/listar")
    public ResponseEntity<List<Book>> listarBook() {
        List<Book> bookList = Optional.ofNullable(bookRepository.findAll()).orElse(new ArrayList<>());
        if (bookList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/autor/listar")
    public ResponseEntity<List<Autor>> listarAutor(){
        List<Autor> autorList = Optional.ofNullable(autorRepository.findAll()).orElse(new ArrayList<>());

        if (autorList.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(autorList);
    }


}
