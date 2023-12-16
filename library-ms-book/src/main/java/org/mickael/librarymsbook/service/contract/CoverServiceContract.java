package org.mickael.librarymsbook.service.contract;



import org.mickael.librarymsbook.exception.CoverNotFoundException;
import org.mickael.librarymsbook.model.Cover;

import java.util.List;

public interface CoverServiceContract {

    List<Cover> findAll() throws CoverNotFoundException;

    Cover findById (Integer id) throws CoverNotFoundException;

    Cover save (Cover cover);

    Cover update (Cover cover) throws CoverNotFoundException;

    void deleteById (Integer id);
}
