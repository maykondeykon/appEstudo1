package com.mkdk.app.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "autor_book")
public class AutorBook implements Serializable {
    private static final long serialVersionUID = 7182173461704256878L;

    @Column(name = "autor_id")
    private Integer autorId;

    @Column(name = "book_id")
    private Integer bookId;
}
