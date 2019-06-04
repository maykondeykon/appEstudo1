create table autor_book (
    autor_id int not null,
    book_id int not null,
    primary key (autor_id, book_id)
)