package org.mickael.librarymsbook.controller;

import org.mickael.librarymsbook.exception.EditionNotFoundException;
import org.mickael.librarymsbook.model.Edition;
import org.mickael.librarymsbook.service.contract.EditionServiceContract;
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
@RequestMapping("/api/editions")
//@PreAuthorize("isAuthenticated()")
public class EditionRestController {

    private static final Logger logger = LoggerFactory.getLogger(EditionRestController.class);
    private final EditionServiceContract editionServiceContract;

    @Autowired
    public EditionRestController(EditionServiceContract editionServiceContract) {
        this.editionServiceContract = editionServiceContract;
    }

    @GetMapping
    public List<Edition> getEditions(){
        try {
            return editionServiceContract.findAll();
        } catch (EditionNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Editions found", ex);
        }
    }

    @GetMapping("/{id}")
    public Edition retrieveEdition(@PathVariable Integer id){
        logger.debug("Get edition by id : " + id);
        try {
            return editionServiceContract.findById(id);
        } catch (EditionNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Edition not found", ex);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Edition> createNewEdition(@Valid @RequestBody Edition newEdition){
        if (newEdition == null){
            return ResponseEntity.noContent().build();
        }
        Edition editionSaved = editionServiceContract.save(newEdition);
        URI location = ServletUriComponentsBuilder
                               .fromCurrentRequest()
                               .path("/{id}")
                               .buildAndExpand(editionSaved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Edition updateEdition(@PathVariable Integer id, @RequestBody Edition edition){
        try {
            return editionServiceContract.update(edition);
        } catch (EditionNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Edition ID", ex);
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('DELETE')")
    public void deleteEdition(@PathVariable Integer id){
        editionServiceContract.deleteById(id);
    }


}
