package com.rodrigopeleias.bookstoremanager.controller;

/**criacao da classe de gerenciamento da entidade com o banco de dados, implementa o padrão dao, Biblioteca Spring Data JPA
 * @author Juliano Di Iorio
 * @version 1.00
 * @since Release 01 da aplicação
 */

import com.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.rodrigopeleias.bookstoremanager.dto.MessageResponseDTO;
import com.rodrigopeleias.bookstoremanager.exception.BookNotFoundException;
import com.rodrigopeleias.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController                                                       //para o Spring essa classe vai representar um controller, sera uma api rest
@RequestMapping("/api/v1/books")                                      //indica o endereço da aplicação, endpoint
public class BookController {

    private BookService bookService;

    @Autowired                                                      //injetando dependencia do BookService
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping                        //operacao do tipo POST
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {       //criando o metodo que cadastra o livro e devolve um objeto de transferencia de dados
       return bookService.create(bookDTO);                             //delegando para o service criar o livro, sera de responsabilidade dela
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponseDTO deleteBook(@PathVariable Long id)
    {
        return bookService.delete(id);
    }
}
