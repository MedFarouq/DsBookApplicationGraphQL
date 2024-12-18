package org.example.book.mapper;

import org.example.book.dao.entities.Book;
import org.example.book.dto.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class BookMapper {

    private final ModelMapper mapper = new ModelMapper();
     public BookDto fromBookToBookDto(Book book) {
         return mapper.map(book, BookDto.class);
     }
     public Book fromBookDtoToBook(BookDto bookDto) {
         return mapper.map(bookDto, Book.class);
     }


}
