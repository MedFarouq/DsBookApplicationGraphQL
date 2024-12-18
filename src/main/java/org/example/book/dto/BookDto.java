package org.example.book.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class BookDto {
    private String titre;
    private String publisher;
    private Date datePublication;
    private Float price;
    private String resume;
}
