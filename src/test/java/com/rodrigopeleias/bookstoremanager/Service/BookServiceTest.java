package com.rodrigopeleias.bookstoremanager.Service;

import com.rodrigopeleias.bookstoremanager.repository.BookRepository;
import com.rodrigopeleias.bookstoremanager.service.BookService;
import com.rodrigopeleias.bookstoremanager.utils.BookUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void whenGiveExistingIdThenReturnThisBook(){
        //trabalhar aqui
    }


}
