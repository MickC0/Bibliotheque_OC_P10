package org.mickael.librarymsbook.service.contract;


import org.mickael.librarymsbook.exception.CopyNotFoundException;
import org.mickael.librarymsbook.model.Copy;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CopyServiceContract {

    List<Copy> findAll () throws CopyNotFoundException;

    List<Copy> findAllCopyAvailableForOneBook(@Param("id") Integer id) throws CopyNotFoundException;

    List<Copy> findAllCopyForOneBook(@Param("id") Integer id) throws CopyNotFoundException;

    List<Copy> findAllBySearchParameter (String criteria, String searchValue, boolean available) throws CopyNotFoundException;

    Copy findById (Integer id) throws CopyNotFoundException;

    Copy save (Copy copy);

    Copy update (Copy copy) throws CopyNotFoundException;

    void deleteById (Integer id);

    void updateAvailableCopy(Integer id) throws CopyNotFoundException;

    Integer getNumberOfAvailableCopiesForOneBook(Integer bookId);
    Integer getNumberOfCopiesForOneBook(Integer bookId);

}
