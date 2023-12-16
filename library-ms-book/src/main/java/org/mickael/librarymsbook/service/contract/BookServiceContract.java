package org.mickael.librarymsbook.service.contract;



import org.mickael.librarymsbook.exception.BookNotFoundException;
import org.mickael.librarymsbook.model.Book;

import java.util.List;

public interface BookServiceContract {
    List<Book> findAll() throws BookNotFoundException;

    Book findById(Integer id) throws BookNotFoundException;

    Book save(Book book);

    Book update(Book book) throws BookNotFoundException;

    void deleteById(Integer id);

    List<Book> findBookBySearchParameter(String criteria, String searchValue) throws BookNotFoundException;





}
