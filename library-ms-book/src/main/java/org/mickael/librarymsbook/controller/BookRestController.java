package org.mickael.librarymsbook.controller;

import org.mickael.librarymsbook.exception.BookNotFoundException;
import org.mickael.librarymsbook.model.Book;
import org.mickael.librarymsbook.service.contract.BookServiceContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@PreAuthorize("isAuthenticated()")
public class BookRestController {

    private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);
    private final BookServiceContract bookServiceContract;

    @Autowired
    public BookRestController(BookServiceContract bookServiceContract) {
        this.bookServiceContract = bookServiceContract;
    }

    @GetMapping
    public List<Book> getBooks(){
        try {
            return bookServiceContract.findAll();
        } catch (BookNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Books found", ex);
        }
    }

    @GetMapping("/search")
    public List<Book> getBooksBySearchValue(@RequestParam(value = "criteria", required = false) String criteria,
                                            @RequestParam(value = "searchValue", required = false) String searchValue){
        try {
            return bookServiceContract.findBookBySearchParameter(criteria, searchValue);
        } catch (BookNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Books found", ex);
        }
    }

    @GetMapping("/{id}")
    public Book retrieveBook(@PathVariable Integer id){
        logger.debug("Get book by id : " + id);
        try {
            return bookServiceContract.findById(id);
        } catch (BookNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found", ex);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Book> createNewBook(@Valid @RequestBody Book newBook){
        if (newBook == null){
            return ResponseEntity.noContent().build();
        }
        Book bookSaved = bookServiceContract.save(newBook);
        URI location = ServletUriComponentsBuilder
                               .fromCurrentRequest()
                               .path("/{id}")
                               .buildAndExpand(bookSaved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book){
        try {
            return bookServiceContract.update(book);
        } catch (BookNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Book ID", ex);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public void deleteBook(@PathVariable Integer id){
        bookServiceContract.deleteById(id);
    }


}
