package org.mickael.librarymsbook.controller;

import org.mickael.librarymsbook.exception.CoverNotFoundException;
import org.mickael.librarymsbook.model.Cover;
import org.mickael.librarymsbook.service.contract.CoverServiceContract;
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
@RequestMapping("/api/covers")
//@PreAuthorize("isAuthenticated()")
public class CoverRestController {

    private static final Logger logger = LoggerFactory.getLogger(CoverRestController.class);
    private final CoverServiceContract coverServiceContract;

    @Autowired
    public CoverRestController(CoverServiceContract coverServiceContract) {
        this.coverServiceContract = coverServiceContract;
    }

    @GetMapping
    public List<Cover> getCovers(){
        try {
            return coverServiceContract.findAll();
        } catch (CoverNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Covers found", ex);
        }
    }

    @GetMapping("/{id}")
    public Cover retrieveCover(@PathVariable Integer id){
        logger.debug("Get cover by id : " + id);
        try {
            return coverServiceContract.findById(id);
        } catch (CoverNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cover not found", ex);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Cover> createNewCover(@Valid @RequestBody Cover newCover){
        if (newCover == null){
            return ResponseEntity.noContent().build();
        }
        Cover coverSaved = coverServiceContract.save(newCover);
        URI location = ServletUriComponentsBuilder
                               .fromCurrentRequest()
                               .path("/{id}")
                               .buildAndExpand(coverSaved.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Cover updateCover(@PathVariable Integer id, @RequestBody Cover cover){
        try {
            return coverServiceContract.update(cover);
        } catch (CoverNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Cover ID", ex);
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('DELETE')")
    public void deleteCover(@PathVariable Integer id){
        coverServiceContract.deleteById(id);
    }


}
