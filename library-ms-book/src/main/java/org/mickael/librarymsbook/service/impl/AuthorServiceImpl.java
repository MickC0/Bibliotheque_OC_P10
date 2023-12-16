package org.mickael.librarymsbook.service.impl;



import org.mickael.librarymsbook.exception.AuthorNotFoundException;
import org.mickael.librarymsbook.model.Author;
import org.mickael.librarymsbook.repository.AuthorRepository;
import org.mickael.librarymsbook.service.contract.AuthorServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorServiceContract {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() throws AuthorNotFoundException {
        List<Author> authors = authorRepository.findAll();
        if (authors.isEmpty()){
            throw new AuthorNotFoundException("No author found");
        }
        return authors;
    }

    @Override
    public Author findById(Integer id) throws AuthorNotFoundException {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (!optionalAuthor.isPresent()){
            throw new AuthorNotFoundException("Author not found in repository");
        }
        return optionalAuthor.get();
    }

    @Override
    public Author save(Author author){
        Author savedAuthor = authorRepository.save(author);
        return savedAuthor;
    }

    @Override
    public Author update(Author author) throws AuthorNotFoundException{
        Optional<Author> optionalAuthor = authorRepository.findById(author.getId());
        if (!optionalAuthor.isPresent()){
            throw new AuthorNotFoundException("Author not found in repository");
        }
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }

}
