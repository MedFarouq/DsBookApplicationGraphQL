package org.example.book.web;

import lombok.AllArgsConstructor;
import org.example.book.dto.BookDto;
import org.example.book.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@AllArgsConstructor
public class BookGraphQLController {

    private BookService bookService;

    @MutationMapping
    public BookDto saveBook(BookDto book) {
        return bookService.saveBook(book);
    }
    @MutationMapping
    public boolean deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }

    @QueryMapping
    public List<BookDto> getBookByTitre(@Argument String titre) {
        return bookService.getBookByTitre(titre);
    }

    @QueryMapping
    public List<BookDto> getBookByTitleAndPublicher(@Argument String titre, @Argument String publisher) {
        return bookService.getBookByTitreAndPublisher(titre, publisher);
    }

}