package org.mickael.librarymsbook.service.impl;


import org.mickael.librarymsbook.exception.CoverNotFoundException;
import org.mickael.librarymsbook.model.Cover;
import org.mickael.librarymsbook.repository.CoverRepository;
import org.mickael.librarymsbook.service.contract.CoverServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoverServiceImpl implements CoverServiceContract {

    private final CoverRepository coverRepository;

    @Autowired
    public CoverServiceImpl(CoverRepository coverRepository) {
        this.coverRepository = coverRepository;
    }

    @Override
    public List<Cover> findAll() throws CoverNotFoundException {
        List<Cover> covers = coverRepository.findAll();
        if (covers.isEmpty()){
            throw new CoverNotFoundException("No cover found");
        }
        return covers;
    }

    @Override
    public Cover findById(Integer id) throws CoverNotFoundException {
        Optional<Cover> optionalCover = coverRepository.findById(id);
        if (!optionalCover.isPresent()){
            throw new CoverNotFoundException("Cover not found in repository");
        }
        return optionalCover.get();
    }

    @Override
    public Cover save(Cover cover) {

        Cover savedCover = coverRepository.save(cover);

        return savedCover;
    }

    @Override
    public Cover update(Cover cover) throws CoverNotFoundException{
        Optional<Cover> optionalCover = coverRepository.findById(cover.getId());
        if (!optionalCover.isPresent()){
            throw new CoverNotFoundException("Cover not found in repository");
        }
        return coverRepository.save(cover);
    }

    @Override
    public void deleteById(Integer id) {
        coverRepository.deleteById(id);
    }

}
