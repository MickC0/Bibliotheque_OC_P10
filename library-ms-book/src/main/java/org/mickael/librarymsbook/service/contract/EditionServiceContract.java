package org.mickael.librarymsbook.service.contract;



import org.mickael.librarymsbook.exception.EditionNotFoundException;
import org.mickael.librarymsbook.model.Edition;

import java.util.List;

public interface EditionServiceContract {

    List<Edition> findAll () throws EditionNotFoundException;

    Edition findById (Integer id) throws EditionNotFoundException;

    Edition save (Edition edition);

    Edition update (Edition edition) throws EditionNotFoundException;

    void deleteById (Integer id);
}
