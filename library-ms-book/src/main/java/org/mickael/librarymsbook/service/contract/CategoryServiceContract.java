package org.mickael.librarymsbook.service.contract;



import org.mickael.librarymsbook.exception.CategoryNotFoundException;
import org.mickael.librarymsbook.model.Category;

import java.util.List;

public interface CategoryServiceContract {

    List<Category> findAll () throws CategoryNotFoundException;

    Category findById (Integer id) throws CategoryNotFoundException;

    Category save (Category category);

    Category update (Category category) throws CategoryNotFoundException;

    void deleteById (Integer id);
}
