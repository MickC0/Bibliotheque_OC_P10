package org.mickael.librarymsbook.service.impl;


import org.mickael.librarymsbook.exception.CopyNotFoundException;
import org.mickael.librarymsbook.model.Copy;
import org.mickael.librarymsbook.repository.CopyRepository;
import org.mickael.librarymsbook.service.contract.CopyServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CopyServiceImpl implements CopyServiceContract {

    private final CopyRepository copyRepository;

    @Autowired
    public CopyServiceImpl(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    @Override
    public List<Copy> findAll() throws CopyNotFoundException {
        List<Copy> copies = copyRepository.findAll();
        if (copies.isEmpty()){
            throw new CopyNotFoundException("No copy found");
        }
        return copies;
    }

    @Override
    public List<Copy> findAllCopyAvailableForOneBook(Integer id) throws CopyNotFoundException {
        List<Copy> copies = new ArrayList<>();
        copies = copyRepository.findAllCopyAvailableForOneBook(id);
        if (copies.isEmpty()){
            throw new CopyNotFoundException("No copy found");
        }
        return copies;
    }

    @Override
    public List<Copy> findAllCopyForOneBook(Integer bookId) throws CopyNotFoundException {
        List<Copy> copies = new ArrayList<>();
        copies = copyRepository.findAllCopyForOneBook(bookId);
        if (copies.isEmpty()){
            throw new CopyNotFoundException("No copy found");
        }
        return copies;
    }

    @Override
    public List<Copy> findAllBySearchParameter(String criteria, String searchValue, boolean available) throws CopyNotFoundException {
        List<Copy> copies = new ArrayList<>();
        if (available && criteria.equalsIgnoreCase("") && searchValue.equalsIgnoreCase("")) {
            copies = copyRepository.findAllByAvailable(available);
        }
        if (available && criteria.equalsIgnoreCase("author")){
/*            String[] splitted = StringUtils.split(criteria," ");
            String lastName = splitted[0];
            String firstName = splitted[1];*/
            copies = copyRepository.findByAuthorSearchValue(searchValue, available);
        }
        if (available && criteria.equalsIgnoreCase("title")){
            copies = copyRepository.findByTitleSearchValue(searchValue, available);
        }
        if (copies.isEmpty()){
            throw new CopyNotFoundException("No copy found with this " + criteria);
        }
        return copies;
    }

    @Override
    public Copy findById(Integer id) throws CopyNotFoundException {
        Optional<Copy> optionalCopy = copyRepository.findById(id);
        if (!optionalCopy.isPresent()){
            throw new CopyNotFoundException("Copy not found in repository");
        }
        return optionalCopy.get();
    }

    @Override
    public Copy save(Copy copy) {

        Copy savedCopy = copyRepository.save(copy);

        return savedCopy;
    }

    @Override
    public Copy update(Copy copy) throws CopyNotFoundException{
        Optional<Copy> optionalCopy = copyRepository.findById(copy.getId());
        if (!optionalCopy.isPresent()){
            throw new CopyNotFoundException("Copy not found in repository");
        }
        return copyRepository.save(copy);
    }

    @Override
    public void deleteById(Integer id) {
        copyRepository.deleteById(id);
    }

    @Override
    public void updateAvailableCopy(Integer id) throws CopyNotFoundException{
        Optional<Copy> optionalCopy = copyRepository.findById(id);
        if (!optionalCopy.isPresent()){
            throw new CopyNotFoundException("Copy not found in repository");
        }
        Copy copy = optionalCopy.get();
        if (copy.isAvailable()){
            copy.setAvailable(false);
        } else {
            copy.setAvailable(true);
        }
        copyRepository.save(copy);
    }

    @Override
    public Integer getNumberOfAvailableCopiesForOneBook(Integer bookId) {
        return copyRepository.findAllCopiesAvailabeForOneBook(bookId);
    }

    @Override
    public Integer getNumberOfCopiesForOneBook(Integer bookId) {
        return copyRepository.findAllCopiesForOneBook(bookId);
    }

}
