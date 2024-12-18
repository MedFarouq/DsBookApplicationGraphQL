package org.example.book.dao.repositories;

import org.example.book.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitre(String titre);
    List<Book> findByTitreAndPublisher(String titre, String publisher);
}
