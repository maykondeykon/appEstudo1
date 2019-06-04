package com.mkdk.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = -8715946578632956113L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @ManyToMany(mappedBy = "books")
    private Set<Autor> autores;


}
