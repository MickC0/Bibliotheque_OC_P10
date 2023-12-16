package org.mickael.librarymsbook.controller;

import org.mickael.librarymsbook.exception.CopyNotFoundException;
import org.mickael.librarymsbook.model.Copy;
import org.mickael.librarymsbook.service.contract.CopyServiceContract;
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
@RequestMapping("/api/copies")
@PreAuthorize("isAuthenticated()")
public class CopyRestController {

    private static final Logger logger = LoggerFactory.getLogger(CopyRestController.class);
    private final CopyServiceContract copyServiceContract;

    @Autowired
    public CopyRestController(CopyServiceContract copyServiceContract) {
        this.copyServiceContract = copyServiceContract;
    }

    @GetMapping
    public List<Copy> getCopies(){
        try {
            return copyServiceContract.findAll();
        } catch (CopyNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Copies found", ex);
        }
    }

    @GetMapping("/available/{id}")
    public List<Copy> getCopiesAvailableForOneBook(@PathVariable Integer id){
        try {
            return copyServiceContract.findAllCopyAvailableForOneBook(id);
        } catch (CopyNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Copies found", ex);
        }
    }

    @GetMapping("/book/{id}")
    public List<Copy> getCopiesForOneBook(@PathVariable Integer id){
        try {
            return copyServiceContract.findAllCopyForOneBook(id);
        } catch (CopyNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Copies found", ex);
        }
    }


    @GetMapping("/search")
    public List<Copy> getCopiesBySearchValue(@RequestParam(value = "criteria", required = false) String criteria,
                                             @RequestParam(value = "searchValue", required = false) String searchValue,
                                             @RequestParam(value = "available", required = false) boolean available){
        try {
            return copyServiceContract.findAllBySearchParameter(criteria, searchValue, available);
        } catch (CopyNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Copies found", ex);
        }
    }

    @GetMapping("/{id}")
    public Copy retrieveCopy(@PathVariable Integer id){
        logger.debug("Get copy by id : " + id);
        try {
            return copyServiceContract.findById(id);
        } catch (CopyNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Copy not found", ex);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Copy> createNewCopy(@Valid @RequestBody Copy newCopy){
        if (newCopy == null){
            return ResponseEntity.noContent().build();
        }
        Copy copySaved = copyServiceContract.save(newCopy);
        URI location = ServletUriComponentsBuilder
                               .fromCurrentRequest()
                               .path("/{id}")
                               .buildAndExpand(copySaved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Copy updateCopy(@PathVariable Integer id, @RequestBody Copy copy){
        try {
            return copyServiceContract.update(copy);
        } catch (CopyNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Copy ID", ex);
        }
    }

    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLoanCopy(@PathVariable Integer id){
        try {
            copyServiceContract.updateAvailableCopy(id);
        } catch (CopyNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Copy ID", ex);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public void deleteCopy(@PathVariable Integer id){
        copyServiceContract.deleteById(id);
    }

    @GetMapping("/available/book/{bookId}")
    public boolean checkIfCopyAvailableForBook(@PathVariable Integer bookId){
        List<Copy> copies = copyServiceContract.findAllCopyAvailableForOneBook(bookId);
        if (!copies.isEmpty()){
            return true;
        }
        return false;
    }

    @GetMapping("/available-number/book/{bookId}")
    public Integer numberOfCopyAvailableForBook(@PathVariable Integer bookId){
        Integer number = copyServiceContract.getNumberOfAvailableCopiesForOneBook(bookId);
        return number;
    }

    @GetMapping("/exist-number/book/{bookId}")
    public Integer numberOfCopyForBook(@PathVariable Integer bookId){
        Integer number = copyServiceContract.getNumberOfCopiesForOneBook(bookId);
        return number;
    }


}
