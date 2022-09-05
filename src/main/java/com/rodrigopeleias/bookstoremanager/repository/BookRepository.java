package com.rodrigopeleias.bookstoremanager.repository;

/**criacao da classe de gerenciamento da entidade com o banco de dados, implementa o padrão dao, Biblioteca Spring Data JPA
 * @author Juliano Di Iorio
 * @version 1.00
 * @since Release 01 da aplicação
 */

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {                 //informa entidade e o tipo de dado do id

}
