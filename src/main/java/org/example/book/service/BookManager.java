package org.example.book.service;

import lombok.AllArgsConstructor;
import org.example.book.dao.entities.Book;
import org.example.book.dao.repositories.BookRepository;
import org.example.book.dto.BookDto;
import org.example.book.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookManager implements BookService {
    BookRepository bookRepository;
    BookMapper bookMapper;
    @Override
    public BookDto saveBook(BookDto bookDto) {
        Book book = bookMapper.fromBookDtoToBook(bookDto);
        book = bookRepository.save(book);
        bookDto = bookMapper.fromBookToBookDto(book);
        return bookDto;
    }

    @Override
    public boolean deleteBook(Long id) {
        try{
            bookRepository.deleteById(id);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public List<BookDto> getBookByTitre(String titre) {
        List<Book> books = bookRepository.findByTitre(titre);
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : books) {
            BookDto bookDto = bookMapper.fromBookToBookDto(book);
        }
        return bookDtos;
    }

    @Override
    public List<BookDto> getBookByTitreAndPublisher(String titre, String publisher) {
        List<Book> books = bookRepository.findByTitreAndPublisher(titre, publisher);
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : books) {
            BookDto bookDto = bookMapper.fromBookToBookDto(book);
        }
        return bookDtos;
    }

    @Override
    public List<BookDto> saveBooks(List<BookDto> bookDtos) {
        List<Book> books = new ArrayList<>();
        for(BookDto bookDto : bookDtos) {
            Book book = bookMapper.fromBookDtoToBook(bookDto);
        }
        books = bookRepository.saveAll(books);

        bookDtos = new ArrayList<>();
        for(Book book : books) {
            bookDtos.add(bookMapper.fromBookToBookDto(book));
        }
        return bookDtos;
    }
}
