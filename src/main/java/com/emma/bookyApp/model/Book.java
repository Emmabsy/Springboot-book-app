package com.emma.bookyApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name ="booky")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String title;
    private String author;
    private String isbn;
    private String description;
    private double price;
    private int year;
    @Column(name = "quantity")
    private int quantity;
}
