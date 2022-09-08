package com.rodrigopeleias.bookstoremanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data                   //gera os getter, setter, hashcode e tostring em tempo de compilacao
@Builder                //possibilidade construir objetos com o builder
@NoArgsConstructor      //gera construtor sem argumentos
@AllArgsConstructor     //gera construtor com argumentos
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private Integer chapters;

    @Column(nullable = false)
    private String isbn;

    @Column(name = "publisher_name", nullable = false, unique = true)
    private String publisherName;

    //um livro vai ter um autor e um autor varios livros
    //Lazy, toda vez que consultarmos um livro, ele vai fazer um join com o autor
    //Cascade, toda vez que inserir, remover ou atualizar um livro o mesmo é feito com o autor
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "author_id")
    private Author author;
}