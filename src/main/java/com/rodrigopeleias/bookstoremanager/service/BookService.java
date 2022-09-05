package com.rodrigopeleias.bookstoremanager.service;

import com.rodrigopeleias.bookstoremanager.dto.MessageResponseDTO;
import com.rodrigopeleias.bookstoremanager.entity.Book;
import com.rodrigopeleias.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

                                    //onde ficam as regras de negocio, quem conhece de fato a criacao do livro
@Service                            //essa classe sera gerenciada pelo Spring e pode ter controle transacional
public class BookService {

    private BookRepository bookRepository;

    @Autowired                                          //fazendo a injecao de dependencia, com o spring data jpa
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book) {
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with id " + savedBook.getId())
                .build();
    }
}
