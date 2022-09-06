package com.rodrigopeleias.bookstoremanager.mapper;

import com.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.rodrigopeleias.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
                                                                //a interface sera criada atraves de uma unica constante
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);  //fazer a instanciacao do mapper dentro da interface,

    Book toModel(BookDTO bookDTO);                             //converte o BookDTO para a entidade Book

    BookDTO toDTO(Book book);
}
