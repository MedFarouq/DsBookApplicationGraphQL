package org.example.book.service;

import org.example.book.dto.BookDto;

import java.util.List;

public interface BookService {
    public BookDto saveBook(BookDto bookDto);
    public boolean deleteBook(Long id);
    public List<BookDto> getBookByTitre(String titre);
    public List<BookDto> getBookByTitreAndPublisher(String titre, String publisher);
    public List<BookDto> saveBooks(List<BookDto> bookDtos);

}
