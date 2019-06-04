package com.mkdk.app.controller;

import com.mkdk.app.model.Autor;
import com.mkdk.app.repository.AutorRepository;
import com.mkdk.app.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AppControllerWithMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private AutorRepository autorRepository;

    @Test
    public void listarBook() throws Exception {
        Autor autor = new Autor();
        autor.setId(1);
        autor.setNome("Patrick Rothfuss");

        List<Autor> autorList = Arrays.asList(autor);
        given(autorRepository.findAll()).willReturn(autorList);

        mockMvc.perform(get("/autor/listar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json("[{'id': 1, 'nome': 'Patrick Rothfuss'}]"));
    }
}