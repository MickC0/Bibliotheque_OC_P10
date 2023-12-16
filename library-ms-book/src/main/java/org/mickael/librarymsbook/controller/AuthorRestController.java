package org.mickael.librarymsbook.controller;

import org.mickael.librarymsbook.exception.AuthorNotFoundException;
import org.mickael.librarymsbook.model.Author;
import org.mickael.librarymsbook.service.contract.AuthorServiceContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
//@PreAuthorize("isAuthenticated()")
public class AuthorRestController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorRestController.class);
    private final AuthorServiceContract authorServiceContract;

    @Autowired
    public AuthorRestController(AuthorServiceContract authorServiceContract) {
        this.authorServiceContract = authorServiceContract;
    }

    @GetMapping
    public List<Author> getAuthors(){
        try {
            return authorServiceContract.findAll();
        } catch (AuthorNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Authors found", ex);
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author retrieveAuthor(@PathVariable Integer id){
        logger.debug("Get author by id : " + id);
        try {
            return authorServiceContract.findById(id);
        } catch (AuthorNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found", ex);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Void> createNewAuthor(@Valid @RequestBody Author newAuthor){
        if (newAuthor == null){
            return ResponseEntity.noContent().build();
        }

        Author authorToSave = authorServiceContract.save(newAuthor);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(authorToSave.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Author updateAuthor(@PathVariable Integer id, @RequestBody Author author){
        try {
            return authorServiceContract.update(author);
        } catch (AuthorNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Author ID", ex);
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('DELETE')")
    public void deleteAuthor(@PathVariable Integer id){
        authorServiceContract.deleteById(id);
    }


}
