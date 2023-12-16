package org.mickael.librarymsbook.service.contract;



import org.mickael.librarymsbook.exception.AuthorNotFoundException;
import org.mickael.librarymsbook.model.Author;

import java.util.List;

public interface AuthorServiceContract {

    List<Author> findAll () throws AuthorNotFoundException;

    Author findById (Integer id) throws AuthorNotFoundException;

    Author save(Author author);

    Author update (Author author) throws AuthorNotFoundException;

    void deleteById (Integer id);

}
