package org.example.book;

import org.example.book.dto.BookDto;
import org.example.book.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(BookService bookService) {
        return  args -> {
            bookService.saveBooks(
                    List.of(
                            BookDto.builder().titre("Book1").publisher("pub1").datePublication(new Date(2023, 10, 15)).price(123f).resume("resume1").build(),
                            BookDto.builder().titre("Book2").publisher("pub2").datePublication(new Date(2023, 10, 15)).price(234f).resume("resume2").build(),
                            BookDto.builder().titre("Book3").publisher("pub3").datePublication(new Date(2023, 10, 15)).price(345f).resume("resume3").build(),
                            BookDto.builder().titre("Book4").publisher("pub4").datePublication(new Date(2023, 10, 15)).price(456f).resume("resume4").build()
                    )
            );
        };
    }
}

