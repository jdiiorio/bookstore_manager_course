package com.rodrigopeleias.bookstoremanager.service;

import com.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.rodrigopeleias.bookstoremanager.dto.MessageResponseDTO;
import com.rodrigopeleias.bookstoremanager.entity.Book;
import com.rodrigopeleias.bookstoremanager.mapper.BookMapper;
import com.rodrigopeleias.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//onde ficam as regras de negocio, quem conhece de fato a criacao do livro
@Service                            //essa classe sera gerenciada pelo Spring e pode ter controle transacional
public class BookService {

    private BookRepository bookRepository;
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired                                          //fazendo a injecao de dependencia, com o spring data jpa
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {

        //modo antigo com o builder, foi substituido pelo mapper, vai mapear o BookDTO para a entidade Book
        /*Book bookToSave = Book.builder()
                .name(bookDTO.getName())
                .pages(bookDTO.getPages())
                .chapters(bookDTO.getChapters())
                .isbn(bookDTO.getIsbn())
                .publisherName(bookDTO.getPublisherName())
                .author(bookDTO.getAuthor())
                .build();*/

        Book bookToSave = bookMapper.toModel(bookDTO);   //instanciacao completa de uma entidade atraves de um dto

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with id " + savedBook.getId())
                .build();
    }

        public BookDTO findById(Long id) {
            Optional<Book> optionalBook = bookRepository.findById(id);  //optional, se passarmos um livro que existe ou nao no sistema
            return bookMapper.toDTO(optionalBook.get());
        }
}
