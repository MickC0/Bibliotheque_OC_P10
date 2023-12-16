package org.mickael.librarymsbook.service.impl;


import org.mickael.librarymsbook.exception.EditionNotFoundException;
import org.mickael.librarymsbook.model.Edition;
import org.mickael.librarymsbook.repository.EditionRepository;
import org.mickael.librarymsbook.service.contract.EditionServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditionServiceImpl implements EditionServiceContract {

    private final EditionRepository editionRepository;

    @Autowired
    public EditionServiceImpl(EditionRepository editionRepository) {
        this.editionRepository = editionRepository;
    }

    @Override
    public List<Edition> findAll() throws EditionNotFoundException {
        List<Edition> editions = editionRepository.findAll();
        if (editions.isEmpty()){
            throw new EditionNotFoundException("No edition found");
        }
        return editions;
    }

    @Override
    public Edition findById(Integer id) throws EditionNotFoundException {
        Optional<Edition> optionalEdition = editionRepository.findById(id);
        if (!optionalEdition.isPresent()){
            throw new EditionNotFoundException("Edition not found in repository");
        }
        return optionalEdition.get();
    }

    @Override
    public Edition save(Edition edition) {
        Edition savedEdition = editionRepository.save(edition);

        return savedEdition;
    }

    @Override
    public Edition update(Edition edition) throws EditionNotFoundException{
        Optional<Edition> optionalEdition = editionRepository.findById(edition.getId());
        if (!optionalEdition.isPresent()){
            throw new EditionNotFoundException("Edition not found in repository");
        }
        return editionRepository.save(edition);
    }

    @Override
    public void deleteById(Integer id) {
        editionRepository.deleteById(id);
    }

}
